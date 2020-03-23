package com.example.project.service.impls;

import com.example.project.queryExecutor.IQueryExecutor;
import com.example.project.queryExecutor.impls.Default;
import com.example.project.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Map;

public abstract class BasicService implements IService {

    @Autowired
    private Map<String, IQueryExecutor> queryExecutorMap;

    private IQueryExecutor def;

    @PostConstruct
    public void init() throws Exception {
        this.def = queryExecutorMap.values().stream()
                .filter(executor -> executor
                        .getClass()
                        .getDeclaredAnnotation(Default.class) != null)
                .findFirst()
                .orElseThrow(Exception::new);
    }

    @Override
    public String createTable(String type) {
        try {
            return queryExecutorMap.get(type).execute("create");
        } catch (NullPointerException e) {
            return def.execute("create");
        }
    }

    @Override
    public String deleteTable(String type) {
        try {
            return queryExecutorMap.get(type).execute("delete");
        } catch (NullPointerException e) {
            return def.execute("delete");
        }
    }
}
