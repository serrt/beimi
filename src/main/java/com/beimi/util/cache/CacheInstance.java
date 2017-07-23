package com.beimi.util.cache;


public interface CacheInstance {
	
	/**
	 * 在线用户
	 * @return
	 */
	public CacheBean getOnlineCacheBean();
	
	/**
	 * 系统缓存
	 * @return
	 */
	public CacheBean getSystemCacheBean();
	
	
	/**
	 * IMR指令
	 * @return
	 */
	public CacheBean getIMRCacheBean();
	
	/**
	 * IMR指令
	 * @return
	 */
	public CacheBean getApiUserCacheBean();
	
}