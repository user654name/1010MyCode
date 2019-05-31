package com.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Results;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/30
 * @time 16:34
 * @package com.cache.ehcache
 * @project 1008MyDemo
 * @description
 */
public class EhCacheCatTest {

    public static void main(String[] args) {
        Cache cache = CacheManager.create().getCache("123");
        init(cache);

        Query query = cache.createQuery().includeValues();
        Attribute<Object> name = cache.getSearchAttribute("name");
        Attribute<Object> color = cache.getSearchAttribute("color");
        query.addCriteria(name.ilike("*3*"));
        Results execute = query.execute();
        int size = execute.all().size();
        System.out.println("size = " + size);

        Query query1111 = cache.createQuery().includeValues();
        Results execute1 = query1111.addCriteria(color.ilike("*7*")).execute();
        int size1 = execute1.all().size();
        System.out.println("size1 = " + size1);

    }

    private static void init(Cache cache) {
        for (int i = 0; i < 200; i++) {
            Cat cat = new Cat("" + i, "cat" + i, "red" + i * 7);
            cache.put(new Element(i, cat));
        }
    }
}
