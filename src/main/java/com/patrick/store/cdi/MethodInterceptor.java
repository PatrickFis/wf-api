package com.patrick.store.cdi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class MethodInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger("methodInterceptor");

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		if(ic.getMethod().isAnnotationPresent(InterceptedMethod.class)) {
			logger.log(Level.INFO, "Method intercepted: {0}", ic.getMethod());
			return ic.proceed();
		}
		logger.log(Level.INFO, "Method intercepted: {0}", ic.getMethod());
		return ic.proceed();
	}

} 
