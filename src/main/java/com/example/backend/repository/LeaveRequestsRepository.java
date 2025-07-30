package com.example.backend.repository;

import com.example.backend.entity.EntityLeaveRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestsRepository extends JpaRepository<EntityLeaveRequests, Long> {
    List<EntityLeaveRequests> findByUserId(Long userId);

    @Query("SELECT r FROM EntityLeaveRequests r WHERE FUNCTION('MONTH', r.startDate) = ?1 AND r.user.department = ?2")
    List<EntityLeaveRequests> findByMonthAndDepartment(String month, String department);
}

