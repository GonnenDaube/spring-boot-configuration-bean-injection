package com.example.project.repositories.repos;

import com.example.project.repositories.IRepository;
import org.springframework.stereotype.Repository;

@Repository
public class Repository2 implements IRepository {
    @Override
    public void create(String body) {
        System.out.println("Created body 2");
    }

    @Override
    public String read(String id) {
        System.out.println("Read id 2");
        return "Body 2";
    }

    @Override
    public void update(String id, String body) {
        System.out.println("Updated id 2");
    }

    @Override
    public void delete(String id) {
        System.out.println("Deleted id 2");
    }
}
