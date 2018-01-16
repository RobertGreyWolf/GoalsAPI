package com.example.demo.transformers;

import com.example.demo.models.Todo;
import com.example.demo.models.dao.TodoDao;

public class TodoTransformer {

    public static Todo transform(TodoDao todoDao) {
        Todo todo = new Todo();
        todo.setTodoTitle(todoDao.getTodoTitle());
        todo.setTodoID(todoDao.getTodoID());
        return todo;
    }

    public static TodoDao transform(Todo todo) {
        TodoDao todoDao = new TodoDao();
        todoDao.setTodoTitle(todo.getTodoTitle());
        todoDao.setTodoID(todo.getTodoID());
        return todoDao;
    }

}
