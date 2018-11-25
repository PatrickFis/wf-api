package com.patrick.warframe.beans;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.gson.Gson;
import com.patrick.warframe.facade_interface.WarframeFacade;
import com.patrick.warframe.wikiexports.Warframes;

@Named
@SessionScoped
public class WarframeFramesBean extends WarframeBaseBean {

	private static final long serialVersionUID = -9027771350561581734L;
	
	private Collection<Warframes> warframes;
	
	@Inject
	private WarframeFacade warframeFacade;
	
	@PostConstruct
	public void init() {
		warframes = warframeFacade.getWarframes();
	}
	
	public String getWarframesPrettyPrint() {
		Gson gson = getPrettyPrintingGson();
		return gson.toJson(warframes);
	}
	
	public Collection<Warframes> getWarframes() {
		return warframes;
	}

	public void setWarframes(Collection<Warframes> warframes) {
		this.warframes = warframes;
	}
}
