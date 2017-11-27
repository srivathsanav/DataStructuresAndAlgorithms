package com.caching;

/**
 * Created by srivathsan on 01/04/16.
 */
public class LazyHolder {

    private static LazyHolder getInstance() {
        return LazyXyz.holder;
    }

    private static class LazyXyz {
        private static LazyHolder holder = new LazyHolder();
    }
}
