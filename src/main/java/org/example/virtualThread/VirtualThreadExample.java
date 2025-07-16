package org.example.virtualThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadExample {
    public static void main(String[] args) {
        // 使用虚拟线程的线程池
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        // 提交任务到虚拟线程池中执行
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is running on virtual thread: " + Thread.currentThread());
                try {
                    Thread.sleep(1000); // 模拟耗时操作
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Task " + taskId + " was interrupted.");
                }
                System.out.println("Task " + taskId + " completed.");
            });
        }

        // 关闭线程池
        executor.shutdown();

        // 等待所有任务完成，最多等待10秒
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
