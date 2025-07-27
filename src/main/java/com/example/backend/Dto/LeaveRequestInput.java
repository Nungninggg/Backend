// LeaveRequestInput.java (รับข้อมูลสร้างคำขอลา)
package com.example.backend.Dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class LeaveRequestInput {
    private Long userId;
    private Long leaveTypeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
}
