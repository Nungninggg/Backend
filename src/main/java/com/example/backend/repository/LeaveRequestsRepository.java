package com.example.backend.repository;

import com.example.backend.entity.EntityLeaveRequests;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LeaveRequestsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EntityLeaveRequests> findAll() {
        return entityManager.createQuery("SELECT r FROM EntityLeaveRequests r", EntityLeaveRequests.class).getResultList();
    }

    public EntityLeaveRequests findById(Long id) {
        return entityManager.find(EntityLeaveRequests.class, id);
    }

    public EntityLeaveRequests save(EntityLeaveRequests request) {
        if (request.getId() == null) {
            entityManager.persist(request);
            return request;
        } else {
            return entityManager.merge(request);
        }
    }

    public void delete(Long id) {
        EntityLeaveRequests entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public List<EntityLeaveRequests> findByUserId(Long userId) {
        return entityManager.createQuery("SELECT r FROM EntityLeaveRequests r WHERE r.user.id = :userId", EntityLeaveRequests.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
