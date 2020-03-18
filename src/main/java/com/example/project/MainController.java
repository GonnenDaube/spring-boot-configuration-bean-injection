package com.example.project;

import com.example.project.queryExecutor.IQueryExecutor;
import com.example.project.queryExecutor.QueryExecutorFactory;
import com.example.project.queryExecutor.QueryExecutorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private ApplicationContext context;

    private IQueryExecutor queryExecutor;
    private Map<QueryExecutorType, IQueryExecutor> queryExecutorMap;

    @PostConstruct
    public void init() {
        this.queryExecutor = (IQueryExecutor)context.getBean(QueryExecutorFactory.CONF);
        this.queryExecutorMap = (Map<QueryExecutorType, IQueryExecutor>)context.getBean(QueryExecutorFactory.MAP);
    }

    @GetMapping("/conf")
    public String getConf() {
        return queryExecutor.execute("query");
    }

    @GetMapping("/dyn/{type}")
    public String getDyn(@PathVariable String type) {
        try {
            return queryExecutorMap.get(QueryExecutorType.valueOf(type)).execute("query");
        } catch (NullPointerException e) {
            return queryExecutor.execute("query");
        }
    }
}
