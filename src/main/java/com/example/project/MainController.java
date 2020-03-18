package com.example.project;

import com.example.project.queryExecutor.IQueryExecutor;
import com.example.project.queryExecutor.QueryExecutorFactory;
import com.example.project.queryExecutor.QueryExecutorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    @Qualifier(QueryExecutorFactory.CONF)
    private IQueryExecutor queryExecutor;

    @Autowired
    @Qualifier(QueryExecutorFactory.MAP)
    private Map<QueryExecutorType, IQueryExecutor> queryExecutorMap;

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
