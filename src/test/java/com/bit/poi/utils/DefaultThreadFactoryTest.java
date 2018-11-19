package com.bit.poi.utils;

import org.junit.Test;

/**
 * @author xyd on 2018/11/19.
 */
public class DefaultThreadFactoryTest {

    @Test
    public void test() {
        DefaultThreadFactory factory = new DefaultThreadFactory("poi");
        Thread thread = factory.newThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().toString());
            }
        });
        thread.start();
    }
}
