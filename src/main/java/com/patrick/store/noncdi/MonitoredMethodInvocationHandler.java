package com.patrick.store.noncdi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonitoredMethodInvocationHandler implements InvocationHandler {
	private static final Logger logger = Logger.getLogger("MonitoredMethod");
	
	ProxyImpl proxyImpl = new ProxyImpl();
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.isAnnotationPresent(MonitoredMethod.class)) {
			logger.log(Level.INFO, "Monitored method {0} invoked.", method.getName());
			return method.invoke(proxyImpl, args);
		}
		return method.invoke(proxyImpl, args);
	}

}
