package com.patrick.warframe.beans;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WarframeBaseBean implements Serializable {
	private static final long serialVersionUID = -4066976078189380371L;

	public Gson getPrettyPrintingGson() {
		GsonBuilder builder = new GsonBuilder();
		return builder.setPrettyPrinting().create();
	}
}
