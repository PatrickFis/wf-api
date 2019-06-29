package com.patrick.warframe.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.gson.Gson;
import com.patrick.warframe.facade_interface.WarframeFacade;
import com.patrick.warframe.wikiexports.WarframeSeasonInfo;

@Named
@SessionScoped
public class WarframeNightwaveBean extends WarframeBaseBean {
	private static final long serialVersionUID = 6884364241903440550L;

	private WarframeSeasonInfo nightwaves;

	@Inject
	private WarframeFacade warframeFacade;

	@PostConstruct
	private void init() {
		nightwaves = warframeFacade.getWarframeNightwaves();
	}

	public String getNightwavesPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(nightwaves);
	}
	
	public WarframeSeasonInfo getNightwaves() {
		return nightwaves;
	}

	public void setNightwaves(WarframeSeasonInfo nightwaves) {
		this.nightwaves = nightwaves;
	}

}
