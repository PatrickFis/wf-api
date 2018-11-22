package com.patrick.warframe.data;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class MissionTimer {
	@SerializedName("$date")
	public LocalDateTimeHolder localDate;
	
	public MissionTimer() {
		
	}
	
	public String toString() {
		return new ToStringBuilder(this).append(localDate).toString();
	}
}