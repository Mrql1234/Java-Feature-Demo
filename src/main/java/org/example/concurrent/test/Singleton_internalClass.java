package org.example.concurrent.test;

/**
 *
 */
public class Singleton_internalClass {
    public Singleton_internalClass (){}

    private static class internalClass {
        private static final Singleton_internalClass instance = new Singleton_internalClass();
    }

    public static Singleton_internalClass getInstance() {
        return internalClass.instance;
    }
}
