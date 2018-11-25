package com.patrick.warframe.beans;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.gson.Gson;
import com.patrick.warframe.facade_interface.WarframeFacade;
import com.patrick.warframe.wikiexports.WarframeResources;

@Named
@SessionScoped
public class WarframeResourcesBean extends WarframeBaseBean {
	private static final long serialVersionUID = 1592995749371076960L;

	private Collection<WarframeResources> resources;
	
	@Inject
	private WarframeFacade warframeFacade;
	
	@PostConstruct
	public void init() {
		resources = warframeFacade.getWarframeResources();
	}
	
	public String getResourcesPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(resources);
	}

	public Collection<WarframeResources> getResources() {
		return resources;
	}

	public void setResources(Collection<WarframeResources> resources) {
		this.resources = resources;
	}
}