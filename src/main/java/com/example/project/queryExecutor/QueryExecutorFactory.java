package com.example.project.queryExecutor;

import framework.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.ConfigurationException;
import java.util.List;
import java.util.Map;

@Configuration
public class QueryExecutorFactory extends BeanFactory<IQueryExecutor, QueryExecutorType> {
    public static final String CONF = "QueryExecutorConf";
    public static final String IMPLS = "QueryExecutorImpls";
    public static final String MAP = "QueryExecutorMap";

    public QueryExecutorFactory() {
        super(IQueryExecutor.class, QueryExecutorType.class);
    }

    @Override
    @Bean(CONF)
    public IQueryExecutor get() {
        return super.get();
    }

    @Override
    @Bean(IMPLS)
    public List<IQueryExecutor> getAll() {
        return super.getAll();
    }

    @Override
    @Bean(MAP)
    public Map<QueryExecutorType, IQueryExecutor> getMap() {
        return super.getMap();
    }
}