package com.beimi.util.cache.hazelcast;

import com.beimi.core.BMDataContext;
import com.beimi.util.cache.CacheBean;
import com.beimi.util.cache.CacheInstance;
import com.beimi.util.cache.hazelcast.impl.ApiUserCache;
import com.beimi.util.cache.hazelcast.impl.MultiCache;
import com.beimi.util.cache.hazelcast.impl.OnlineCache;
import com.beimi.util.cache.hazelcast.impl.SystemCache;
/**
 * Hazlcast缓存处理实例类
 * @author admin
 *
 */
public class HazlcastCacheHelper implements CacheInstance{
	/**
	 * 服务类型枚举
	 * @author admin
	 *
	 */
	public enum CacheServiceEnum{
		HAZLCAST_CLUSTER_AGENT_USER_CACHE, HAZLCAST_CLUSTER_AGENT_STATUS_CACHE, HAZLCAST_CLUSTER_QUENE_USER_CACHE,HAZLCAST_ONLINE_CACHE , HAZLCAST_CULUSTER_SYSTEM , HAZLCAST_IMR_CACHE , API_USER_CACHE;
		public String toString(){
			return super.toString().toLowerCase();
		}
	}
	
	@Override
	public CacheBean getOnlineCacheBean() {
		return BMDataContext.getContext().getBean(OnlineCache.class).getCacheInstance(CacheServiceEnum.HAZLCAST_ONLINE_CACHE.toString()) ;
	}
	@Override
	public CacheBean getSystemCacheBean() {
		return BMDataContext.getContext().getBean(SystemCache.class).getCacheInstance(CacheServiceEnum.HAZLCAST_CULUSTER_SYSTEM.toString()) ;
	}
	@Override
	public CacheBean getIMRCacheBean() {
		return BMDataContext.getContext().getBean(MultiCache.class).getCacheInstance(CacheServiceEnum.HAZLCAST_IMR_CACHE.toString()) ;
	}
	@Override
	public CacheBean getApiUserCacheBean() {
		return BMDataContext.getContext().getBean(ApiUserCache.class).getCacheInstance(CacheServiceEnum.API_USER_CACHE.toString()) ;
	}
}
