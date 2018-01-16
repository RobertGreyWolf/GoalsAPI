package com.example.demo.controllers;

import com.example.demo.models.Todo;
import com.example.demo.models.dao.TodoDao;
import com.example.demo.repositories.TodoRepository;
import com.example.demo.services.TodoService;
import com.example.demo.transformers.TodoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController
{
    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService)
    {
        this.todoService = todoService;
    }
    //region Post
    @RequestMapping(path = "/todo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateTodo(@RequestBody Todo todo)
    {
        todoService.CreateTodo(todo);
    }
    //endregion

    //region Get
    @RequestMapping(path = "/todo/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List GetAllTodo()
    {
        return todoService.GetAllTodo();
    }

    @RequestMapping(path = "/todo/{todoID}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Todo GetOneTodo(@PathVariable("todoID")int todoID)
    {
        return todoService.GetOneTodo(todoID);
    }
    //endregion

    //region Patch
    @RequestMapping(path = "/todo", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    public void UpdateTodo(@RequestBody Todo todo)
    {
        todoService.UpdateTodo(todo);

    }
    //endregion

    //region Patch
    @RequestMapping(path = "/todo/{todoID}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void DeleteTodo(@PathVariable("todoID")int todoID)
    {
        todoService.DeleteTodo(todoID);

    }
    //endregion

}
