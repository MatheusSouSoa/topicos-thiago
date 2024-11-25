package com.example.demo.model.dtos.users;

public record CreateUserDto(
    String name,
    String email,
    Integer age,
    Long id
) {
}
