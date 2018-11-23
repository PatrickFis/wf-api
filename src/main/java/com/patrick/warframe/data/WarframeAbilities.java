package com.patrick.warframe.data;

public class WarframeAbilities {
	public String abilityUniqueName;
	public String abilityName;
	public String description;
	
	public WarframeAbilities() {
		
	}

	public String getAbilityUniqueName() {
		return abilityUniqueName;
	}

	public void setAbilityUniqueName(String abilityUniqueName) {
		this.abilityUniqueName = abilityUniqueName;
	}

	public String getAbilityName() {
		return abilityName;
	}

	public void setAbilityName(String abilityName) {
		this.abilityName = abilityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "WarframeAbilities [abilityUniqueName=" + abilityUniqueName + ", abilityName=" + abilityName
				+ ", description=" + description + "]";
	}
}
