package com.example.project.repositories.repos;

import com.example.project.repositories.IRepository;
import org.springframework.stereotype.Repository;

@Repository
public class Repository1 implements IRepository {
    @Override
    public void create(String body) {
        System.out.println("Created body 1");
    }

    @Override
    public String read(String id) {
        System.out.println("Read id 1");
        return "Body 1";
    }

    @Override
    public void update(String id, String body) {
        System.out.println("Updated id 1");
    }

    @Override
    public void delete(String id) {
        System.out.println("Deleted id 1");
    }
}
