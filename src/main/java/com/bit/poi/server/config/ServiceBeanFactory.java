package com.bit.poi.server.config;

import com.bit.poi.server.config.service.ServiceBean;

import java.util.HashMap;
import java.util.Map;

public class ServiceBeanFactory implements ServiceConfig {

    private Map<String, ServiceBean> serviceBeanMap = new HashMap<String, ServiceBean>(32);

    @Override
    public boolean addService(ServiceBean serviceBean) {
        assert serviceBean != null;
        if (serviceBeanMap.containsKey(serviceBean.getName())) {
            throw new RuntimeException("service " + serviceBean.getName() + " duplicate");
        }
        serviceBeanMap.put(serviceBean.getName(), serviceBean);
        return true;
    }

    @Override
    public boolean removeService(ServiceBean serviceBean) {
        assert serviceBean != null;
        if (serviceBeanMap.containsKey(serviceBean.getName())) {
            serviceBeanMap.remove(serviceBean.getName());
            return true;
        }
        return false;
    }

    @Override
    public ServiceBean getByName(String name) {
        return serviceBeanMap.get(name);
    }
}
