package com.example.backend.controller;

import com.example.backend.entity.EntityLeaveRequests;
import com.example.backend.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave_requests")
public class LeaveRequestsController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping
    public EntityLeaveRequests createRequest(@RequestBody EntityLeaveRequests request) {
        return leaveRequestService.createLeaveRequest(request);
    }


    @GetMapping
    public List<EntityLeaveRequests> getAllRequests() {
        return leaveRequestService.getAllLeaveRequests();
    }

    @PutMapping("/{id}")
    public EntityLeaveRequests updateStatus(
            @PathVariable Long id,
            @RequestParam String status,
            @RequestParam(required = false) String comment
    ) {
        return leaveRequestService.updateLeaveRequestStatus(id, status, comment);
    }


    @GetMapping("/user/{userId}")
    public List<EntityLeaveRequests> getByUser(@PathVariable Long userId) {
        return leaveRequestService.getLeaveRequestsByUser(userId);
    }
}
