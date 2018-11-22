package com.patrick.warframe.wikiexports;

import java.util.Arrays;

public class WarframeUpgrades {
	public String uniqueName;
	public String name;
	public String polarity;
	public String rarity;
	public boolean codexSecret;
	public int baseDrain;
	public int fusionLimit;
	public String[] description;
	public String type;
	public String subType;
	
	public WarframeUpgrades() {
		
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPolarity() {
		return polarity;
	}

	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public boolean isCodexSecret() {
		return codexSecret;
	}

	public void setCodexSecret(boolean codexSecret) {
		this.codexSecret = codexSecret;
	}

	public int getBaseDrain() {
		return baseDrain;
	}

	public void setBaseDrain(int baseDrain) {
		this.baseDrain = baseDrain;
	}

	public int getFusionLimit() {
		return fusionLimit;
	}

	public void setFusionLimit(int fusionLimit) {
		this.fusionLimit = fusionLimit;
	}

	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	@Override
	public String toString() {
		return "WarframeUpgrades [uniqueName=" + uniqueName + ", name=" + name + ", polarity=" + polarity + ", rarity="
				+ rarity + ", codexSecret=" + codexSecret + ", baseDrain=" + baseDrain + ", fusionLimit=" + fusionLimit
				+ ", description=" + Arrays.toString(description) + ", type=" + type + ", subType=" + subType + "]";
	}
}