package com.patrick.warframe.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestApplication extends Application {
	// Needed for WeaponsEndpoint
}
