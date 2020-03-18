package com.example.project.queryExecutor.impls;

import com.example.project.queryExecutor.IQueryExecutor;
import framework.EnumQualifier;
import org.springframework.stereotype.Component;

@Component
@EnumQualifier("ELASTIC")
public class ElasticQueryExecutor implements IQueryExecutor {
    @Override
    public String execute(String query) {
        return query + "elastic";
    }
}
