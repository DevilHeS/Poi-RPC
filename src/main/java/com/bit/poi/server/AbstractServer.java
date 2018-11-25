package com.bit.poi.server;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public abstract class AbstractServer implements Server {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractServer.class);

    private String serverName;

    @Override
    public void start() {
        LOG.info("poi rpc server {} start!", getName());
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        if (LOG.isDebugEnabled()) {
            LOG.debug("poi rcp server {} start cost {}ms", getName(), (end - start));
        }
    }

    protected abstract void startServer();

    @Override
    public void refresh() {
        //nothing to do!
    }

    @Override
    public String getName() {
        if (StringUtils.isBlank(serverName)) {
            serverName = UUID.randomUUID().toString();
        }
        return serverName;
    }

    public void setServerName(String name) {
        this.serverName = name;
    }
}
