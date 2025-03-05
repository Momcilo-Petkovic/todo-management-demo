package com.momcilocode.todo_management.service;

import com.momcilocode.todo_management.dto.TodoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long Id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto, Long id);

    void deleteTodo(Long id);

    TodoDto completeTodo(Long id);

    TodoDto inCompleteTodo(Long id);

}
