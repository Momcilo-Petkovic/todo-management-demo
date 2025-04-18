package com.momcilocode.todo_management.controller;

import com.momcilocode.todo_management.dto.TodoDto;
import com.momcilocode.todo_management.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Build Add Todo REST API
    @PreAuthorize("hasRole('ADMIN')")  // Only ADMIN can add a Todo
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Build Get Todo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    //  Build Get All Todos REST API
    @PreAuthorize("isAuthenticated()") // Any authenticated user can get all Todos
    @GetMapping()
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    // Build Update Todo REST API
    @PreAuthorize("hasRole('ADMIN')")  // Only ADMIN can update a Todo
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.updateTodo(todoDto, todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    //Build Delete Todo REST API
    @PreAuthorize("hasRole('ADMIN')")  // Only ADMIN can delete a Todo
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo deleted successfully");
    }

    //Build Complete Todo REST API
    @PreAuthorize("isAuthenticated()") // Any authenticated user can complete a Todo
    @PatchMapping("{id}/complete")
    public ResponseEntity<String> completeTodo(@PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.completeTodo(todoId);
        return ResponseEntity.ok("Updated Todo");
    }

    //Build InComplete Todo REST API
    @PreAuthorize("isAuthenticated()")  // Any authenticated user can incomplete a Todo
    @PatchMapping("{id}/incomplete")
    public ResponseEntity<String> inCompleteTodo(@PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok("Updated Todo");
    }
}
