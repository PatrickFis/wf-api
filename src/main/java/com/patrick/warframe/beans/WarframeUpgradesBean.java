package com.patrick.warframe.beans;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.gson.Gson;
import com.patrick.warframe.facade_interface.WarframeFacade;
import com.patrick.warframe.wikiexports.WarframeUpgrades;

@Named
@SessionScoped
public class WarframeUpgradesBean extends WarframeBaseBean {
	private static final long serialVersionUID = -4672893008774683156L;

	private Collection<WarframeUpgrades> upgrades;
	
	@Inject
	private WarframeFacade warframeFacade;
	
	@PostConstruct
	public void init() {
		upgrades = warframeFacade.getWarframeUpgrades();
	}
	
	public String getUpgradesPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(upgrades);
	}
	
	public Collection<WarframeUpgrades> getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(Collection<WarframeUpgrades> upgrades) {
		this.upgrades = upgrades;
	}
}
