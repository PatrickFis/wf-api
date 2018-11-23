package com.patrick.warframe.wikiexports;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;
import com.patrick.warframe.data.EventMessage;
import com.patrick.warframe.data.GenericID;
import com.patrick.warframe.data.MissionTimer;

public class WarframeEvent {
	@SerializedName("Prop")
	public String prop;
	@SerializedName("ImageUrl")
	public String imageUrl;
	@SerializedName("Priority")
	public boolean priority;
	@SerializedName("MobileOnly")
	public boolean mobileOnly;
	@SerializedName("_id")
	public GenericID id;
	@SerializedName("Messages")
	public List<EventMessage> messages;
	@SerializedName("Date")
	public MissionTimer date;
	
	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public boolean isMobileOnly() {
		return mobileOnly;
	}

	public void setMobileOnly(boolean mobileOnly) {
		this.mobileOnly = mobileOnly;
	}

	public GenericID getId() {
		return id;
	}

	public void setId(GenericID id) {
		this.id = id;
	}

	public List<EventMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<EventMessage> messages) {
		this.messages = messages;
	}

	public MissionTimer getDate() {
		return date;
	}

	public void setDate(MissionTimer date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(prop).append(imageUrl).append(priority).append(mobileOnly).append(id).build();
	}

}
