package com.example.project.service.impls;

import com.example.project.queryExecutor.IQueryExecutor;
import com.example.project.queryExecutor.QueryExecutorFactory;
import com.example.project.queryExecutor.QueryExecutorType;
import com.example.project.service.IService;
import framework.EnumQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@EnumQualifier("SECONDARY")
public class Service2 implements IService {

    @Autowired
    @Qualifier(QueryExecutorFactory.CONF)
    private IQueryExecutor queryExecutor;

    @Override
    public String createTable(String type) {
        return queryExecutor.execute("create");
    }

    @Override
    public String deleteTable(String type) {
        return queryExecutor.execute("delete");
    }
}
