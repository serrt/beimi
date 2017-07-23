package com.beimi.util.cache;

import com.beimi.util.cache.hazelcast.HazlcastCacheHelper;

public class CacheHelper {
	private static CacheHelper instance = new CacheHelper();
	
	/**
	 * 获取缓存实例
	 */
	public static CacheHelper getInstance(){
		return instance ;
	}
	private static CacheInstance cacheInstance = new HazlcastCacheHelper();
	
	public static CacheBean getOnlineUserCacheBean() {
		return cacheInstance!=null ? cacheInstance.getOnlineCacheBean() : null;
	}
	public static CacheBean getSystemCacheBean() {
		return cacheInstance!=null ? cacheInstance.getSystemCacheBean() : null ;
	}
	
	public static CacheBean getIMRCacheBean() {
		return cacheInstance!=null ? cacheInstance.getIMRCacheBean() : null ;
	}
	
	public static CacheBean getApiUserCacheBean() {
		return cacheInstance!=null ? cacheInstance.getApiUserCacheBean() : null ;
	}
	
}
