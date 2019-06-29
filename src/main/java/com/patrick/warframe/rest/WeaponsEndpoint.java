package com.patrick.warframe.rest;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.patrick.warframe.beans.WarframeWeaponsBean;
import com.patrick.warframe.wikiexports.WarframeWeapon;

@Path("weapons")
public class WeaponsEndpoint {
	// Access through something like this:
	// http://localhost:8080/WarframeApi-0.0.1-SNAPSHOT/rest/weapons/Atomos
	
	@Inject
	private WarframeWeaponsBean warframeWeaponsBean;

	@GET
	@Produces("text/plain")
	@Path("/{name}")
	public String getWeapon(@PathParam("name") String weaponName) {
		Collection<WarframeWeapon> weapons = warframeWeaponsBean.getWeapons();
		Gson prettyPrinter = warframeWeaponsBean.getPrettyPrintingGson();
		return prettyPrinter.toJson(weapons.stream().filter(weapon -> StringUtils.equalsIgnoreCase(weapon.getName(), weaponName))
				.findFirst().orElse(null));
	}
}
