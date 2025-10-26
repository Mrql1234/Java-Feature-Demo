package org.example.concurrent.utilClass;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        // 定义一个CountDownLatch，初始计数器为3
        CountDownLatch latch = new CountDownLatch(3);

        // 模拟三个任务的执行线程
        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " 正在执行任务...");
                Thread.sleep(1000); // 模拟任务执行耗时
                System.out.println(Thread.currentThread().getName() + " 完成任务");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown(); // 任务完成后，计数器减1
            }
        };

        // 创建三个线程并启动
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // 主线程等待所有子线程完成任务
            latch.await();
            System.out.println("所有任务已完成，主线程继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
