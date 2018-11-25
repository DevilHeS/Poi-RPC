package com.bit.poi.server.config;

import com.bit.poi.server.config.service.ServiceBean;

public interface ServiceConfig {

    boolean addService(ServiceBean serviceBean);

    boolean removeService(ServiceBean serviceBean);

    ServiceBean getByName(String name);
}
