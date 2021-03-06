package com.patrick.warframe.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import com.patrick.warframe.annotations.Cached;
import com.patrick.warframe.enums.WarframeFactions;
import com.patrick.warframe.enums.WarframeMissionTypes;
import com.patrick.warframe.facade_interface.WarframeFacade;
import com.patrick.warframe.service_interface.WarframeService;
import com.patrick.warframe.wikiexports.WarframeAlert;
import com.patrick.warframe.wikiexports.WarframeEvent;
import com.patrick.warframe.wikiexports.WarframeGear;
import com.patrick.warframe.wikiexports.WarframeItem;
import com.patrick.warframe.wikiexports.WarframeResources;
import com.patrick.warframe.wikiexports.WarframeSeasonInfo;
import com.patrick.warframe.wikiexports.WarframeSolNodes;
import com.patrick.warframe.wikiexports.WarframeUpgrades;
import com.patrick.warframe.wikiexports.WarframeWeapon;
import com.patrick.warframe.wikiexports.Warframes;

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
		Collection<WarframeWeapon> weapons = warframeService.getWarframeWeapons();
		getImagesForWeapons(weapons);
		return weapons;
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
	public Collection<WarframeItem> getWarframeMods() {
		return warframeService.getWarframeMods();
	}
	
	@Override
	@Cached
	public Collection<WarframeItem> getWarframeItems() {
		return warframeService.getWarframeItems();
	}
	
	@Override
	@Cached
	public Collection<WarframeUpgrades> getWarframeUpgrades() {
		return warframeService.getWarframeUpgrades();
	}

	@Override
	@Cached
	public Collection<Warframes> getWarframes() {
		return warframeService.getWarframes();
	}
	
	@Override
	@Cached
	public Collection<WarframeAlert> getUpdatedWarframeAlerts() {
		return updateWarframeAlerts();
	}

	@Override
	@Cached
	public Collection<WarframeSolNodes> getWarframeSolNodes() {
		return warframeService.getWarframeSolNodes();
	}
	
	@Override
	public WarframeSeasonInfo getWarframeNightwaves() {
		return warframeService.getWarframeNightwaves();
	}
	
	private void getImagesForWeapons(Collection<WarframeWeapon> weapons) {
		weapons.parallelStream().forEach(ww -> ww.setImageLocation(warframeService.getImageForWeapon(ww)));
	}
	
	/**
	 * Returns a map of item names generated from the collections cached by this class.
	 * These will be used to get proper item names for alerts (and possibly other things).
	 * @return
	 */
	private Map<String, String> getWarframeItemNames() {
		Map<String, String> itemNames = getWarframeGear().stream().collect(Collectors.toMap(WarframeGear::getUniqueName, WarframeGear::getName));
		itemNames.putAll(getWarframeResources().stream().collect(Collectors.toMap(WarframeResources::getUniqueName, WarframeResources::getName)));
		itemNames.putAll(getWarframeUpgrades().stream().collect(Collectors.toMap(WarframeUpgrades::getUniqueName, WarframeUpgrades::getName)));
		itemNames.putAll(getWarframeMods().stream().collect(Collectors.toMap(WarframeItem::getUniqueName, WarframeItem::getName)));
		itemNames.putAll(getWarframeItems().stream().collect(Collectors.toMap(WarframeItem::getUniqueName, WarframeItem::getName)));
		return itemNames;
	}
	
	/**
	 * Updates the location of the alert to a more readable value, updates the
	 * mission type, updates the faction of the mission, and updates the item names
	 * of rewards.
	 * 
	 * @return
	 */
	private Collection<WarframeAlert> updateWarframeAlerts() {
		Collection<WarframeAlert> alerts = this.getWarframeAlerts();
		Collection<WarframeSolNodes> solNodes = this.getWarframeSolNodes();
		Map<String, String> itemNames = getWarframeItemNames();
		
		alerts.forEach(alert -> {
			alert.getMissionInfo()
					.setLocation(solNodes.stream().filter(node -> StringUtils
							.equalsIgnoreCase(alert.getMissionInfo().getLocation(), node.getNodeId())).findFirst()
							.orElseGet(WarframeSolNodes::new).getName());

			alert.getMissionInfo()
					.setMissionType(WarframeMissionTypes.getMissionName(alert.getMissionInfo().getMissionType()));

			alert.getMissionInfo().setFaction(WarframeFactions.getFactionName(alert.getMissionInfo().getFaction()));
			
			Map<String, Integer> countedItems = alert.getMissionInfo().getMissionReward().getCountedItems();
			Map<String, Integer> countedItemsWithNames = new HashMap<>();
			
			List<String> items = alert.getMissionInfo().getMissionReward().getItems();
			List<String> itemsWithNames = new ArrayList<>();
			
			if(MapUtils.isNotEmpty(countedItems)) {
				countedItems.forEach((name, count) -> {
					// Get the actual item name from the itemNames map. If absent, put the name in the map.
					countedItemsWithNames.put(itemNames.computeIfAbsent(name, n -> n), count);
				});				
			}
			
			if(CollectionUtils.isNotEmpty(items)) {
				items.forEach((name) -> {
					// Get the actual item name from the itemNames map. If absent, put the name in the map.
					itemsWithNames.add(itemNames.computeIfAbsent(name, n -> n));
				});				
			}
			
			alert.getMissionInfo().getMissionReward().setCountedItems(countedItemsWithNames);
			alert.getMissionInfo().getMissionReward().setItems(itemsWithNames);
			
			
		});
		
		return alerts;
	}
}
