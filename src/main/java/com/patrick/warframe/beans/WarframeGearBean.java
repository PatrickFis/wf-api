package com.patrick.warframe.beans;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.gson.Gson;
import com.patrick.warframe.facade_interface.WarframeFacade;
import com.patrick.warframe.wikiexports.WarframeGear;

@Named
@SessionScoped
public class WarframeGearBean extends WarframeBaseBean {
	private static final long serialVersionUID = -218267385123089324L;

	private Collection<WarframeGear> gear;
	
	@Inject
	private WarframeFacade warframeFacade;
	
	@PostConstruct
	public void init() {
		gear = warframeFacade.getWarframeGear();
	}
	
	public String getGearPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(gear);
	}
	
	public Collection<WarframeGear> getGear() {
		return gear;
	}

	public void setGear(Collection<WarframeGear> gear) {
		this.gear = gear;
	}
}
