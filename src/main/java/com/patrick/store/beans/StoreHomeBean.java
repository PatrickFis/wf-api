package com.patrick.store.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class StoreHomeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String storeName = "Test Store";
	
	public String getStoreName() {
		return this.storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
