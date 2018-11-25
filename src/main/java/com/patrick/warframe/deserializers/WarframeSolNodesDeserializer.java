package com.patrick.warframe.deserializers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.patrick.warframe.wikiexports.WarframeSolNodes;

public class WarframeSolNodesDeserializer implements JsonDeserializer<Collection<WarframeSolNodes>> {
	
	@Override
	public Collection<WarframeSolNodes> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject nodes = json.getAsJsonObject();
		Collection<WarframeSolNodes> allNodes = new ArrayList<>();
		
		// This is not exactly ideal, but all the nodes are represented like
		// "SolNode<Number>":{"value":"SolNode0","enemy":"Sentient","type":"Ancient
		// Retribution"}
		String solNode = "SolNode";
		int i = 0;
		
		while(nodes.get(solNode + i) != null) {
			JsonObject element = nodes.get(solNode + i).getAsJsonObject();
			WarframeSolNodes node = new WarframeSolNodes();
			
			// Didn't have to use Optionals here, just wanted to
			Optional<JsonElement> value = Optional.ofNullable(element.get("value"));
			Optional<JsonElement> enemy = Optional.ofNullable(element.get("enemy"));
			Optional<JsonElement> type = Optional.ofNullable(element.get("type"));
			node.setValue(value.isPresent() ? value.get().getAsString() : null);
			node.setEnemy(enemy.isPresent() ? enemy.get().getAsString() : null);
			node.setType(type.isPresent() ? type.get().getAsString() : null);			
			
			allNodes.add(node);
			i++;
		}
		return allNodes;
	}

}
