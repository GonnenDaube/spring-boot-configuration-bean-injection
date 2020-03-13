package com.example.project.services;

import framework.ConfigurationBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.ConfigurationException;

@Configuration
public class IServiceFactory extends ConfigurationBeanFactory<IService> {
    @Override
    @Bean(name=IService.NAME)
    public IService get() throws ConfigurationException {
        return getBean(IService.class);
    }
}
