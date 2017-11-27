package com.caching;

/**
 * Created by srivathsan on 01/04/16.
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton INSTANCE = null;

    public static DoubleCheckSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckSingleton();
                }
            }
        }
        return  INSTANCE;
    }

}
