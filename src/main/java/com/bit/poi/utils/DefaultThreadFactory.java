package com.bit.poi.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xyd on 2018/11/19.
 */
public class DefaultThreadFactory implements ThreadFactory {

    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(0);
    private final ThreadGroup threadGroup;
    private final AtomicInteger threadNumber = new AtomicInteger(0);
    private final String namePrefix;

    public DefaultThreadFactory(String threadPoolName) {
        SecurityManager sm = System.getSecurityManager();
        threadGroup = sm != null ? sm.getThreadGroup() : Thread.currentThread().getThreadGroup();
        namePrefix = threadPoolName + "-" + POOL_NUMBER.getAndIncrement() + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(threadGroup, r, namePrefix + threadNumber.getAndIncrement(), 0);
        t.setDaemon(Boolean.TRUE);
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
