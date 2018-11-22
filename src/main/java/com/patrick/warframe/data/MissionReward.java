package com.patrick.warframe.data;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class MissionReward {
	public int credits;
	@SerializedName("countedItems")
	public List<?> countedItems;
	@SerializedName("items")
	public List<?> items;

	public MissionReward() {

	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append(credits).append(countedItems).append(items).toString();
	}
}
