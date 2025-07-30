package com.example.backend.repository;

import com.example.backend.entity.EntityLeaveTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveTypeRepository extends JpaRepository<EntityLeaveTypes, Long> {
}
