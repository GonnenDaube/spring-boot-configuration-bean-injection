package com.example.project.queryExecutor.impls;

import com.example.project.queryExecutor.IQueryExecutor;
import org.springframework.stereotype.Component;

@Component
public class HiveQueryExecutor implements IQueryExecutor {
    @Override
    public String execute(String query) {
        return query + "hive";
    }
}
