package com.example.autoitog.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DAOService<T extends Identifiable> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<T> getAll(Class<T> type) {
        return entityManager.createQuery("SELECT t FROM " + type.getName() + " t", type)
                .getResultList();
    }

    public T get(int id, Class<T> type) {
        return entityManager.find(type, id);
    }

    public T create(T obj) {
        entityManager.persist(obj);
        return obj;
    }

    public T update(int id, T newObj, Class<T> type) {
        T existingObj = entityManager.find(type, id);
        if (existingObj != null) {
            newObj.setId(id);
            return entityManager.merge(newObj);
        }
        return null;
    }

    public void delete(int id, Class<T> type) {
        T obj = entityManager.find(type, id);
        if (obj != null) {
            entityManager.remove(obj);
        }
    }

    public List<T> searchBy(String name, Class<T> type, String str) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.where(builder.like(root.get(str), "%" + name + "%"));

        return entityManager.createQuery(query).getResultList();
    }
}
