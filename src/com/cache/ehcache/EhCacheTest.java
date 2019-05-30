package com.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.MemoryUnit;
import net.sf.ehcache.config.SearchAttribute;
import net.sf.ehcache.config.Searchable;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;

import java.util.List;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/29
 * @time 14:05
 * @package com.cache.ehcache
 * @project 1008MyDemo
 * @description
 */
public class EhCacheTest {


    public static void main(String[] args) {

        // 创建缓存
////        addCache();
////        // 获取缓存
////        Cache myCache = getCache();


        CacheManager cacheManager = CacheManager.create();
        Cache myCache = cacheManager.getCache("123");
        // 放入数据
        init(myCache);

        List keys = myCache.getKeys();
        for (Object key : keys) {
            Element element = myCache.get(key);
            System.out.println("key = " + key + " " + element.getObjectValue());

        }
        Query query = myCache.createQuery();
        Attribute<Object> color = myCache.getSearchAttribute("color");
        Attribute<Object> name = myCache.getSearchAttribute("name");
        System.out.println("color = " + color);

        System.out.println();
        System.out.println();
        System.out.println("查询结果");
        query.includeKeys();
        query.addCriteria(color.ilike("*blue*"));
        query.addCriteria(name.ilike("j*"));

        Results execute = query.execute();
        List<Result> range = execute.range(6, 10);
        List<Result> all = execute.all();
        for (Result result : all) {
            Object key = result.getKey();
            System.out.println("key = " + key);
//            System.out.println(myCache.get(key).getObjectValue());
        }
    }

    private static void init(Cache myCache) {
        addElement(myCache, "001", "bob", "red");
        addElement(myCache, "002", "amy", "red");
        addElement(myCache, "003", "john", "red");
        addElement(myCache, "004", "joe", "blue");
        addElement(myCache, "005", "jack", "blue");
        addElement(myCache, "006", "dog", "blue");
        addElement(myCache, "007", "sam", "green");
        addElement(myCache, "008", "may", "green");
        addElement(myCache, "009", "apple", "green");
        addElement(myCache, "010", "banner", "green");
    }

    private static void addElement(Cache myCache, String id, String name, String color) {
        myCache.put(new Element(new Cat(id, name, color), id));
    }

    private static Cache getCache() {
        CacheManager cacheManager = CacheManager.create();
        return cacheManager.getCache("cacheZtq");
    }

    /**
     * cacheManager 管理 cache
     * cache 创建依赖 cacheConfig
     * cacheConfig 设置name 等详细参数
     * Searchable 对象包括属性对象 SearchAttribute
     */
    private static void addCache() {
        CacheManager cacheManager = CacheManager.create();
        CacheConfiguration cacheConfig = new CacheConfiguration();
        cacheConfig.name("cacheZtq").maxBytesLocalHeap(100, MemoryUnit.MEGABYTES);

        // 指定可查询的属性 color
        SearchAttribute colorAttr = new SearchAttribute();
        colorAttr.name("color");
        // 设置为可搜索
        Searchable searchable = new Searchable();
        searchable.addSearchAttribute(colorAttr);
        //指定Cache的Searchable对象。
        cacheConfig.searchable(searchable);
        Cache cache = new Cache(cacheConfig);
        cacheManager.addCache(cache);
    }
}
