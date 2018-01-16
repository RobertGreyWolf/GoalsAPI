package com.example.demo.repositories;

import com.example.demo.models.Todo;
import com.example.demo.models.dao.TodoDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TodoRepository extends MongoRepository<TodoDao, String> {

    TodoDao findByTodoID(int TodoID);
}
