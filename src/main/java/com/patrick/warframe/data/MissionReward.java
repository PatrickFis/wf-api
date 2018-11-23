package com.patrick.warframe.data;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class MissionReward {
	public int credits;
	@SerializedName("countedItems")
	public Map<String, Integer> countedItems;
	@SerializedName("items")
	public List<String> items;

	public MissionReward() {

	}
	
	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Map<String, Integer> getCountedItems() {
		return countedItems;
	}

	public void setCountedItems(Map<String, Integer> countedItems) {
		this.countedItems = countedItems;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(credits).append(countedItems).append(items).toString();
	}
}
