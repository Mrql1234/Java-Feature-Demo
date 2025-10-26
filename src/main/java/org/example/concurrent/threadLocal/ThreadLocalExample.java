package org.example.concurrent.threadLocal;

public class ThreadLocalExample {
    // 创建一个 ThreadLocal 变量
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        // 创建多个线程进行测试
        Runnable task = () -> {
            // 每个线程设置自己的值
            int value = threadLocalValue.get();
            value++;
            threadLocalValue.set(value);
            System.out.println(Thread.currentThread().getName() + " 的值: " + threadLocalValue.get());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
