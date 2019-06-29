package com.patrick.warframe.wikiexports;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.patrick.warframe.data.ActiveChallenges;
import com.patrick.warframe.data.GenericID;
import com.patrick.warframe.data.MissionTimer;

/**
 * This is used to deserialize the SeasonInfo object returned by world data.
 * This object is used for Nightwaves.
 * 
 * @author Patrick
 *
 */
public class WarframeSeasonInfo {
	@SerializedName("_id")
	public GenericID id;
	@SerializedName("Activation")
	public MissionTimer startTime;
	@SerializedName("Expiry")
	public MissionTimer endTime;
	@SerializedName("AffiliationTag")
	public String affiliationTag;
	@SerializedName("Season")
	public int season;
	@SerializedName("Phase")
	public int phase;
	@SerializedName("Params")
	public String params;
	@SerializedName("ActiveChallenges")
	public List<ActiveChallenges> activeChallenges;

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

	public String getAffiliationTag() {
		return affiliationTag;
	}

	public void setAffiliationTag(String affiliationTag) {
		this.affiliationTag = affiliationTag;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public List<ActiveChallenges> getActiveChallenges() {
		return activeChallenges;
	}

	public void setActiveChallenges(List<ActiveChallenges> activeChallenges) {
		this.activeChallenges = activeChallenges;
	}
}
