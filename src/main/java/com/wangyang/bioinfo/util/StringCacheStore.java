package com.wangyang.bioinfo.util;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangyang
 * @date 2021/6/14
 */
public class StringCacheStore {
    public final static ConcurrentHashMap<String,Object> CACHE_CONTAINER = new ConcurrentHashMap<>();
    public static Optional<String> get(String key){
        return Optional.ofNullable((String) CACHE_CONTAINER.get(key));
    }
    public static void setValue(String key,Object value){
        CACHE_CONTAINER.put(key,value);
    }
    public static void clearByKey(String key){
        CACHE_CONTAINER.remove(key);
    }
    public static void clearAll(){
        CACHE_CONTAINER.clear();
    }

    public static String getValue(String key){
        return (String)CACHE_CONTAINER.get(key);
    }
}
