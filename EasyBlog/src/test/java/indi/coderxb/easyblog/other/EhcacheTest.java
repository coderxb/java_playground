/**
 * EhcacheTest.java   2016年10月28日 下午4:46:55 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.other;

import indi.coderxb.easyblog.BaseTest;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Before;
import org.junit.Test;

public class EhcacheTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        //从classes目录查找ehcache.xml配置文件  
        //CacheManager cacheManager = CacheManager.getInstance();
        CacheManager cacheManager = CacheManager.newInstance("src/main/resources/spring/ehcache.xml");
        //从classes目录查找指定名称的配置文件  
        //CacheManager cacheManager = CacheManager.create(getClass().getResource("/ehcache.xml"));  
        //根据配置文件获得Cache实例
        Cache cache = cacheManager.getCache("CACHE1");
        //清空Cache中的所有元素  
        cache.removeAll();

        //往Cache中添加元素  
        cache.put(new Element("s1", "11111"));
        cache.put(new Element("s2", "22222"));
        cache.put(new Element("s3", "33333"));

        //从Cache中取得元素  
        Element e = cache.get("s3");
        Object s3Value = e.getObjectValue();
        System.out.println(s3Value);

        // 获取缓存管理器中的缓存配置名称
        for (String cacheName : cacheManager.getCacheNames()) {
            System.out.println(cacheName);
        }
        // 获取所有的缓存对象
        for (Object key : cache.getKeys()) {
            System.out.println(key);
        }

        // 得到缓存中的对象数
        System.out.println("cache size = " + cache.getSize());
        // 得到缓存对象占用内存的大小
        System.out.println("Local heap size = " + cache.getStatistics().getLocalHeapSize());

        //卸载缓存管理器  
        cacheManager.shutdown();

    }

}
