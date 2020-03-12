package com.example.project;

import com.example.project.repositories.IRepository;
import com.example.project.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    @Qualifier("IService")
    private IService service;

    @Autowired
    @Qualifier("IRepository")
    private IRepository repository;

    @GetMapping("/")
    public String index() {
        return service.serve();
    }

    @GetMapping("/repo")
    public String repo() {
        return repository.read("test id");
    }
}
