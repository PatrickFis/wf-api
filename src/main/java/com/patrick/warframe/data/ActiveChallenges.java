package com.patrick.warframe.data;

import com.google.gson.annotations.SerializedName;

/**
 * Used to deserialize the ActiveChallenge component of the SeasonInfo object
 * from world data. This is used for Nightwaves.
 * 
 * @author Patrick
 *
 */
public class ActiveChallenges {
	@SerializedName("_id")
	public GenericID id;
	@SerializedName("Activation")
	public MissionTimer startTime;
	@SerializedName("Expiry")
	public MissionTimer endTime;
	@SerializedName("Daily")
	public boolean daily;
	@SerializedName("Challenge")
	public String challenge;

	public GenericID getId() {
		return id;
	}

	public void setId(GenericID id) {
		this.id = id;
	}

	public MissionTimer getStartTime() {
		return startTime;
	}

	public void setStartTime(MissionTimer startTime) {
		this.startTime = startTime;
	}

	public MissionTimer getEndTime() {
		return endTime;
	}

	public void setEndTime(MissionTimer endTime) {
		this.endTime = endTime;
	}

	public boolean isDaily() {
		return daily;
	}

	public void setDaily(boolean daily) {
		this.daily = daily;
	}

	public String getChallenge() {
		return challenge;
	}

	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}
}
