package com.example.backend.repository;

import com.example.backend.entity.EntityLeaveBalance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LeaveBalanceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EntityLeaveBalance> findByUserId(Long userId) {
        String jpql = "SELECT b FROM EntityLeaveBalance b WHERE b.user.id = :userId";
        TypedQuery<EntityLeaveBalance> query = entityManager.createQuery(jpql, EntityLeaveBalance.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public EntityLeaveBalance findById(Long id) {
        return entityManager.find(EntityLeaveBalance.class, id);
    }

    public EntityLeaveBalance save(EntityLeaveBalance balance) {
        if (balance.getId() == null) {
            entityManager.persist(balance);
            return balance;
        } else {
            return entityManager.merge(balance);
        }
    }

    public void delete(Long id) {
        EntityLeaveBalance balance = entityManager.find(EntityLeaveBalance.class, id);
        if (balance != null) {
            entityManager.remove(balance);
        }
    }

    public List<EntityLeaveBalance> findAll() {
        String jpql = "SELECT b FROM EntityLeaveBalance b";
        return entityManager.createQuery(jpql, EntityLeaveBalance.class).getResultList();
    }
}
