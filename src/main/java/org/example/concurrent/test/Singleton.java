package org.example.concurrent.test;

/**
 *  instance = new Singleton(); 不是原子的，至少包含创建实例和赋值两个步骤，不加 volatile可能发生指令重排
 *  这是 双重检查锁定,需要synchronized和volatile  ，懒汉式
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
