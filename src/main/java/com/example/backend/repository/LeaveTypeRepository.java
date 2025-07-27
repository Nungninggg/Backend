package com.example.backend.repository;

import com.example.backend.entity.EntityLeaveTypes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class LeaveTypeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EntityLeaveTypes> findAll() {
        return entityManager.createQuery("SELECT l FROM EntityLeaveTypes l", EntityLeaveTypes.class).getResultList();
    }

    public EntityLeaveTypes findById(Long id) {
        return entityManager.find(EntityLeaveTypes.class, id);
    }

    public EntityLeaveTypes save(EntityLeaveTypes leaveType) {
        if (leaveType.getId() == null) {
            entityManager.persist(leaveType);
            return leaveType;
        } else {
            return entityManager.merge(leaveType);
        }
    }

    public void deleteById(Long id) {
        EntityLeaveTypes existing = findById(id);
        if (existing != null) {
            entityManager.remove(existing);
        }
    }
}
