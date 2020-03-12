package com.example.project.services.implementations;

import com.example.project.services.IService;
import org.springframework.stereotype.Service;

@Service
public class Service2 implements IService {
    @Override
    public String serve() {
        return "Service 2";
    }
}
