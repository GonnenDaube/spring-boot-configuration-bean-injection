package com.example.project.queryExecutor.impls;

import com.example.project.queryExecutor.IQueryExecutor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Default
@Profile({"dev"})
public class ElasticQueryExecutor implements IQueryExecutor {
    @Override
    public String execute(String query) {
        return query + "elastic";
    }
}
