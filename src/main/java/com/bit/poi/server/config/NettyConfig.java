package com.bit.poi.server.config;

public class NettyConfig {

    private int bossThreadCount;
    private int workThreadCount;
    private int serviceThreadCount;

    public int getBossThreadCount() {
        return bossThreadCount;
    }

    public void setBossThreadCount(int bossThreadCount) {
        this.bossThreadCount = bossThreadCount;
    }

    public int getWorkThreadCount() {
        return workThreadCount;
    }

    public void setWorkThreadCount(int workThreadCount) {
        this.workThreadCount = workThreadCount;
    }

    public int getServiceThreadCount() {
        return serviceThreadCount;
    }

    public void setServiceThreadCount(int serviceThreadCount) {
        this.serviceThreadCount = serviceThreadCount;
    }
}
