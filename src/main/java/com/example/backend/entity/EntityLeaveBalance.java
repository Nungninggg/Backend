package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "leave_balances")
public class EntityLeaveBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private EntityUsers user;

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    private EntityLeaveTypes leaveType;

    private Integer year;
    private Integer remainingDays;

    // getters, setters
}

