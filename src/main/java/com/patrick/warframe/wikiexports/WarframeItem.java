package com.patrick.warframe.wikiexports;

public class WarframeItem {
	public String uniqueName;
	public String name;
	public String description;
	public String longDescription;
	public boolean codexSecret;
	public String parentName;
	
	public WarframeItem() {
		
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public boolean isCodexSecret() {
		return codexSecret;
	}

	public void setCodexSecret(boolean codexSecret) {
		this.codexSecret = codexSecret;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Override
	public String toString() {
		return "WarframeItem [uniqueName=" + uniqueName + ", name=" + name + ", description=" + description
				+ ", longDescription=" + longDescription + ", codexSecret=" + codexSecret + ", parentName=" + parentName
				+ "]";
	}
}
