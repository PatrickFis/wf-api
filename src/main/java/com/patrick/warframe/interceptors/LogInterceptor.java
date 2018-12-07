package com.patrick.warframe.interceptors;

import java.time.Duration;
import java.time.Instant;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

import com.patrick.warframe.annotations.Logged;

@Logged
@Interceptor
public class LogInterceptor {

	@Inject
	private Logger log;
	
	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		if(ic.getMethod().isAnnotationPresent(Logged.class)) {
			Instant start = Instant.now();
			Object obj = ic.proceed();
			log.infof("Method %s took %d ms to complete", ic.getMethod().getName(), Duration.between(start, Instant.now()).toMillis());
			return obj;
		}
		return ic.proceed();
	}

}
