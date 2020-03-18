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
public class Service implements IService {

    @Autowired
    @Qualifier(QueryExecutorFactory.MAP)
    protected Map<QueryExecutorType, IQueryExecutor> queryExecutors;

    @Override
    public String createTable(String type) {
        return this.queryExecutors.get(QueryExecutorType.valueOf(type)).execute("create");
    }

    @Override
    public String deleteTable(String type) {
        return this.queryExecutors.get(QueryExecutorType.valueOf(type)).execute("delete");
    }
}
