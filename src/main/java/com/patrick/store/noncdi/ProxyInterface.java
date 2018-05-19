package com.patrick.store.noncdi;

public interface ProxyInterface {
	@MonitoredMethod
	public void parentMethod();
	@MonitoredMethod
	public void subMethod();
}
