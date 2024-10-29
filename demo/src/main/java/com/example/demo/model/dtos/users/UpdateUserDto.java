package com.example.demo.model.dtos.users;

public record UpdateUserDto(
    String name,
    String email,
    Integer age
) {
  
}
