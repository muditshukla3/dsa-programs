package com.ms.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    LRUCache<Integer, String> cache;

    @BeforeEach
    public void setup(){
        cache = new LRUCache<>(5);
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.put(4, "d");
    }

    @Test
    void shouldReturnElementAfterCacheHit(){
        assertEquals("c", cache.get(3));
        assertEquals(3,cache.getFirstElement());
    }

    @Test
    void shouldPutElementAfterCacheMiss(){
        cache.put(5, "e");
        assertEquals(5, cache.getCapacity());
    }

    @Test
    void shouldRemoveLeastRecentlyUsedWhenCacheIsFull(){
        cache.put(5, "e");
        assertEquals(5, cache.getCapacity());
        cache.put(6, "f");
        assertEquals(2, cache.getLeastRecentlyUsedElement());
    }

}