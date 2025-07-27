package com.example.backend.controller;

import com.example.backend.entity.EntityLeaveTypes;
import com.example.backend.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave_types")
public class LeaveTypeController {

    @Autowired
    private LeaveTypeService leaveTypeService;

    @GetMapping
    public List<EntityLeaveTypes> getAll() {
        return leaveTypeService.getAllLeaveTypes();
    }

    @GetMapping("/{id}")
    public EntityLeaveTypes getById(@PathVariable Long id) {
        return leaveTypeService.getLeaveTypeById(id);
    }

    @PostMapping
    public EntityLeaveTypes create(@RequestBody EntityLeaveTypes leaveType) {
        return leaveTypeService.createOrUpdateLeaveType(leaveType);
    }

    @PutMapping("/{id}")
    public EntityLeaveTypes update(@PathVariable Long id, @RequestBody EntityLeaveTypes updated) {
        updated.setId(id);
        return leaveTypeService.createOrUpdateLeaveType(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        leaveTypeService.deleteLeaveType(id);
    }
}
