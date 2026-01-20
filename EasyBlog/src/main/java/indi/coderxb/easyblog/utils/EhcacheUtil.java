/**
 * EhcacheUtil.java   2016年10月28日 下午7:31:10 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.utils;

import java.net.URL;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheUtil {

    private static final String path = "/spring/ehcache.xml";

    private URL url = null;

    private CacheManager manager = null;

    private static EhcacheUtil cache = null;

    private EhcacheUtil(String path) {
        url = getClass().getResource(path);
        manager = CacheManager.create(url);
    }

    public static EhcacheUtil getInstance() {
        if (cache == null) {
            cache = new EhcacheUtil(path);
        }
        return cache;
    }

    public void put(String cacheName, String key, Object value) {
        Cache cache = manager.getCache(cacheName);
        Element element = new Element(key, value);
        cache.put(element);
    }

    public Object get(String cacheName, String key) {
        Cache cache = manager.getCache(cacheName);
        Element element = cache.get(key);
        return element == null ? null : element.getObjectValue();
    }

    public Cache get(String cacheName) {
        return manager.getCache(cacheName);
    }

    public void remove(String cacheName, String key) {
        Cache cache = manager.getCache(cacheName);
        cache.remove(key);
    }

}