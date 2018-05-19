package com.patrick.store.cdi;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class MethodInterceptor {

	private static final Logger logger = Logger.getLogger("methodInterceptor");
	
	public MethodInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		if(ic.getMethod().isAnnotationPresent(InterceptedMethod.class)) {
			logger.log(Level.INFO, "Method intercepted: {0}", ic.getMethod());
			return ic.proceed();
		}
		return ic.proceed();
	}

}
