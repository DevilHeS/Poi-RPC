package com.bit.poi.server.config;

public class ServiceBean {

    private String name;
    private Class clz;
    private Object bean;

    public ServiceBean(String name, Class clz, Object bean) {
        this.name = name;
        this.clz = clz;
        this.bean = bean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getClz() {
        return clz;
    }

    public void setClz(Class clz) {
        this.clz = clz;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
