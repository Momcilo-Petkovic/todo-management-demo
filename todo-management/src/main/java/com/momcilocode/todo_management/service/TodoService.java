package com.momcilocode.todo_management.service;

import com.momcilocode.todo_management.dto.TodoDto;
import org.springframework.stereotype.Service;

@Service
public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);
}
