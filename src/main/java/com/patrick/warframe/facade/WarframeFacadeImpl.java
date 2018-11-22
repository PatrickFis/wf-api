package com.patrick.warframe.facade;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;

import com.patrick.warframe.annotations.Cached;
import com.patrick.warframe.data.WarframeAlert;
import com.patrick.warframe.data.WarframeEvent;
import com.patrick.warframe.facade_interface.WarframeFacade;
import com.patrick.warframe.service_interface.WarframeService;
import com.patrick.warframe.weapons.WarframeWeapon;
import com.patrick.warframe.wikiexports.WarframeGear;
import com.patrick.warframe.wikiexports.WarframeResources;
import com.patrick.warframe.wikiexports.WarframeUpgrades;

public class WarframeFacadeImpl implements WarframeFacade, Serializable {

	private static final long serialVersionUID = -5405959449441253182L;
	
	@Inject
	private WarframeService warframeService;
	
	@Override
	@Cached
	public Collection<WarframeEvent> getWarframeData() {
		return warframeService.getWarframeEvents();
	}

	@Override
	@Cached
	public Collection<WarframeAlert> getWarframeAlerts() {
		return warframeService.getWarframeAlerts();
	}
	
	@Override
	@Cached
	public Collection<WarframeWeapon> getWarframeWeapons() {
		return warframeService.getWarframeWeapons();
	}

	@Override
	@Cached
	public Collection<WarframeGear> getWarframeGear() {
		return warframeService.getWarframeGear();
	}

	@Override
	@Cached
	public Collection<WarframeResources> getWarframeResources() {
		return warframeService.getWarframeResources();
	}

	@Override
	@Cached
	public Collection<WarframeUpgrades> getWarframeUpgrades() {
		return warframeService.getWarframeUpgrades();
	}
}
