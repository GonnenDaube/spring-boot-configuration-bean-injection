package com.example.project.service.impls;

import com.example.project.queryExecutor.IQueryExecutor;
import com.example.project.queryExecutor.impls.Default;
import com.example.project.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
@Profile("prod")
public class Service2 implements IService {

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
            return queryExecutorMap.get(type).execute("asdasd");
        } catch (NullPointerException e) {
            return def.execute("adsasda");
        }
    }

    @Override
    public String deleteTable(String type) {
        try {
            return queryExecutorMap.get(type).execute("asdasd");
        } catch (NullPointerException e) {
            return def.execute("adsasda");
        }
    }
}
