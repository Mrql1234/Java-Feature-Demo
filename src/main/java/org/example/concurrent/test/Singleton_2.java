package org.example.concurrent.test;

/**
 * 这是饿汉式
 */
public class Singleton_2 {
    private static final Singleton_2 INSTANCE = new Singleton_2();

    private Singleton_2() {}

    public static Singleton_2 getInstance() {
        return INSTANCE;
    }
}
