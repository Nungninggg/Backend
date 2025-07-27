package com.example.backend.controller;

import com.example.backend.entity.EntityLeaveBalance;
import com.example.backend.service.LeaveBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave_balances")
public class LeaveBalanceController {

    @Autowired
    private LeaveBalanceService leaveBalanceService;

    // GET ทั้งหมด
    @GetMapping
    public List<EntityLeaveBalance> getAll() {
        return leaveBalanceService.getAllBalances();
    }

    // GET ตาม userId
    @GetMapping("/user/{userId}")
    public List<EntityLeaveBalance> getByUserId(@PathVariable Long userId) {
        return leaveBalanceService.getLeaveBalanceByUserId(userId);
    }

    // GET ตาม id
    @GetMapping("/{id}")
    public EntityLeaveBalance getById(@PathVariable Long id) {
        return leaveBalanceService.getById(id);
    }

    // POST สร้าง balance
    @PostMapping
    public EntityLeaveBalance create(@RequestBody EntityLeaveBalance balance) {
        return leaveBalanceService.save(balance);
    }

    // PUT แก้ไข balance
    @PutMapping("/{id}")
    public EntityLeaveBalance update(@PathVariable Long id, @RequestBody EntityLeaveBalance updatedBalance) {
        EntityLeaveBalance existing = leaveBalanceService.getById(id);
        if (existing == null) {
            throw new RuntimeException("LeaveBalance not found");
        }
        existing.setUser(updatedBalance.getUser());
        existing.setLeaveType(updatedBalance.getLeaveType());
        existing.setYear(updatedBalance.getYear());
        existing.setRemainingDays(updatedBalance.getRemainingDays());
        return leaveBalanceService.save(existing);
    }

    // DELETE ลบ balance
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        leaveBalanceService.delete(id);
    }
}
