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
    public void insertProduct(ProductEntity productEntity) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(productEntity);
        em.getTransaction().commit();
        em.close();
    }
    public void updateProduct(ProductEntity productEntity) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        ProductEntity c = em.find(ProductEntity.class, productEntity.getId());
        if (c != null) {
            c.setName(productEntity.getName());
            c.setImage(productEntity.getImage());
            c.setPrice(productEntity.getPrice());
            em.getTransaction().commit();
        }
        em.close();
    }

    public void deleteProduct(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        ProductEntity c = em.find(ProductEntity.class, id);
        if (c != null) {
            em.remove(c);
            em.getTransaction().commit();
        }
        em.close();
    }

}
