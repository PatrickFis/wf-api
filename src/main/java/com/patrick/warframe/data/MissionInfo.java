package com.patrick.warframe.data;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MissionInfo {
	public String missionType;
	public String faction;
	public String location;
	public String levelOverride;
	public String enemySpec;
	public String extraEnemySpec;
	public int minEnemyLevel;
	public int maxEnemeyLevel;
	public int difficulty;
	public MissionReward missionReward;

	public MissionInfo() {

	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append(missionType).append(faction).append(location).append(levelOverride)
				.append(enemySpec).append(extraEnemySpec).append(minEnemyLevel).append(maxEnemeyLevel)
				.append(difficulty).append(missionReward).toString();
	}
}
