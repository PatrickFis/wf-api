package com.patrick.warframe.enums;

import java.util.EnumSet;

import org.apache.commons.lang3.StringUtils;

public enum WarframeFactions {
	GRINEER("FC_GRINEER", "Grineer"),
	CORPUS("FC_CORPUS", "Corpus"),
	INFESTED("FC_INFESTATION", "Infested"),
	CORRUPTED("FC_CORRUPTED", "Corrupted"),
	OROKIN("FC_OROKIN", "Orokin");
	
	private String factionCode;
	private String factionName;
	
	WarframeFactions(String factionCode, String factionName) {
		this.factionCode = factionCode;
		this.factionName = factionName;
	}

	public String getFactionCode() {
		return factionCode;
	}
	
	public void setFactionCode(String factionCode) {
		this.factionCode = factionCode;
	}

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

	public String getFactionName(String code) {
		EnumSet<WarframeFactions> set = EnumSet.allOf(WarframeFactions.class);
		return set.stream().filter(faction -> StringUtils.equals(code, faction.getFactionCode())).findFirst()
				.orElseThrow(IllegalArgumentException::new).getFactionName();
	}
}
