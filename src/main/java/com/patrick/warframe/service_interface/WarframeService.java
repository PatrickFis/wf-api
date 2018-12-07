package com.patrick.warframe.service_interface;

import java.util.Collection;

import com.patrick.warframe.wikiexports.WarframeAlert;
import com.patrick.warframe.wikiexports.WarframeEvent;
import com.patrick.warframe.wikiexports.WarframeGear;
import com.patrick.warframe.wikiexports.WarframeItem;
import com.patrick.warframe.wikiexports.WarframeResources;
import com.patrick.warframe.wikiexports.WarframeSolNodes;
import com.patrick.warframe.wikiexports.WarframeUpgrades;
import com.patrick.warframe.wikiexports.WarframeWeapon;
import com.patrick.warframe.wikiexports.Warframes;

public interface WarframeService {
	public Collection<WarframeEvent> getWarframeEvents();

	public Collection<WarframeAlert> getWarframeAlerts();

	public Collection<WarframeWeapon> getWarframeWeapons();
	
	public Collection<WarframeGear> getWarframeGear();
	
	public Collection<WarframeResources> getWarframeResources();
	
	public Collection<WarframeItem> getWarframeMods();

	public Collection<WarframeItem> getWarframeItems();

	public Collection<WarframeUpgrades> getWarframeUpgrades();

	public Collection<Warframes> getWarframes();
	
	public Collection<WarframeSolNodes> getWarframeSolNodes();

	public String getImageForWeapon(WarframeWeapon weapon);



}
