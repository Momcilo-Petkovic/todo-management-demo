package com.momcilocode.todo_management.service.impl;

import com.momcilocode.todo_management.dto.TodoDto;
import com.momcilocode.todo_management.entity.Todo;
import com.momcilocode.todo_management.repository.TodoRepository;
import com.momcilocode.todo_management.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        //convert TodoDto to Todo JPA Entity
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        //Todo Jpa Entity
        Todo savedTodo = todoRepository.save(todo);
        //Convert savedTodo jpa entity object into TodoDto object
        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setId(savedTodo.getId());
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setCompleted(savedTodo.isCompleted());
        return savedTodoDto;
    }
}
