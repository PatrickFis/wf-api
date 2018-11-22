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

@Named
@SessionScoped
public class WarframeBean implements Serializable {

	// Homepage: http://localhost:8080/TodoApp/pages/home.xhtml
	private static final long serialVersionUID = 4995937079175727797L;

	public Collection<WarframeEvent> events;
	public Collection<WarframeAlert> alerts;
	public Collection<WarframeWeapon> weapons;
	
	@Inject
	private WarframeFacade warframeFacade;
	
	@PostConstruct
	public void init() {
		events = warframeFacade.getWarframeData();
		alerts = warframeFacade.getWarframeAlerts();
		weapons = warframeFacade.getWarframeWeapons();
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
	
	public String getAlertsPrettyPrent() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		return gson.toJson(alerts);
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
