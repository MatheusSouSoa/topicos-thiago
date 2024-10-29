package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.dtos.users.CreateUserDto;
import com.example.demo.model.dtos.users.UpdateUserDto;
import com.example.demo.model.entities.User;

@Service
public class UserService {
    private final List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
        User user1 = new User(1, 21, "Maria", "maria@gmail.com");
        User user2 = new User(2, 22, "João", "joao@gmail.com");
        User user3 = new User(3, 23, "José", "jose@gmail.com");
        User user4 = new User(4, 24, "Luiz", "luiz@gmail.com");
        User user5 = new User(5, 25, "Joice", "joice@gmail.com");
        userList.addAll(List.of(user1, user2, user3, user4, user5));
    }

    public Optional<User> getUserById(Integer id) {
        return userList.stream().filter(user -> user.getId()==id).findFirst();
    }

    public List<User> getAll() {
        return new ArrayList<>(userList);
    }

    public User create(CreateUserDto CriaUsuario) {
        User user = new User(CriaUsuario.id(), CriaUsuario.age(), CriaUsuario.name(), CriaUsuario.email());
        userList.add(user);
        return user;
    }

    public ResponseEntity<User> update(Integer id, UpdateUserDto AtualizaUsuario) {
        Optional<User> optionalUser = getUserById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(AtualizaUsuario.name());
            existingUser.setEmail(AtualizaUsuario.email());
            existingUser.setAge(AtualizaUsuario.age());
            return ResponseEntity.ok(existingUser);  
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  
        }
    }

    public ResponseEntity<Void> delete(Integer id) {
        Optional<User> optionalUser = getUserById(id);
        if (optionalUser.isPresent()) {
            userList.remove(optionalUser.get());
            return ResponseEntity.noContent().build();  
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  
        }
    }
}
