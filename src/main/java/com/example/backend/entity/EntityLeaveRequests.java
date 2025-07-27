package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "leave_requests_")
public class EntityLeaveRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private EntityUsers user;

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    private EntityLeaveTypes leaveType;

    private LocalDate startDate;
    private LocalDate endDate;
    private String status;         // pending, approved, rejected
    private String reason;         // เหตุผลการลา
    private String managerComment; // ความเห็นผู้จัดการ
}