package com.patrick.warframe.facade_interface;

import java.util.Collection;

import com.patrick.warframe.data.WarframeAlert;
import com.patrick.warframe.data.WarframeEvent;
import com.patrick.warframe.weapons.WarframeWeapon;
import com.patrick.warframe.wikiexports.WarframeGear;
import com.patrick.warframe.wikiexports.WarframeResources;
import com.patrick.warframe.wikiexports.WarframeUpgrades;

public interface WarframeFacade {
	public Collection<WarframeEvent> getWarframeData();

	public Collection<WarframeAlert> getWarframeAlerts();

	public Collection<WarframeWeapon> getWarframeWeapons();
	
	public Collection<WarframeGear> getWarframeGear();
	
	public Collection<WarframeResources> getWarframeResources();
	
	public Collection<WarframeUpgrades> getWarframeUpgrades();
}
