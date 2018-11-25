package com.patrick.warframe.beans;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.gson.Gson;
import com.patrick.warframe.facade_interface.WarframeFacade;
import com.patrick.warframe.wikiexports.WarframeAlert;

@Named
@SessionScoped
public class WarframeAlertsBean extends WarframeBaseBean {
	private static final long serialVersionUID = -6516377961022326892L;

	private Collection<WarframeAlert> alerts;
	
	@Inject
	private WarframeFacade warframeFacade;
	
	@PostConstruct
	public void init() {
		alerts = warframeFacade.getUpdatedWarframeAlerts();
	}
	
	
	public String getAlertsPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(alerts);
	}
	
	public Collection<WarframeAlert> getAlerts() {
		return alerts;
	}

	public void setAlerts(Collection<WarframeAlert> alerts) {
		this.alerts = alerts;
	}
	
}
