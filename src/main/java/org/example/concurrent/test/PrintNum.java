package org.example.concurrent.test;

/**
 * thread类的构造函数可以接受一个Runnable对象，也可以直接使用一个对象的方法引用，只要该方法符合Runnable接口的run()方法的签名（即无参数、无返回值）。
 *  创建的两个Thread对象，是两个线程，但是它们运行的方法是同一个实例的方法，所以可以访问到同一个对象的成员变量number；线程的访问取决于所运行函数的访问权限
 *  每个对象jvm维护了 等待队列和入口队列：这些结构在 HotSpot 源码中定义，不在 Java 层面可见。
 *      等待队列：线程已经获取锁，但调用wait()方法后：线程进入等待队列，释放锁，waiting状态
 *      入口队列：线程还没有获取锁，等待锁，阻塞状态
 *
 *      线程1：notify()唤醒lock的等待队列中的线程，加到入口队列
 *            wait() 释放锁,将自身线程进行等待队列
 *      线程2：在入口队列中等待锁，锁可用时，jvm将其从入口队列中拿出执行
 *            notify() 唤醒lock的等待队列中的线程1，加到入口队列
 */

public class PrintNum {
    private final Object lock = new Object();
    private int number = 1;
    private static final int MAX_NUMBER = 50;

    public static void main(String[] args) {
        PrintNum printer = new PrintNum();

        // 线程1：打印奇数
        new Thread(printer::printOdd).start();

        // 线程2：打印偶数
        new Thread(printer::printEven).start();
    }

    // 打印奇数的方法
    public void printOdd() {
        synchronized (lock) {
            while (number <= MAX_NUMBER) {
                if (number % 2 == 1) {
                    System.out.println("Odd: " + number);
                    number++;
                    lock.notify(); // 唤醒等待的线程
                } else {
                    try {
                        lock.wait(); // 释放锁并等待
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }

    // 打印偶数的方法
    public void printEven() {
        synchronized (lock) {
            while (number <= MAX_NUMBER) {
                if (number % 2 == 0) {
                    System.out.println("Even: " + number);
                    number++;
                    lock.notify(); // 唤醒等待的线程
                } else {
                    try {
                        lock.wait(); // 释放锁并等待
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }
}
