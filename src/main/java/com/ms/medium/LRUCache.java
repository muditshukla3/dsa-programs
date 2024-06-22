package com.ms.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {

    private final int capacity;
    private final Map<K, V> cache;
    private final LinkedList<K> cacheOrder;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.cacheOrder = new LinkedList<>();
    }

    public void put(K key, V value){
        if(cache.containsKey(key)){
            cache.put(key, value);
            cacheOrder.remove(key);
            cacheOrder.addFirst(key);
        }else{
            if(cache.size() >= capacity){
                K leastRecentlyUsed = cacheOrder.removeLast();
                cache.remove(leastRecentlyUsed);
            }

            cache.put(key, value);
            cacheOrder.addFirst(key);
        }

    }

    public V get(K key){
        if (!cache.containsKey(key)){
            return null;
        }
        cacheOrder.remove(key);
        cacheOrder.addFirst(key);
        return cache.get(key);
    }

    public K getFirstElement(){
        return cacheOrder.getFirst();
    }

    public K getLeastRecentlyUsedElement(){
        return cacheOrder.getLast();
    }

    public int getCapacity() {
        return cache.size();
    }
}
