package com.example.project.queryExecutor;

import framework.BeanFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryExecutorFactory extends BeanFactory<IQueryExecutor, QueryExecutorType> {
    public QueryExecutorFactory() {
        super(IQueryExecutor.class, QueryExecutorType.class);
    }
}