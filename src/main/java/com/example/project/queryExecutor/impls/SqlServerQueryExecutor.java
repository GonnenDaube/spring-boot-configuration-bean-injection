package com.example.project.queryExecutor.impls;

import ch.qos.logback.core.joran.spi.DefaultClass;
import com.example.project.queryExecutor.IQueryExecutor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Default
@Profile("prod")
public class SqlServerQueryExecutor implements IQueryExecutor {
    @Override
    public String execute(String query) {
        return query + "sql";
    }
}