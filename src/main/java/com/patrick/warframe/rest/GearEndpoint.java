package com.patrick.warframe.rest;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.patrick.warframe.beans.WarframeGearBean;
import com.patrick.warframe.wikiexports.WarframeGear;

@Path("gear")
public class GearEndpoint {
	@Inject
	private WarframeGearBean warframeGearBean;

	@GET
	@Produces("text/plain")
	@Path("/{name}")
	public String getGear(@PathParam("name") String gearName) {
		Collection<WarframeGear> allGear = warframeGearBean.getGear();
		Gson prettyPrinter = warframeGearBean.getPrettyPrintingGson();
		return prettyPrinter.toJson(allGear.stream().filter(gear -> StringUtils.equalsIgnoreCase(gear.getName(), gearName))
				.findFirst().orElse(null));
	}
}