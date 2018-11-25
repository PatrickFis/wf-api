package com.patrick.warframe.enums;

import java.util.EnumSet;

import org.apache.commons.lang3.StringUtils;

public enum WarframeMissionTypes {
	EXCAVATION("MT_EXCAVATE", "Excavation"),
	SABOTAGE("MT_SABOTAGE", "Sabotage"),
	MOBILE_DEFENSE("MT_MOBILE_DEFENSE", "Mobile Defense"),
	ASSASSINATION("MT_ASSASSINATION", "Assassination"),
	EXTERMINATE("MT_EXTERMINATION", "Extermination"),
	HIVE("MT_HIVE", "HIVE"),
	DEFENSE("MT_DEFENSE", "Defense"),
	INTERCEPT("MT_TERRITORY", "Interception"),
	RATHUUM("MT_ARENA", "Rathuum"),
	PVP("MT_PVP", "Conclave"),
	RESCUE("MT_RESCUE", "Rescue"),
	SPY("MT_INTEL", "Spy"),
	SURVIVAL("MT_SURVIVAL", "Survival"),
	CAPTURE("MT_CAPTURE", "Capture"),
	DARK_SECTOR("MT_SECTOR", "Dark Sector"),
	HIJACK("MT_RETRIEVAL", "Hijack"),
	ASSAULT("MT_ASSAULT", "Assault"),
	DEFECTION("MT_EVACUATION", "Defection"),
	FREE_ROAM("MT_LANDSCAPE", "Free Roam");
	
	private String missionCode;
	private String missionName;
	
	WarframeMissionTypes(String missionCode, String missionName) {
		this.missionCode = missionCode;
		this.missionName = missionName;
	}

	public String getMissionCode() {
		return missionCode;
	}
	
	public void setMissionCode(String missionCode) {
		this.missionCode = missionCode;
	}

	public String getMissionName() {
		return missionName;
	}

	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	public String getFactionName(String code) {
		EnumSet<WarframeMissionTypes> set = EnumSet.allOf(WarframeMissionTypes.class);
		return set.stream().filter(mission -> StringUtils.equals(code, mission.getMissionCode())).findFirst()
				.orElseThrow(IllegalArgumentException::new).getMissionName();
	}
}
