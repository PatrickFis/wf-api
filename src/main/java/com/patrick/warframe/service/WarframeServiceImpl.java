package com.patrick.warframe.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.patrick.warframe.data.MissionReward;
import com.patrick.warframe.deserializers.LocalDateTimeDeserializer;
import com.patrick.warframe.deserializers.MissionRewardDeserializer;
import com.patrick.warframe.deserializers.WarframeSolNodesDeserializer;
import com.patrick.warframe.enums.WarframeEndpoints;
import com.patrick.warframe.service_interface.WarframeService;
import com.patrick.warframe.wikiexports.WarframeAlert;
import com.patrick.warframe.wikiexports.WarframeEvent;
import com.patrick.warframe.wikiexports.WarframeGear;
import com.patrick.warframe.wikiexports.WarframeResources;
import com.patrick.warframe.wikiexports.WarframeSolNodes;
import com.patrick.warframe.wikiexports.WarframeUpgrades;
import com.patrick.warframe.wikiexports.WarframeWeapon;
import com.patrick.warframe.wikiexports.Warframes;

public class WarframeServiceImpl implements WarframeService, Serializable {

	private static final long serialVersionUID = 6333759256496605333L;

	private static final Logger logger = Logger.getLogger(WarframeServiceImpl.class.getName());
	
	private static final File jbossDataDirectory = new File(System.getProperty("jboss.server.data.dir"));
	
	@Override
	public Collection<WarframeEvent> getWarframeEvents() {
		JsonElement elements = getResponseFromEndpoint(WarframeEndpoints.WORLD_DATA.getEndpoint());
		Collection<WarframeEvent> events = getWarframeEvent(elements);
		return events;
	}
	
	@Override
	public Collection<WarframeAlert> getWarframeAlerts() {
		JsonElement elements = getResponseFromEndpoint(WarframeEndpoints.WORLD_DATA.getEndpoint());
		Collection<WarframeAlert> alerts = getAlerts(elements);
		return alerts;
	}
	
	@Override
	public Collection<WarframeWeapon> getWarframeWeapons() {
//		JsonElement elements = getResponseFromEndpoint(WarframeEndpoints.WEAPONS.getEndpoint());
//		Collection<WarframeWeapon> weapons = getWeapons(elements);
//		JsonElement test = getResponseFromEndpoint(WarframeEndpoints.ALTERNATE_MELEE_WEAPONS.getEndpoint());
		
		Collection<WarframeWeapon> weapons = getWeapons(getResponseFromEndpoint(WarframeEndpoints.ALTERNATE_MELEE_WEAPONS.getEndpoint()));
		weapons.addAll(getWeapons(getResponseFromEndpoint(WarframeEndpoints.ALTERNATE_PRIMARY_WEAPONS.getEndpoint())));
		weapons.addAll(getWeapons(getResponseFromEndpoint(WarframeEndpoints.ALTERNATE_SECONDARY_WEAPONS.getEndpoint())));
		return weapons;
	}

	@Override
	public Collection<WarframeGear> getWarframeGear() {
		JsonElement elements = getResponseFromEndpoint(WarframeEndpoints.GEAR.getEndpoint());
		Collection<WarframeGear> gear = getGear(elements);
		return gear;
	}

	@Override
	public Collection<WarframeResources> getWarframeResources() {
		JsonElement elements = getResponseFromEndpoint(WarframeEndpoints.RESOURCES.getEndpoint());
		Collection<WarframeResources> resources = getResources(elements);
		return resources;
	}

	@Override
	public Collection<WarframeUpgrades> getWarframeUpgrades() {
		JsonElement elements = getResponseFromEndpoint(WarframeEndpoints.UPGRADES.getEndpoint());
		Collection<WarframeUpgrades> upgrades = getUpgrades(elements);
		return upgrades;
	}

	@Override
	public Collection<Warframes> getWarframes() {
		JsonElement elements = getResponseFromEndpoint(WarframeEndpoints.WARFRAMES.getEndpoint());
		return getWarframes(elements);
	}
	
	@Override
	public Collection<WarframeSolNodes> getWarframeSolNodes() {
		return getWarframeSolNodes(getResponseFromEndpoint(WarframeEndpoints.WORLDSTATE_SOL_NODES.getEndpoint()));
	}
	
	@Override
	public String getImageForWeapon(WarframeWeapon weapon) {
		String image = getImage(weapon.getAlternateImageFileName(), false);
		if(StringUtils.isEmpty(image)) {
			image = getImage(weapon.getImageFileName(), false);
		}
		return image;
	}
	
	// Caching images locally to save bandwidth. There are some weapons that do not follow the naming convention
	// of the other weapons, so their images are not shown.
	private String getImage(String fileName, boolean skipFetchingNewImages) {
		// https://stackoverflow.com/questions/9468045/reading-writing-a-text-file-in-a-servlet-where-should-this-file-be-stored-in-jb/
		File imageFile = new File(jbossDataDirectory, fileName);

		if (imageFile.exists()) {
			return "images/" + fileName;
		} else if(!skipFetchingNewImages) {
			try (InputStream in = new URL("https://raw.githubusercontent.com/wfcd/warframe-items/development/data/img/"
					+ fileName).openStream()) {
				// Note: Files is from Guava
				Files.write(ByteStreams.toByteArray(in), imageFile);
				return "images/" + fileName;
			} catch (IOException e) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	private JsonElement getResponseFromEndpoint(String endpoint) {
		try {
			URL warframeEndpoint = new URL(endpoint);
			URLConnection warframeConnection = warframeEndpoint.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(warframeConnection.getInputStream()));
			StringBuilder buffer = new StringBuilder();
			while(true) {
				String line = reader.readLine();
				if(StringUtils.isEmpty(line)) {
					break;
				}
				buffer.append(line);
			}
			return getJsonAsElement(buffer.toString());
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private JsonElement getJsonAsElement(String response) {
		JsonParser jsonParser = new JsonParser();
		return jsonParser.parse(response);
	}
	
	private Collection<WarframeEvent> getWarframeEvent(JsonElement element) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer()).create();
		// https://stackoverflow.com/questions/9598707/gson-throwing-expected-begin-object-but-was-begin-array
		// Have to tell GSON what type we're expecting to get back
		Type collectionType = new TypeToken<Collection<WarframeEvent>>() {}.getType();
		return gson.fromJson(element.getAsJsonObject().get("Events"), collectionType);
	}
	
	private Collection<WarframeAlert> getAlerts(JsonElement element) {
		Type collectionType = new TypeToken<Collection<WarframeAlert>>() {}.getType();
		Map<Class, JsonDeserializer> deserializers = new HashMap<>();
		deserializers.put(LocalDateTime.class, new LocalDateTimeDeserializer());
		deserializers.put(MissionReward.class, new MissionRewardDeserializer());
		return getCollectionFromJson(element, collectionType, "Alerts", deserializers);
	}
	
	private Collection<WarframeWeapon> getWeapons(JsonElement element) {
		Type collectionType = new TypeToken<Collection<WarframeWeapon>>() {}.getType();
		return getCollectionFromJson(element, collectionType, null, null);
	}
	
	private Collection<WarframeGear> getGear(JsonElement element) {
		Type collectionType = new TypeToken<Collection<WarframeGear>>() {}.getType();
		return getCollectionFromJson(element, collectionType, "ExportGear", null);
	}
	
	private Collection<WarframeResources> getResources(JsonElement element) {
		Type collectionType = new TypeToken<Collection<WarframeResources>>() {}.getType();
		return getCollectionFromJson(element, collectionType, "ExportResources", null);
	}
	
	private Collection<WarframeUpgrades> getUpgrades(JsonElement element) {
		Type collectionType = new TypeToken<Collection<WarframeUpgrades>>() {}.getType();
		return getCollectionFromJson(element, collectionType, "ExportUpgrades", null);
	}
	
	private Collection<Warframes> getWarframes(JsonElement element) {
		Type collectionType = new TypeToken<Collection<Warframes>>() {}.getType();
		return getCollectionFromJson(element, collectionType, "ExportWarframes", null);
	}
	
	private Collection<WarframeSolNodes> getWarframeSolNodes(JsonElement element) {
		TypeToken<Collection<WarframeSolNodes>> typeToken = new TypeToken<Collection<WarframeSolNodes>>() {};
		Type type = new TypeToken<Collection<WarframeSolNodes>>() {}.getType();
		Map<Class, JsonDeserializer> deserializers = new HashMap<>();
		deserializers.put(typeToken.getRawType(), new WarframeSolNodesDeserializer());
		return getCollectionFromJson(element, type, null, deserializers);
	}
	
	/**
	 * Just seeing if the getX methods can be refactored into something more generic.
	 * It might be cleaner to just handle each individual case in the respective 
	 * methods.
	 * @param element - JSON response prepared as a JsonElement
	 * @param type - The type of collection that should be returned
	 * @param elementIdentifier - The identifying value used by element
	 * @param optionalDeserializers - A map of deserializers that will be used for this JSON
	 * @return
	 */
	private Collection getCollectionFromJson(JsonElement element, Type type, String elementIdentifier, Map<Class, JsonDeserializer> optionalDeserializers) {
		GsonBuilder builder = new GsonBuilder();
		if(MapUtils.isNotEmpty(optionalDeserializers)) {
			optionalDeserializers.forEach((T, U) -> {
				builder.registerTypeAdapter(T, U);
			});
		}

		Gson gson = builder.create();
		
		if(StringUtils.isNotEmpty(elementIdentifier)) {
			return gson.fromJson(element.getAsJsonObject().get(elementIdentifier), type);			
		} else {
			// If an element identifier is not specified, then the alternate endpoints are being used
			if(element.isJsonArray()) {
				return gson.fromJson(element, type);
			} else {
				return gson.fromJson(element.getAsJsonObject(), type);
			}
		}
	}
}
