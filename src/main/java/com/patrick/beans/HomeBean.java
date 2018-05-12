package com.patrick.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.patrick.library.interfaces.LibraryInventory;

@Named
@ViewScoped
public class HomeBean implements Serializable {
	private static final long serialVersionUID = 633040440398716820L;
	
	private String home = "Home page";
	
	@Inject
	private LibraryInventory library;
	
	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}
	
	
}
