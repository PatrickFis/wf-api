package com.patrick.store.noncdi;

public class ProxyImpl implements ProxyInterface {

	/*
	 * (non-Javadoc)
	 * @see com.patrick.store.noncdi.ProxyInterface#parentMethod()
	 * 
	 * Demonstrates the problem with calling nested methods and handling them with a proxy.
	 */
	
	@Override
	public void parentMethod() {
		System.out.println("Parent method called");
		subMethod();
	}

	@Override
	public void subMethod() {
		System.out.println("Submethod called");
	}

}
