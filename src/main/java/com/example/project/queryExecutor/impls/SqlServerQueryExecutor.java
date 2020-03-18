package com.example.project.queryExecutor.impls;

import com.example.project.queryExecutor.IQueryExecutor;
import com.example.project.queryExecutor.QueryExecutorType;
import framework.EnumQualifier;
import org.springframework.stereotype.Component;

@Component
@EnumQualifier("SQL_SERVER")
public class SqlServerQueryExecutor implements IQueryExecutor {
    @Override
    public String execute(String query) {
        return query + "sql";
    }
}