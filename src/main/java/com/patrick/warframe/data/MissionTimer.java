package com.patrick.warframe.data;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class MissionTimer {
	@SerializedName("$date")
	public LocalDateTime localDate;
	
	public MissionTimer() {
		
	}
	
	public LocalDateTime getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDateTime localDate) {
		this.localDate = localDate;
	}

	public String toString() {
		return new ToStringBuilder(this).append(localDate).toString();
	}
}
