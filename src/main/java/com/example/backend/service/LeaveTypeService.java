package com.example.backend.service;

import com.example.backend.entity.EntityLeaveTypes;
import com.example.backend.repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveTypeService {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    public List<EntityLeaveTypes> getAllLeaveTypes() {
        return leaveTypeRepository.findAll();
    }

    public EntityLeaveTypes getLeaveTypeById(Long id) {
        return leaveTypeRepository.findById(id);
    }

    public EntityLeaveTypes createOrUpdateLeaveType(EntityLeaveTypes leaveType) {
        return leaveTypeRepository.save(leaveType);
    }

    public void deleteLeaveType(Long id) {
        leaveTypeRepository.deleteById(id);
    }
}