package com.example.project.repositories;

import framework.ConfigurationBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.ConfigurationException;

@Configuration
public class IRepositoryFactory extends ConfigurationBeanFactory<IRepository> {
    @Override
    @Bean(name="IRepository")
    public IRepository get() throws ConfigurationException {
        return getBean(IRepository.class);
    }
}
