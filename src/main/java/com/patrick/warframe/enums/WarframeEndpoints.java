package com.patrick.warframe.enums;

public enum WarframeEndpoints {
	WORLD_DATA("http://content.warframe.com/dynamic/worldState.php"),
	WEAPONS("http://content.warframe.com/MobileExport/Manifest/ExportWeapons.json"),
    UPGRADES("http://content.warframe.com/MobileExport/Manifest/ExportUpgrades.json"),
    SENTINELS("http://content.warframe.com/MobileExport/Manifest/ExportSentinels.json"),
    RESOURCES("http://content.warframe.com/MobileExport/Manifest/ExportResources.json"),
    DRONES("http://content.warframe.com/MobileExport/Manifest/ExportDrones.json"),
    CUSTOMS("http://content.warframe.com/MobileExport/Manifest/ExportCustoms.json"),
    FLAVOUR("http://content.warframe.com/MobileExport/Manifest/ExportFlavour.json"),
    KEYS("http://content.warframe.com/MobileExport/Manifest/ExportKeys.json"),
    GEAR("http://content.warframe.com/MobileExport/Manifest/ExportGear.json"),
    ARCANE("http://content.warframe.com/MobileExport/Manifest/ExportRelicArcane.json"),
    WARFRAMES("http://content.warframe.com/MobileExport/Manifest/ExportWarframes.json"),
	// Alternate endpoints from Warframe Community
	ALL("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/All.json"),
	ALTERNATE_ARCANE("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Arcanes.json"),
	ALTERNATE_ARCHWING("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Archwing.json"),
	ALTERNATE_FISH("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Fish.json"),
	ALTERNATE_GEAR("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Gear.json"),
	ALTERNATE_GLYPHS("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Glyphs.json"),
	ALTERNATE_MELEE_WEAPONS("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Melee.json"),
	ALTERNATE_MISC("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Misc.json"),
	ALTERNATE_MODS("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Mods.json"),
	ALTERNATE_PETS("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Pets.json"),
	ALTERNATE_PRIMARY_WEAPONS("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Primary.json"),
	ALTERNATE_QUESTS("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Quests.json"),
	ALTERNATE_RELICS("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Relics.json"),
	ALTERNATE_RESOURCES("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Resources.json"),
	ALTERNATE_SECONDARY_WEAPONS("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Secondary.json"),
	ALTERNATE_SENTINELS("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Sentinels.json"),
	ALTERNATE_SIGILS("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Sigils.json"),
	ALTERNATE_SKINS("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Skins.json"),
	ALTERNATE_WARFRAMES("https://raw.githubusercontent.com/WFCD/warframe-items/development/data/json/Warframes.json"),
	// World state data endpoints from Warframe Community
	WORLDSTATE_FACTIONS("https://raw.githubusercontent.com/WFCD/warframe-worldstate-data/master/data/factionsData.json"),
	WORLDSTATE_MISSION_TYPES("https://raw.githubusercontent.com/WFCD/warframe-worldstate-data/master/data/missionTypes.json"),
	WORLDSTATE_SOL_NODES("https://raw.githubusercontent.com/WFCD/warframe-worldstate-data/master/data/solNodes.json");
	
	private String endpoint;
	
	WarframeEndpoints(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public String getEndpoint() {
		return endpoint;
	}
}
