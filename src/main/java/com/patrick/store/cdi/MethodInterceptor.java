package com.patrick.store.cdi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.patrick.store.noncdi.MonitoredMethod;

@MonitoredMethod
@Interceptor
public class MethodInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger("methodInterceptor");
	
	private static final boolean DEBUG = false;
	
	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		if(ic.getMethod().isAnnotationPresent(MonitoredMethod.class)) {
			logger.log(Level.INFO, "Monitored Method intercepted: {0}", ic.getMethod());
			return ic.proceed();
		}
		if(DEBUG) {
			logger.log(Level.INFO, "Non Monitored Method intercepted: {0}", ic.getMethod());			
		}
		return ic.proceed();
	}

} 
