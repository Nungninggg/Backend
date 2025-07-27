package com.example.backend.repository;

import com.example.backend.entity.EntityUsers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EntityUsers> findAll() {
        return entityManager.createQuery("SELECT u FROM EntityUsers u", EntityUsers.class).getResultList();
    }

    public EntityUsers findById(Long id) {
        return entityManager.find(EntityUsers.class, id);
    }

    public EntityUsers save(EntityUsers user) {
        if (user.getId() == null) {
            entityManager.persist(user); // new object
            return user;
        } else {
            return entityManager.merge(user); // update
        }
    }

    public void deleteById(Long id) {
        EntityUsers user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
