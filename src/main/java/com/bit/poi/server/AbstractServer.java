package com.bit.poi.server;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public abstract class AbstractServer implements Server {

    private String serverName;

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
