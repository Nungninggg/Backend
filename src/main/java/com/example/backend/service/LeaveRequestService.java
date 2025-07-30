package com.example.backend.service;

import com.example.backend.Dto.LeaveRequestInput;
import com.example.backend.entity.EntityLeaveRequests;
import com.example.backend.entity.EntityLeaveTypes;
import com.example.backend.entity.EntityUsers;
import com.example.backend.repository.LeaveRequestsRepository;
import com.example.backend.repository.LeaveTypeRepository;
import com.example.backend.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LeaveRequestService {

    @Autowired
    private LeaveRequestsRepository leaveRequestRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    public EntityLeaveRequests createLeaveRequest(LeaveRequestInput input) {
        EntityLeaveRequests entity = new EntityLeaveRequests();

        EntityUsers user = usersRepository.findById(input.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        EntityLeaveTypes leaveType = leaveTypeRepository.findById(input.getLeaveTypeId())
                .orElseThrow(() -> new RuntimeException("Leave type not found"));

        entity.setUser(user);
        entity.setLeaveType(leaveType);
        entity.setStartDate(input.getStartDate());
        entity.setEndDate(input.getEndDate());
        entity.setReason(input.getReason());
        entity.setStatus("pending");

        return leaveRequestRepository.save(entity);
    }

    public List<EntityLeaveRequests> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public EntityLeaveRequests updateLeaveRequestStatus(Long id, String status, String comment) {
        EntityLeaveRequests request = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));

        request.setStatus(status);
        request.setManagerComment(comment);
        return leaveRequestRepository.save(request);
    }

    public List<EntityLeaveRequests> getLeaveRequestsByUser(Long userId) {
        return leaveRequestRepository.findByUserId(userId);
    }
    public List<EntityLeaveRequests> getLeaveRequestsByMonthAndDept(String month, String department) {
        return leaveRequestRepository.findByMonthAndDepartment(month, department);
    }

}
