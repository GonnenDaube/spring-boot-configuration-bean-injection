package com.example.project.service.impls;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class Service1 extends BasicService {
}
