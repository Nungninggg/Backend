package com.example.backend.service;

import com.example.backend.entity.EntityUsers;
import com.example.backend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;  // ต้องเรียก userRepository ให้ตรง

    public List<EntityUsers> getAllUsers() {
        return userRepository.findAll();
    }

    public EntityUsers getUserById(Long id) {
        // ใช้ orElseThrow() กับ Optional
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public EntityUsers createUser(EntityUsers user) {
        return userRepository.save(user);
    }

    public EntityUsers updateUser(Long id, EntityUsers user) {
        // ใช้ Optional และ orElseThrow เพื่อดึง EntityUsers
        EntityUsers existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setRole(user.getRole());
        existing.setDepartment(user.getDepartment());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
