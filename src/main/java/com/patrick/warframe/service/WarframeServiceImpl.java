package com.patrick.warframe.service;

import java.io.BufferedReader;
import java.io.IOException;
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

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.patrick.warframe.data.LocalDateTimeDeserializer;
import com.patrick.warframe.data.WarframeAlert;
import com.patrick.warframe.data.WarframeEvent;
import com.patrick.warframe.enums.WarframeEndpoints;
import com.patrick.warframe.service_interface.WarframeService;
import com.patrick.warframe.weapons.WarframeWeapon;
import com.patrick.warframe.wikiexports.WarframeGear;
import com.patrick.warframe.wikiexports.WarframeResources;
import com.patrick.warframe.wikiexports.WarframeUpgrades;

public class WarframeServiceImpl implements WarframeService, Serializable {

	private static final long serialVersionUID = 6333759256496605333L;

	private static final Logger logger = Logger.getLogger(WarframeServiceImpl.class.getName());
	
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
		JsonElement elements = getResponseFromEndpoint(WarframeEndpoints.WEAPONS.getEndpoint());
		Collection<WarframeWeapon> weapons = getWeapons(elements);
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
		JsonElement elements = getResponseFromEndpoint(WarframeEndpoints.GEAR.getEndpoint());
		Collection<WarframeResources> resources = getResources(elements);
		return resources;
	}

	@Override
	public Collection<WarframeUpgrades> getWarframeUpgrades() {
		JsonElement elements = getResponseFromEndpoint(WarframeEndpoints.GEAR.getEndpoint());
		Collection<WarframeUpgrades> upgrades = getUpgrades(elements);
		return upgrades;
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
	
	// Trying multiple parsing methods
	private LinkedTreeMap<String, String> getJsonAsMap(String response) {
		GsonBuilder builder = new GsonBuilder();
		Object jsonMap = builder.create().fromJson(response, Object.class);
		return (LinkedTreeMap) jsonMap;
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
//		GsonBuilder builder = new GsonBuilder();
//		builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
//		Gson gson = builder.create();
		Type collectionType = new TypeToken<Collection<WarframeAlert>>() {}.getType();
//		return gson.fromJson(element.getAsJsonObject().get("Alerts"), collectionType);
		Map<Class, JsonDeserializer> deserializers = new HashMap<>();
		deserializers.put(LocalDateTime.class, new LocalDateTimeDeserializer());
		return getCollectionFromJson(element, collectionType, "Alerts", deserializers);
	}
	
	private Collection<WarframeWeapon> getWeapons(JsonElement element) {
		Gson gson = new Gson();
		Type collectionType = new TypeToken<Collection<WarframeWeapon>>() {}.getType();
		return gson.fromJson(element.getAsJsonObject().get("ExportWeapons"), collectionType);
	}
	
	private Collection<WarframeGear> getGear(JsonElement element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Collection<WarframeResources> getResources(JsonElement elements) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Collection<WarframeUpgrades> getUpgrades(JsonElement elements) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @param element - JSON response prepared as a JsonElement
	 * @param type - The type of collection that should be returned
	 * @param elementIdentifier - The identifying value used by element
	 * @param optionalDeserializers - A map of deserializers that will be used for this JSON
	 * @return
	 */
	private Collection getCollectionFromJson(JsonElement element, Type type, String elementIdentifier, Map<Class, JsonDeserializer> optionalDeserializers) {
		GsonBuilder builder = new GsonBuilder();
		if(optionalDeserializers != null && optionalDeserializers.size() > 0) {
			optionalDeserializers.forEach((T, U) -> {
				builder.registerTypeAdapter(T, U);
			});
		}

		Gson gson = builder.create();
		return gson.fromJson(element.getAsJsonObject().get(elementIdentifier), type);
	}
}
