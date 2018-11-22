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
    WARFRAMES("http://content.warframe.com/MobileExport/Manifest/ExportWarframes.json");
	
	private String endpoint;
	
	WarframeEndpoints(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public String getEndpoint() {
		return endpoint;
	}
}
