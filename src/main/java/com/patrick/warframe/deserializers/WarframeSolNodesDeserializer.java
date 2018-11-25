package com.patrick.warframe.deserializers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.patrick.warframe.wikiexports.WarframeSolNodes;

public class WarframeSolNodesDeserializer implements JsonDeserializer<Collection<WarframeSolNodes>> {
	
	@Override
	public Collection<WarframeSolNodes> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		// Turn this into a map since the keys are all named differently
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, JsonObject>>() {}.getType();
		Map<String, JsonObject> jsonMap = gson.fromJson(json, type);
		Collection<WarframeSolNodes> allNodes = new ArrayList<>();

		jsonMap.forEach((nodeId, nodeValues) -> {
			WarframeSolNodes node = new WarframeSolNodes();
			node.setNodeId(nodeId);
			
			// Didn't have to use Optionals here, just wanted to
			Optional<JsonElement> value = Optional.ofNullable(nodeValues.get("value"));
			Optional<JsonElement> enemy = Optional.ofNullable(nodeValues.get("enemy"));
			Optional<JsonElement> nodeType = Optional.ofNullable(nodeValues.get("type"));
			node.setName(value.isPresent() ? value.get().getAsString() : null);
			node.setEnemy(enemy.isPresent() ? enemy.get().getAsString() : null);
			node.setType(nodeType.isPresent() ? nodeType.get().getAsString() : null);
			allNodes.add(node);
		});
		
		return allNodes;
	}

}
