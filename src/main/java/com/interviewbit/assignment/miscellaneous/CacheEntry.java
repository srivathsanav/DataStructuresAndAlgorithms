package com.caching;

/**
 * Created by srivathsan on 31/03/16.
 */
public class CacheEntry {

    private CacheEntry next;

    private CacheEntry previous;

    private String key;

    private String value;

    public void setNext(CacheEntry next) {
        this.next = next;
    }

    public void setPrevious(CacheEntry previous) {
        this.previous = previous;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CacheEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public CacheEntry getNext() {
        return next;
    }

    public CacheEntry getPrevious() {
        return previous;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
