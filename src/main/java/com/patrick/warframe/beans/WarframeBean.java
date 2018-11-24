package com.patrick.warframe.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.patrick.warframe.data.EventMessage;
import com.patrick.warframe.facade_interface.WarframeFacade;
import com.patrick.warframe.wikiexports.WarframeAlert;
import com.patrick.warframe.wikiexports.WarframeEvent;
import com.patrick.warframe.wikiexports.WarframeGear;
import com.patrick.warframe.wikiexports.WarframeResources;
import com.patrick.warframe.wikiexports.WarframeUpgrades;
import com.patrick.warframe.wikiexports.WarframeWeapon;
import com.patrick.warframe.wikiexports.Warframes;

@Named
@SessionScoped
public class WarframeBean implements Serializable {

	private static final long serialVersionUID = 4995937079175727797L;

	// URL: http://localhost:8080/WarframeApi-0.0.1-SNAPSHOT/
	private Collection<WarframeEvent> events;
	private Collection<WarframeAlert> alerts;
	private Collection<WarframeWeapon> weapons;
	private Collection<WarframeGear> gear;
	private Collection<WarframeResources> resources;
	private Collection<WarframeUpgrades> upgrades;
	private Collection<Warframes> warframes;
	
	@Inject
	private WarframeFacade warframeFacade;
	
	@PostConstruct
	public void init() {
		events = warframeFacade.getWarframeData();
		alerts = warframeFacade.getWarframeAlertsWithRewardNames();
		weapons = warframeFacade.getWarframeWeapons();
		gear = warframeFacade.getWarframeGear();
		resources = warframeFacade.getWarframeResources();
		upgrades = warframeFacade.getWarframeUpgrades();
		warframes = warframeFacade.getWarframes();
	}
	
	public String getEventsPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(filterEvents());
	}
	
	public String getAlertsPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(alerts);
	}
	
	public String getWeaponsPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(weapons);
	}
	
	public String getGearPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(gear);
	}
	
	public String getResourcesPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(resources);
	}

	
	public String getUpgradesPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(upgrades);
	}
	
	public String getWarframesPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(warframes);
	}
	
	private Gson getPrettyPrintingGson() {
		GsonBuilder builder = new GsonBuilder();
		return builder.setPrettyPrinting().create();
	}

	private Collection<WarframeEvent> filterEvents() {
		Collection<EventMessage> tempMessages = events.stream().map(WarframeEvent::getMessages).flatMap(List::stream)
				.filter(mess -> StringUtils.equals(mess.getLanguageCode(), "en"))
				.collect(Collectors.toCollection(ArrayList::new));
		
		Collection<WarframeEvent> retValue = new ArrayList<>();
		for(WarframeEvent e: events) {
			if(tempMessages.contains(e.getMessages().get(0))) {
				retValue.add(e);
			}
		}
		return retValue;
	}

	public Collection<WarframeEvent> getEvents() {
		return events;
	}
	
	public void setEvents(Collection<WarframeEvent> events) {
		this.events = events;
	}
	
	public Collection<WarframeAlert> getAlerts() {
		return alerts;
	}

	public void setAlerts(Collection<WarframeAlert> alerts) {
		this.alerts = alerts;
	}
	
	public Collection<WarframeWeapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(Collection<WarframeWeapon> weapons) {
		this.weapons = weapons;
	}

	public Collection<WarframeGear> getGear() {
		return gear;
	}

	public void setGear(Collection<WarframeGear> gear) {
		this.gear = gear;
	}

	public Collection<WarframeResources> getResources() {
		return resources;
	}

	public void setResources(Collection<WarframeResources> resources) {
		this.resources = resources;
	}

	public Collection<WarframeUpgrades> getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(Collection<WarframeUpgrades> upgrades) {
		this.upgrades = upgrades;
	}

	public Collection<Warframes> getWarframes() {
		return warframes;
	}

	public void setWarframes(Collection<Warframes> warframes) {
		this.warframes = warframes;
	}
}
