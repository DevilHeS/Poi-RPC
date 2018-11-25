package com.bit.poi.server.support;

import com.bit.poi.server.AbstractServer;
import com.bit.poi.utils.DefaultThreadWorkerExecutorUtil;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;

public class NettyServer extends AbstractServer {

    private static final Logger LOG = LoggerFactory.getLogger(NettyServer.class);

    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ExecutorService executorService;

    @Override
    protected void startServer() {
        try {
            if (Epoll.isAvailable()) {
                bossGroup = new EpollEventLoopGroup();
                workerGroup = new EpollEventLoopGroup();
            } else {
                bossGroup = new NioEventLoopGroup();
                workerGroup = new NioEventLoopGroup();
            }
            //executorService = DefaultThreadWorkerExecutorUtil.getWorkerExecutorWithQueue();
        } catch (Exception e) {

        }
    }

    @Override
    public void stop() {

    }
}
