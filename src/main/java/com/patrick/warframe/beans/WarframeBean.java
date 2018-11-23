package com.patrick.warframe.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.patrick.warframe.data.EventMessage;
import com.patrick.warframe.data.WarframeAlert;
import com.patrick.warframe.data.WarframeEvent;
import com.patrick.warframe.facade_interface.WarframeFacade;
import com.patrick.warframe.weapons.WarframeWeapon;
import com.patrick.warframe.wikiexports.WarframeGear;
import com.patrick.warframe.wikiexports.WarframeResources;
import com.patrick.warframe.wikiexports.WarframeUpgrades;

@Named
@SessionScoped
public class WarframeBean implements Serializable {

	// Homepage: http://localhost:8080/TodoApp/pages/home.xhtml
	private static final long serialVersionUID = 4995937079175727797L;

	public Collection<WarframeEvent> events;
	public Collection<WarframeAlert> alerts;
	public Collection<WarframeWeapon> weapons;
	private Collection<WarframeGear> gear;
	private Collection<WarframeResources> resources;
	private Collection<WarframeUpgrades> upgrades;
	
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

	public String getEventsPrettyPrint() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		return gson.toJson(filterEvents());
	}
	
	public String getAlertsPrettyPrint() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		return gson.toJson(alerts);
	}
	
	public String getWeaponsPrettyPrint() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		return gson.toJson(weapons);
	}
	
	public String getGearPrettyPrint() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		return gson.toJson(gear);
	}
	
	public String getResourcesPrettyPrint() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		return gson.toJson(resources);
	}
	
	public String getUpgradesPrettyPrint() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		return gson.toJson(upgrades);
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
}
