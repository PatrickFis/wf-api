package com.patrick.warframe.data;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class MissionRewardDeserializer implements JsonDeserializer<MissionReward> {
	// Examples of mission rewards
	// missionReward={"credits":8600,"countedItems":[{"ItemType":"/Lotus/Types/Items/MiscItems/Plastids","ItemCount":300}]}
	// missionReward={"credits":11600,"items":["/Lotus/StoreItems/Upgrades/Mods/FusionBundles/AlertFusionBundleLarge"]}

	@Override
	public MissionReward deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		MissionReward missionReward = new MissionReward();

		int credits = json.getAsJsonObject().get("credits").getAsInt();

		JsonElement countedItemsJson = json.getAsJsonObject().get("countedItems");
		Map<String, Integer> countedItems = null;
		if (countedItemsJson != null) {
			JsonArray countedItemsArray = countedItemsJson.getAsJsonArray();
			countedItems = new HashMap<>();
			for (int i = 0; i < countedItemsArray.size(); i++) {
				JsonObject itemsObject = countedItemsArray.get(i).getAsJsonObject();
				countedItems.put(itemsObject.get("ItemType").getAsString(), itemsObject.get("ItemCount").getAsInt());
			}
		}

		JsonElement itemsJson = json.getAsJsonObject().get("items");
		List<String> items = null;
		if (itemsJson != null) {
			JsonArray itemsArray = itemsJson.getAsJsonArray();
			items = new ArrayList<>();
			Iterator<JsonElement> itemsIterator = itemsArray.iterator();
			while (itemsIterator.hasNext()) {
				items.add(itemsIterator.next().getAsJsonPrimitive().getAsString());
			}
		}

		missionReward.setCredits(credits);
		missionReward.setCountedItems(countedItems);
		missionReward.setItems(items);
		return missionReward;
	}

}
