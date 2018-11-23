package com.patrick.warframe.data;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class WarframeAlert {
	@SerializedName("_id")
	public GenericID id;
	@SerializedName("Activation")
	public MissionTimer startTime;
	@SerializedName("Expiry")
	public MissionTimer endTime;
	@SerializedName("MissionInfo")
	public MissionInfo missionInfo;
	
	public WarframeAlert() {
		
	}
	
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

	public MissionInfo getMissionInfo() {
		return missionInfo;
	}

	public void setMissionInfo(MissionInfo missionInfo) {
		this.missionInfo = missionInfo;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).append(startTime).append(endTime).append(missionInfo).toString();
	}
}
