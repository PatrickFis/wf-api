package com.patrick.warframe.wikiexports;

import java.util.List;

import com.patrick.warframe.data.WarframeAbilities;

public class Warframes {
	public String uniqueName;
	public String name;
	public String parentName;
	public String description;
	public String longDescription;
	public int health;
	public int shield;
	public int armor;
	public int stamina;
	public int power;
	public boolean codexSecret;
	public List<WarframeAbilities> abilities;
	
	public Warframes() {
		
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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isCodexSecret() {
		return codexSecret;
	}

	public void setCodexSecret(boolean codexSecret) {
		this.codexSecret = codexSecret;
	}

	public List<WarframeAbilities> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<WarframeAbilities> abilities) {
		this.abilities = abilities;
	}

	@Override
	public String toString() {
		return "Warframes [uniqueName=" + uniqueName + ", name=" + name + ", parentName=" + parentName
				+ ", description=" + description + ", longDescription=" + longDescription + ", health=" + health
				+ ", shield=" + shield + ", armor=" + armor + ", stamina=" + stamina + ", power=" + power
				+ ", codexSecret=" + codexSecret + ", abilities=" + abilities + "]";
	}
	
}
