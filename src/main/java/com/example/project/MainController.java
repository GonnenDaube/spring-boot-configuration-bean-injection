package com.example.project;

import com.example.project.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private IService service;

    @PostConstruct
    public void init() {

    }

    @GetMapping("/create/{type}")
    public String create(@PathVariable String type) {
        return service.createTable(type);
    }

    @GetMapping("/delete/{type}")
    public String delete(@PathVariable String type) {
        return service.deleteTable(type);
    }
}
