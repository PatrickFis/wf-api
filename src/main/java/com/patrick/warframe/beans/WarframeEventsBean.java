package com.patrick.warframe.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.patrick.warframe.data.EventMessage;
import com.patrick.warframe.facade_interface.WarframeFacade;
import com.patrick.warframe.wikiexports.WarframeEvent;

@Named
@SessionScoped
public class WarframeEventsBean extends WarframeBaseBean {
	private static final long serialVersionUID = -5870336013818535662L;

	// URL: http://localhost:8080/WarframeApi-0.0.1-SNAPSHOT/
	private Collection<WarframeEvent> events;
	
	@Inject
	private WarframeFacade warframeFacade;
	
	@PostConstruct
	public void init() {
		events = warframeFacade.getWarframeData();
	}
	
	public String getEventsPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(filterEvents());
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
}
