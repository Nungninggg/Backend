package com.example.backend.service;

import com.example.backend.entity.EntityUsers;
import com.example.backend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    public List<EntityUsers> getAllUsers() {
        return userRepository.findAll();
    }

    public EntityUsers getUserById(Long id) {
        return userRepository.findById(id);
    }

    public EntityUsers createUser(EntityUsers user) {
        return userRepository.save(user);
    }

    public EntityUsers updateUser(Long id, EntityUsers user) {
        EntityUsers existing = userRepository.findById(id);
        if (existing != null) {
            existing.setUsername(user.getUsername());
            existing.setEmail(user.getEmail());
            existing.setRole(user.getRole());
            existing.setDepartment(user.getDepartment());
            return userRepository.save(existing);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
