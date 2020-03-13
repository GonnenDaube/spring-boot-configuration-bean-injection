package com.example.project.repositories;

public interface IRepository {
    String NAME = "IRepository";

    void create(String body);
    String read(String id);
    void update(String id, String body);
    void delete(String id);
}
