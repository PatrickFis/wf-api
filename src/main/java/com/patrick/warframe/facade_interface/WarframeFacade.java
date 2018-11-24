package com.patrick.warframe.facade_interface;

import java.util.Collection;

import com.patrick.warframe.wikiexports.WarframeAlert;
import com.patrick.warframe.wikiexports.WarframeEvent;
import com.patrick.warframe.wikiexports.WarframeGear;
import com.patrick.warframe.wikiexports.WarframeResources;
import com.patrick.warframe.wikiexports.WarframeUpgrades;
import com.patrick.warframe.wikiexports.WarframeWeapon;
import com.patrick.warframe.wikiexports.Warframes;

public interface WarframeFacade {
	public Collection<WarframeEvent> getWarframeData();

	public Collection<WarframeAlert> getWarframeAlerts();

	public Collection<WarframeWeapon> getWarframeWeapons();
	
	public Collection<WarframeGear> getWarframeGear();
	
	public Collection<WarframeResources> getWarframeResources();
	
	public Collection<WarframeUpgrades> getWarframeUpgrades();
	
	public Collection<Warframes> getWarframes();

	public Collection<WarframeAlert> getWarframeAlertsWithRewardNames();
}
