package com.bit.poi.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xyd on 2018/11/19.
 */
public class DefaultThreadWorkerExecutorUtilTest {

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    @Test
    public void getWorkerExecutorTest() {
        ThreadPoolExecutor executor = DefaultThreadWorkerExecutorUtil.getWorkerExecutor(1, new DefaultThreadFactory("poi"));
        executor.submit(runnable);
        Boolean rejectFlag = false;
        try {
            executor.submit(runnable);
        } catch (RejectedExecutionException ree) {
            rejectFlag = true;
        }
        Assert.assertTrue(rejectFlag);
    }

    @Test
    public void getWorkerExecutorWithSyncQueueTest() {
        ThreadPoolExecutor executor =
                DefaultThreadWorkerExecutorUtil.getWorkerExecutorWithQueue(1, 2, -1, new DefaultThreadFactory("poi"));
        //SynchronousQueue
        executor.submit(runnable);
        executor.submit(runnable);
        Boolean rejectFlag = false;
        try {
            executor.submit(runnable);
        } catch (RejectedExecutionException ree) {
            rejectFlag = true;
        }
        Assert.assertTrue(rejectFlag);
    }

    @Test
    public void getWorkerExecutorWithBlockQueueTest() throws InterruptedException {
        ThreadPoolExecutor executor = DefaultThreadWorkerExecutorUtil.getWorkerExecutorWithQueue(1, 2, 1, new DefaultThreadFactory("poi"));
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        Boolean rejectFlag = false;
        try {
            executor.submit(runnable);
        }catch (RejectedExecutionException ree) {
            rejectFlag = true;
        }
        Thread.sleep(5000);
        Assert.assertTrue(rejectFlag);
    }
}
