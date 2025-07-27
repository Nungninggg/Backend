package com.example.backend.service;

import com.example.backend.entity.EntityLeaveRequests;
import com.example.backend.repository.LeaveRequestsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Transactional
public class LeaveRequestService {

    @Autowired
    private LeaveRequestsRepository leaveRequestRepository;

    public EntityLeaveRequests createLeaveRequest(EntityLeaveRequests request) {
        request.setStatus("Pending");  // default status
        return leaveRequestRepository.save(request);
    }

    public List<EntityLeaveRequests> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public EntityLeaveRequests updateLeaveRequestStatus(Long id, String status, String comment) {
        EntityLeaveRequests request = leaveRequestRepository.findById(id);
        if (request == null) {
            throw new RuntimeException("Leave request not found");
        }
        request.setStatus(status);
        request.setManagerComment(comment);
        return leaveRequestRepository.save(request);
    }

    public List<EntityLeaveRequests> getLeaveRequestsByUser(Long userId) {
        return leaveRequestRepository.findByUserId(userId);
    }
}
