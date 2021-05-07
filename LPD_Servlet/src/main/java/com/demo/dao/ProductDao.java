package com.demo.dao;

import com.demo.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public List<ProductEntity> getAll() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<ProductEntity> list = em.createQuery("select p from ProductEntity p", ProductEntity.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

}
