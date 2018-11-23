package com.patrick.warframe.data;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class LocalDateTimeHolder {
	@SerializedName("$numberLong")
	public LocalDateTime date;
	
	public LocalDateTimeHolder() {
		
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(date).toString();
	}
}
