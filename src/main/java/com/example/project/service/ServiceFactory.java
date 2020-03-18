package com.example.project.service;

import framework.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class ServiceFactory extends BeanFactory<IService, ServiceType> {
    public static final String CONF = "IServiceConf";
    public static final String IMPLS = "IServiceImpls";
    public static final String MAP = "IServiceMap";

    public ServiceFactory() {
        super(IService.class, ServiceType.class);
    }

    @Override
    @Bean(CONF)
    public IService get() {
        return super.get();
    }

    @Override
    @Bean(IMPLS)
    public List<IService> getAll() {
        return super.getAll();
    }

    @Override
    @Bean(MAP)
    public Map<ServiceType, IService> getMap() {
        return super.getMap();
    }
}