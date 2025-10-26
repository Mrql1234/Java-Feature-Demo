package org.example.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    // 创建一个AtomicInteger实例并初始化为0
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        // 模拟多线程环境
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                // 使用AtomicInteger的incrementAndGet方法进行原子自增操作
                int currentValue = atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " : " + currentValue);
            }
        };

        // 创建两个线程并启动
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        // 等待两个线程执行完成
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印最终的AtomicInteger值
        System.out.println("Final value: " + atomicInteger.get());
    }
}
