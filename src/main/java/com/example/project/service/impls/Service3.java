package com.example.project.service.impls;

import com.example.project.queryExecutor.IQueryExecutor;
import com.example.project.queryExecutor.QueryExecutorFactory;
import com.example.project.queryExecutor.QueryExecutorType;
import com.example.project.service.IService;
import framework.EnumQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

@org.springframework.stereotype.Service
@EnumQualifier("MAIN")
public class Service3 implements IService {

    @Autowired
    @Qualifier(QueryExecutorFactory.MAP)
    protected Map<QueryExecutorType, IQueryExecutor> queryExecutors;

    @Autowired
    @Qualifier(QueryExecutorFactory.CONF)
    private IQueryExecutor queryExecutor;

    @Override
    public String createTable(String type) {
        try {
            return this.queryExecutors.get(QueryExecutorType.valueOf(type)).execute("create");
        } catch (Exception e) {
            return this.queryExecutor.execute("create");
        }
    }

    @Override
    public String deleteTable(String type) {
        try {
            return this.queryExecutors.get(QueryExecutorType.valueOf(type)).execute("delete");
        } catch (Exception e) {
            return this.queryExecutor.execute("delete");
        }
    }
}
