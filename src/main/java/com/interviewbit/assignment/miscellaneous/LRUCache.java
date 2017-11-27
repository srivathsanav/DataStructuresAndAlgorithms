package com.caching;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by srivathsan on 31/03/16.
 */
public class LRUCache {

    private Map<String, CacheEntry> cacheMap = new ConcurrentHashMap<String, CacheEntry>();

    private int MAX_LRU_CACHE_SIZE = 10;


    private CacheEntry head;

    private CacheEntry tail;

    int currentCacheSize = 0;

    public LRUCache(int MAX_LRU_CACHE_SIZE) {
        this.MAX_LRU_CACHE_SIZE = MAX_LRU_CACHE_SIZE;
        head = new CacheEntry("head", null);
        tail = new CacheEntry("tail", null);
        head.setNext(tail);
        head.setPrevious(null);
        tail.setPrevious(head);
        tail.setNext(null);
    }

    public void put(String key, String value) {
        //1. Check size
        //2. If less add
        //3. If more , check it is for same key, if yes update
        //4. If more, different key then, purge old entry and add new

        if (cacheMap.get(key) != null) {
            //Traverse list and update value
        } else {
            if (currentCacheSize >= MAX_LRU_CACHE_SIZE) {
                // remove existing entry
            }
            // add this entry to front
            //accessed
        }

    }




    public String get(String key) {
        CacheEntry entry = cacheMap.get(key);
        // Mark this entry as accessed
        return entry.getValue();
    }


    private void accessed(CacheEntry entry) {
        if (entry != null) {
            remove(entry);
            addFront(entry);
        }
    }

    private void addFront(CacheEntry entry) {
        if (entry != null) {
            CacheEntry next = head.getNext();
            head.setNext(entry);
            entry.setPrevious(head);
            entry.setNext(next);
            if (next != null) {
                next.setPrevious(entry);
            }
        }
    }

    private void remove(CacheEntry entry) {
        entry.getPrevious().setNext(entry.getNext());
        if (entry.getNext() != null) {
            entry.setPrevious(entry.getPrevious());
        }
        entry = null;
    }
}
