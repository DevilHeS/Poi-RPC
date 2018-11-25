package com.bit.poi.server.config;

public interface ServiceBeanFactory {

    boolean addService(ServiceBean serviceBean);

    boolean removeService(ServiceBean serviceBean);

    ServiceBean getByName(String name);
}
