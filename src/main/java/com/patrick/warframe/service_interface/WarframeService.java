package com.patrick.warframe.service_interface;

import java.util.Collection;

import com.patrick.warframe.data.WarframeAlert;
import com.patrick.warframe.data.WarframeEvent;
import com.patrick.warframe.weapons.WarframeWeapon;
import com.patrick.warframe.wikiexports.WarframeGear;
import com.patrick.warframe.wikiexports.WarframeResources;
import com.patrick.warframe.wikiexports.WarframeUpgrades;

public interface WarframeService {
	public Collection<WarframeEvent> getWarframeEvents();

	public Collection<WarframeAlert> getWarframeAlerts();

	public Collection<WarframeWeapon> getWarframeWeapons();
	
	public Collection<WarframeGear> getWarframeGear();
	
	public Collection<WarframeResources> getWarframeResources();
	
	public Collection<WarframeUpgrades> getWarframeUpgrades();
}
