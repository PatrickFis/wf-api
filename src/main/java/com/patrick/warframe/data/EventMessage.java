package com.patrick.warframe.data;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class EventMessage {
	@SerializedName("LanguageCode")
	public String languageCode;
	@SerializedName("Message")
	public String message;
	
	public EventMessage() {
		
	}
	
	public String getLanguageCode() {
		return languageCode;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append(languageCode).append(message).toString();
	}
}
