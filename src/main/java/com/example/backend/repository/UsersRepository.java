package com.example.backend.repository;

import com.example.backend.entity.EntityUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<EntityUsers, Long> {
}
