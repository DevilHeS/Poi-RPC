package com.bit.poi.server.support;

import com.bit.poi.server.AbstractServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServer extends AbstractServer {

    private static final Logger LOG = LoggerFactory.getLogger(NettyServer.class);

    @Override
    public void start() {
        LOG.info("poi rpc server {} start!", getName());
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        if (LOG.isDebugEnabled()) {
            LOG.debug("poi rcp server {} start cost {}ms", getName(), (end - start));
        }
    }

    @Override
    public void stop() {

    }
}
