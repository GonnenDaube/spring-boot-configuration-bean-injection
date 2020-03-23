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
public class Service2 extends BasicService {
}
