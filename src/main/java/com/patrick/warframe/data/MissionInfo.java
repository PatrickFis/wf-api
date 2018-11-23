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
	
	public String getMissionType() {
		return missionType;
	}

	public void setMissionType(String missionType) {
		this.missionType = missionType;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLevelOverride() {
		return levelOverride;
	}

	public void setLevelOverride(String levelOverride) {
		this.levelOverride = levelOverride;
	}

	public String getEnemySpec() {
		return enemySpec;
	}

	public void setEnemySpec(String enemySpec) {
		this.enemySpec = enemySpec;
	}

	public String getExtraEnemySpec() {
		return extraEnemySpec;
	}

	public void setExtraEnemySpec(String extraEnemySpec) {
		this.extraEnemySpec = extraEnemySpec;
	}

	public int getMinEnemyLevel() {
		return minEnemyLevel;
	}

	public void setMinEnemyLevel(int minEnemyLevel) {
		this.minEnemyLevel = minEnemyLevel;
	}

	public int getMaxEnemeyLevel() {
		return maxEnemeyLevel;
	}

	public void setMaxEnemeyLevel(int maxEnemeyLevel) {
		this.maxEnemeyLevel = maxEnemeyLevel;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public MissionReward getMissionReward() {
		return missionReward;
	}

	public void setMissionReward(MissionReward missionReward) {
		this.missionReward = missionReward;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(missionType).append(faction).append(location).append(levelOverride)
				.append(enemySpec).append(extraEnemySpec).append(minEnemyLevel).append(maxEnemeyLevel)
				.append(difficulty).append(missionReward).toString();
	}
}
