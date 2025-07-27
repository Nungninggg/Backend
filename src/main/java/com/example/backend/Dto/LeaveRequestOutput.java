// LeaveRequestOutput.java (ส่งข้อมูลกลับ)
package com.example.backend.Dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class LeaveRequestOutput {
    private Long id;
    private String userName;
    private String leaveTypeName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String reason;
    private String managerComment;
}
