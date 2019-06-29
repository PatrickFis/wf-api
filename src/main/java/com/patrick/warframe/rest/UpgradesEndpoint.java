package com.patrick.warframe.rest;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.patrick.warframe.beans.WarframeUpgradesBean;
import com.patrick.warframe.wikiexports.WarframeUpgrades;

@Path("upgrades")
public class UpgradesEndpoint {
	// Access through something like this:
	// http://localhost:8080/WarframeApi-0.0.1-SNAPSHOT/rest/weapons/Atomos
	
	@Inject
	private WarframeUpgradesBean warframeUpgradesBean;

	@GET
	@Produces("text/plain")
	@Path("/{name}")
	public String getUpgrade(@PathParam("name") String upgradeName) {
		Collection<WarframeUpgrades> upgrades = warframeUpgradesBean.getUpgrades();
		Gson prettyPrinter = warframeUpgradesBean.getPrettyPrintingGson();
		return prettyPrinter.toJson(upgrades.stream().filter(upgrade -> StringUtils.equalsIgnoreCase(upgrade.getName(), upgradeName))
				.findFirst().orElse(null));
	}
}
