package com.example.backend.service;

import com.example.backend.entity.EntityLeaveBalance;
import com.example.backend.repository.LeaveBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class LeaveBalanceService {

    @Autowired
    private LeaveBalanceRepository leaveBalanceRepository;

    // ดึงข้อมูลวันลาคงเหลือทั้งหมด
    public List<EntityLeaveBalance> getAllBalances() {
        return leaveBalanceRepository.findAll();
    }

    // ดึงข้อมูลวันลาคงเหลือตาม userId
    public List<EntityLeaveBalance> getLeaveBalanceByUserId(Long userId) {
        return leaveBalanceRepository.findByUserId(userId);
    }

    // เพิ่มหรืออัปเดต leave balance
    public EntityLeaveBalance save(EntityLeaveBalance balance) {
        return leaveBalanceRepository.save(balance);
    }

    // ลบ leave balance
    public void delete(Long id) {
        leaveBalanceRepository.delete(id);
    }

    // ดึง balance ตาม id
    public EntityLeaveBalance getById(Long id) {
        return leaveBalanceRepository.findById(id);
    }
}
