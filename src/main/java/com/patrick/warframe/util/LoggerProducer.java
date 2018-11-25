package com.patrick.warframe.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.jboss.logging.Logger;

public class LoggerProducer {
	
	@Produces
	public Logger getLogger(InjectionPoint ip) {
		return Logger.getLogger(ip.getMember().getDeclaringClass());
	}
	
}
