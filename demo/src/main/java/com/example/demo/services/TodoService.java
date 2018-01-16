package com.example.demo.services;

import com.example.demo.Exceptions.InvalidInput;
import com.example.demo.Exceptions.NotFound;
import com.example.demo.models.Todo;
import com.example.demo.models.dao.TodoDao;
import com.example.demo.repositories.TodoRepository;
import com.example.demo.transformers.TodoTransformer;
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService
{
    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {this.todoRepository = todoRepository;}


    public void CreateTodo(Todo todo)
    {
        if(todoRepository.findByTodoID(todo.getTodoID())==null)
        {
            TodoDao todoDao = TodoTransformer.transform(todo);
            todoRepository.save(todoDao);
        }
        else
        {
            throw new InvalidInput("A todo using this id has already been created");
        }
    }

    public List GetAllTodo()
    {
        if(todoRepository.findAll() != null)
        {
            return todoRepository.findAll();
        }
        else
        {
            throw new NotFound("Could not find any todos");
        }

    }

    public Todo GetOneTodo(int todoID)
    {
        if(todoRepository.findByTodoID(todoID)!=null)
        {
            TodoDao todoDao = todoRepository.findByTodoID(todoID);
            return TodoTransformer.transform(todoDao);
        }
        else
        {
            throw new NotFound("Could not find any todo's with that ID");
        }
    }

    public void UpdateTodo(Todo todo)
    {
        if(todoRepository.findByTodoID(todo.getTodoID())!=null)
        {
            TodoDao todoDao = todoRepository.findByTodoID(todo.getTodoID());
            todoDao.setTodoTitle(todo.getTodoTitle());
            todoRepository.save(todoDao);
        }
        else
        {
            throw new InvalidInput("Could not find a todo with this ID.");
        }
    }

    public void DeleteTodo(int todoID)
    {
        TodoDao todoDao = todoRepository.findByTodoID(todoID);
        todoRepository.delete(todoDao);
    }
}
