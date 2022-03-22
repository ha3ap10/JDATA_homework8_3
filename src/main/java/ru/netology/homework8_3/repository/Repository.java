package ru.netology.homework8_3.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    public Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<String> getProductName(String name) {
        return entityManager.createQuery("select productName " +
                "from orders " +
                "where lower(customer.name) = lower(:nameCustomer)", String.class)
                .setParameter("nameCustomer", name)
                .getResultList();
    }
}
