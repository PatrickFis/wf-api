package com.patrick.warframe.data;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class WarframeAlertDeserializer implements JsonDeserializer<WarframeAlert> {

	@Override
	public WarframeAlert deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		JsonObject jsonObject = json.getAsJsonObject().get("Alerts").getAsJsonObject();
		
		String id = jsonObject.get("_id").getAsJsonObject().get("$oid").getAsString();
		LocalDateTime startTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(jsonObject.get("Activation")
				.getAsJsonObject().get("$date").getAsJsonObject().get("$numberLong").getAsLong()),
				ZoneId.systemDefault());
		LocalDateTime endTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(jsonObject.get("Expiry")
				.getAsJsonObject().get("$date").getAsJsonObject().get("$numberLong").getAsLong()),
				ZoneId.systemDefault());
		return null;
	}

}
