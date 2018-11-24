package com.patrick.warframe.wikiexports;

import java.util.Arrays;

public class WarframeWeapon {
	public String name;
	public String uniqueName;
	public boolean codexSecret;
	public double secondsPerShot;
	public int[] damagePerShot;
	public int magazineSize;
	public double reloadTime;
	public int totalDamage;
	public int damagePerSecond;
	public String trigger;
	public String description;
	public double accuracy;
	public double criticalChance;
	public double criticalMultiplier;
	public double procChance;
	public double fireRate;
	public double chargeAttack;
	public double spinAttack;
	public double leapAttack;
	public double wallAttack;
	public int slot;
	public String noise;
	public boolean sentinel;
	public int masteryReq;
	public int omegaAttenuation;
	public String imageLocation;
	
	public WarframeWeapon() {
		
	}

	/**
	 * @return A string representing a file name for an image for this weapon from a CDN.
	 * The file name is the portion of the unique name after the final / in lower case.
	 * Each previously capitalized letter aside from the first is preceded by a -.
	 * ReplaceAll documentation from StackOverflow: https://stackoverflow.com/questions/23662527/replace-capital-letter-with-underscore-lowercase-letter-in-java
	 * The file name can be used to retrieve images from https://cdn.warframestat.us/img/imageName.
	 */
	public String getImageFileName() {
		String[] nameArray = uniqueName.split("/");
		StringBuilder imageName = new StringBuilder(nameArray[nameArray.length - 1]);
		imageName.setCharAt(0, Character.toLowerCase(imageName.charAt(0)));
		return imageName.toString().replaceAll("([A-Z])", "-$1").toLowerCase() + ".png";
	}
	
	public String getAlternateImageFileName() {
		return name.replaceAll("\\s", "-").toLowerCase() + ".png";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public boolean isCodexSecret() {
		return codexSecret;
	}

	public void setCodexSecret(boolean codexSecret) {
		this.codexSecret = codexSecret;
	}

	public double getSecondsPerShot() {
		return secondsPerShot;
	}

	public void setSecondsPerShot(double secondsPerShot) {
		this.secondsPerShot = secondsPerShot;
	}

	public int[] getDamagePerShot() {
		return damagePerShot;
	}

	public void setDamagePerShot(int[] damagePerShot) {
		this.damagePerShot = damagePerShot;
	}

	public int getMagazineSize() {
		return magazineSize;
	}

	public void setMagazineSize(int magazineSize) {
		this.magazineSize = magazineSize;
	}

	public double getReloadTime() {
		return reloadTime;
	}

	public void setReloadTime(double reloadTime) {
		this.reloadTime = reloadTime;
	}

	public int getTotalDamage() {
		return totalDamage;
	}

	public void setTotalDamage(int totalDamage) {
		this.totalDamage = totalDamage;
	}

	public int getDamagePerSecond() {
		return damagePerSecond;
	}

	public void setDamagePerSecond(int damagePerSecond) {
		this.damagePerSecond = damagePerSecond;
	}

	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public double getCriticalChance() {
		return criticalChance;
	}

	public void setCriticalChance(double criticalChance) {
		this.criticalChance = criticalChance;
	}

	public double getCriticalMultiplier() {
		return criticalMultiplier;
	}

	public void setCriticalMultiplier(double criticalMultiplier) {
		this.criticalMultiplier = criticalMultiplier;
	}

	public double getProcChance() {
		return procChance;
	}

	public void setProcChance(double procChance) {
		this.procChance = procChance;
	}

	public double getFireRate() {
		return fireRate;
	}

	public void setFireRate(double fireRate) {
		this.fireRate = fireRate;
	}

	public double getChargeAttack() {
		return chargeAttack;
	}

	public void setChargeAttack(double chargeAttack) {
		this.chargeAttack = chargeAttack;
	}

	public double getSpinAttack() {
		return spinAttack;
	}

	public void setSpinAttack(double spinAttack) {
		this.spinAttack = spinAttack;
	}

	public double getLeapAttack() {
		return leapAttack;
	}

	public void setLeapAttack(double leapAttack) {
		this.leapAttack = leapAttack;
	}

	public double getWallAttack() {
		return wallAttack;
	}

	public void setWallAttack(double wallAttack) {
		this.wallAttack = wallAttack;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public String getNoise() {
		return noise;
	}

	public void setNoise(String noise) {
		this.noise = noise;
	}

	public boolean isSentinel() {
		return sentinel;
	}

	public void setSentinel(boolean sentinel) {
		this.sentinel = sentinel;
	}

	public int getMasteryReq() {
		return masteryReq;
	}

	public void setMasteryReq(int masteryReq) {
		this.masteryReq = masteryReq;
	}

	public int getOmegaAttenuation() {
		return omegaAttenuation;
	}

	public void setOmegaAttenuation(int omegaAttenuation) {
		this.omegaAttenuation = omegaAttenuation;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	@Override
	public String toString() {
		return "WarframeWeapon [name=" + name + ", uniqueName=" + uniqueName + ", codexSecret=" + codexSecret
				+ ", secondsPerShot=" + secondsPerShot + ", damagePerShot=" + Arrays.toString(damagePerShot)
				+ ", magazineSize=" + magazineSize + ", reloadTime=" + reloadTime + ", totalDamage=" + totalDamage
				+ ", damagePerSecond=" + damagePerSecond + ", trigger=" + trigger + ", description=" + description
				+ ", accuracy=" + accuracy + ", criticalChance=" + criticalChance + ", criticalMultiplier="
				+ criticalMultiplier + ", procChance=" + procChance + ", fireRate=" + fireRate + ", chargeAttack="
				+ chargeAttack + ", spinAttack=" + spinAttack + ", leapAttack=" + leapAttack + ", wallAttack="
				+ wallAttack + ", slot=" + slot + ", noise=" + noise + ", sentinel=" + sentinel + ", masteryReq="
				+ masteryReq + ", omegaAttenuation=" + omegaAttenuation + "]";
	}
	
}
