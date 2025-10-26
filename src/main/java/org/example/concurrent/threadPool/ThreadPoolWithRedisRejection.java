package org.example.concurrent.threadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// 模拟 Redis 的任务存储服务（可替换为真实 Redis 客户端）
class RedisTaskStore {
    private static final AtomicInteger taskIdGenerator = new AtomicInteger(0);
    private static final String REDIS_KEY = "rejected_tasks";

    public static void addTask(Runnable task) {
        // 模拟存入 Redis
        int taskId = taskIdGenerator.incrementAndGet();
        System.out.println("任务 " + taskId + " 被拒绝，缓存到 Redis");
        // 实际中使用 RedisTemplate 或 Jedis 存储
    }

    public static Runnable pollTask() {
        // 模拟从 Redis 拉取任务
        return null; // 实际中反序列化并返回任务
    }
}

// 自定义拒绝策略：将任务缓存到 Redis
class RedisRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("任务被拒绝，正在缓存到 Redis...");
        RedisTaskStore.addTask(r);
    }
}

public class ThreadPoolWithRedisRejection {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maxPoolSize = 2;
        int queueCapacity = 2;

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(queueCapacity);
        RejectedExecutionHandler rejectionHandler = new RedisRejectHandler();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                60L, TimeUnit.SECONDS,
                workQueue,
                rejectionHandler
        );

        // 提交多个任务
        for (int i = 0; i < 6; i++) {
            int taskId = i;
            System.out.println("提交任务 " + taskId);
            executor.submit(() -> {
                System.out.println("执行任务 " + taskId);
            });
        }

        // 启动一个定时任务检查 Redis，重新提交任务
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            Runnable task = RedisTaskStore.pollTask();
            if (task != null) {
                System.out.println("从 Redis 拉取任务并重新提交");
                executor.submit(task);
            }
        }, 5, 5, TimeUnit.SECONDS);

        // 关闭线程池（示例中不立即关闭）
        executor.shutdown();
    }
}
