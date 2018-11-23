package com.patrick.warframe.interceptors;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.patrick.warframe.annotations.Cached;

/**
 * Caches collections used by WarframeBean.
 * 
 * This originally just used a ConcurrentHashMap, but I'm trying Guava instead.
 * https://github.com/google/guava/wiki/CachesExplained
 * 
 * @author Patrick
 *
 */
@Cached
@Interceptor
public class CachingInterceptor {

	private static Cache<Method, Collection<?>> collectionCache = CacheBuilder.newBuilder()
			.expireAfterWrite(5, TimeUnit.MINUTES).build();
	
	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		return collectionCache.get(ic.getMethod(), new Callable<Collection<?>>() {
			@Override
			public Collection<?> call() throws Exception {
				return (Collection<?>) ic.proceed();
			}
			
		});
	}

}
