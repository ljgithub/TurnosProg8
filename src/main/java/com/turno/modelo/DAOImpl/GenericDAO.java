/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turno.modelo.DAOImpl;

import com.turno.modelo.DAO.IGenericDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Javier Morales 8A Programacion Avanzada
 */
public class GenericDAO <T> implements IGenericDAO<T>{
    
    private Class<T> entityClass;
    
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("turnoPU");
    EntityManager entityManager;

    public GenericDAO(){
        entityManager = emf.createEntityManager();
    }
    
    public GenericDAO (Class<T> entiityClass){
        this.entityClass = entiityClass;
        entityManager = emf.createEntityManager();
    }
    
    
    public T create(T t) {
        this.entityManager.persist(t);
        return t;
    }

    public T read(Object id) {
        return this.entityManager.find(entityClass, id);
    }

    public T update(T t) {
        return this.entityManager.merge(t);
    }

    
    public void delete(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }

    
    public void beginTransaction() {
        if(!entityManager.getTransaction().isActive())
            entityManager = emf.createEntityManager();
        
        entityManager.getTransaction().begin();
    }

    
    public void commit() {
        if(entityManager.getTransaction().isActive())
            entityManager.getTransaction().commit();
    }

    
    public void rollback() {
        if(entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
    }
    
     
    public void closeTransaction() {
        entityManager.close();
    }

    
    public void commitAndCloseTransaction() {
        commit();
        closeTransaction();
    }

    
    public void flush() {
        entityManager.flush();
    }

    
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return this.entityManager.createQuery(cq).getResultList();
    }
  
}
