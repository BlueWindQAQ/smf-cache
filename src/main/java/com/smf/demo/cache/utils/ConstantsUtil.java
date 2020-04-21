package com.smf.demo.cache.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title :
 * @Author : joseph.lv
 * @Date : 2020/4/20
 */
public class ConstantsUtil {
    /**
     * redis缓存常量,如果使用ehcache需在ehcache.xml中对配置
     */
    public static final String PROJECT = "SMF";
    public static final String CACHE_12H=PROJECT+":"+"12h";
    public static final String CACHE_1H=PROJECT+":"+"1h";
    public static final String CACHE_10M=PROJECT+":"+"10m";
    public static final String CACHE_30S=PROJECT+":"+"30s";
    public static final Map<String, Long> cacheNameMap;
    static
    {
        cacheNameMap = new HashMap<>();
        cacheNameMap.put(CACHE_12H, 60*60*12L);
        cacheNameMap.put(CACHE_1H, 60*60*1L);
        cacheNameMap.put(CACHE_10M, 60*10L);
        cacheNameMap.put(CACHE_30S, 30L);
    }
}
