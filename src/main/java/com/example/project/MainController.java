package com.example.project;

import com.example.project.queryExecutor.IQueryExecutor;
import com.example.project.queryExecutor.QueryExecutorFactory;
import com.example.project.queryExecutor.QueryExecutorType;
import com.example.project.service.IService;
import com.example.project.service.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    @Qualifier(ServiceFactory.CONF)
    private IService service;

    @GetMapping("/create/{type}")
    public String create(@PathVariable String type) {
        return service.createTable(type);
    }

    @GetMapping("/delete/{type}")
    public String delete(@PathVariable String type) {
        return service.deleteTable(type);
    }
}
