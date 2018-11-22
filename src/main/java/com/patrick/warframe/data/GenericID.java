package com.patrick.warframe.data;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

public class GenericID {
	@SerializedName("$oid")
	public String id;
	
	public GenericID() {
		
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).toString();
	}
}
