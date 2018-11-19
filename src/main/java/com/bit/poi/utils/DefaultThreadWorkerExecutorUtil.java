package com.bit.poi.utils;

import java.util.concurrent.*;

/**
 * @author pipi_he on 2018/11/19.
 */
public class DefaultThreadWorkerExecutorUtil {

    private static final long DEFAULT_ALIVE_TIME = 30L;

    public static ThreadPoolExecutor getWorkerExecutor(int threadCount, ThreadFactory threadFactory) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(threadCount, threadCount, DEFAULT_ALIVE_TIME, TimeUnit.SECONDS,
                        new SynchronousQueue<Runnable>(), threadFactory);
        executor.prestartAllCoreThreads();
        return executor;
    }

    public static ThreadPoolExecutor getWorkerExecutorWithQueue(int min, int max, int workQueueSize, ThreadFactory threadFactory) {
        ThreadPoolExecutor executor;
        if (workQueueSize <= 0) {
            executor = new ThreadPoolExecutor(min, max, DEFAULT_ALIVE_TIME, TimeUnit.SECONDS,
                    new SynchronousQueue<Runnable>(), threadFactory);
        } else {
            executor = new ThreadPoolExecutor(min, max, DEFAULT_ALIVE_TIME, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>(workQueueSize), threadFactory);
        }
        executor.prestartAllCoreThreads();
        return executor;
    }
}
