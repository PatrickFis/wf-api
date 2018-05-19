package com.patrick.store.noncdi;

import java.lang.reflect.Proxy;

/*
 * Demonstrates the problem with calling nested methods and handling them with a proxy.
 */
public class ProxyCaller {
//	public static void main(String[] args) {
//		ProxyInterface proxyInterface = (ProxyInterface) Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(), new Class<?>[] { ProxyInterface.class }, new MonitoredMethodInvocationHandler());
//		proxyInterface.parentMethod();
//		proxyInterface.subMethod();
//	}
}
