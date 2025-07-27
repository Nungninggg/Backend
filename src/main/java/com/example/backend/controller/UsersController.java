package com.example.backend.controller;

import com.example.backend.entity.EntityUsers;
import com.example.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<EntityUsers> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityUsers> getUserById(@PathVariable Long id) {
        EntityUsers user = usersService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public EntityUsers createUser(@RequestBody EntityUsers user) {
        return usersService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityUsers> updateUser(@PathVariable Long id, @RequestBody EntityUsers user) {
        EntityUsers updated = usersService.updateUser(id, user);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
