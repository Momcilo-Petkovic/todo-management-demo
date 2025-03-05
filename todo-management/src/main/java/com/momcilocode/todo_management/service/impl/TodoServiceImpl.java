package com.momcilocode.todo_management.service.impl;

import com.momcilocode.todo_management.dto.TodoDto;
import com.momcilocode.todo_management.entity.Todo;
import com.momcilocode.todo_management.repository.TodoRepository;
import com.momcilocode.todo_management.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository, ModelMapper modelMapper) {
        this.todoRepository = todoRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        //convert TodoDto to Todo JPA Entity
//        Todo todo = new Todo();
//        todo.setTitle(todoDto.getTitle());
//        todo.setDescription(todoDto.getDescription());
//        todo.setCompleted(todoDto.isCompleted());

        Todo todo = modelMapper.map(todoDto, Todo.class);

        //Todo Jpa Entity
        Todo savedTodo = todoRepository.save(todo);
        //Convert savedTodo jpa entity object into TodoDto object
//        TodoDto savedTodoDto = new TodoDto();
//        savedTodoDto.setId(savedTodo.getId());
//        savedTodoDto.setTitle(savedTodo.getTitle());
//        savedTodoDto.setDescription(savedTodo.getDescription());
//        savedTodoDto.setCompleted(savedTodo.isCompleted());
        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);
        return savedTodoDto;
    }
}
