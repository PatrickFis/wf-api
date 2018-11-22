package com.patrick.warframe.interceptors;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.patrick.warframe.annotations.Cached;

@Cached
@Interceptor
/**
 * Caches collections used on the homepage. May need a way to periodically clear
 * the cache to remove old data. There are pre-built caching solutions,
 * I just wanted to write my own.
 * @author Patrick
 *
 */
public class CachingInterceptor {

	private static Map<Method, Collection> cache = new ConcurrentHashMap<>();

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		if(ic.getMethod().isAnnotationPresent(Cached.class)) {
			if(cache.containsKey(ic.getMethod())) {
				return cache.get(ic.getMethod());
			} else {
				cache.put(ic.getMethod(), (Collection) ic.proceed());
				return cache.get(ic.getMethod());
			}
		}
		
		return ic.proceed();
	}

}
