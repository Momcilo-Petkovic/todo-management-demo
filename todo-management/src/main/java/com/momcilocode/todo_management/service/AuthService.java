package com.momcilocode.todo_management.service;

import com.momcilocode.todo_management.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
}
