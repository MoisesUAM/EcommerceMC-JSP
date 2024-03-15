package net.mcoto.app.repositories;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

@Stateless
public class GenericRepositoryImpl<T, ID> implements IGenericRepository<T, ID> {

    @Inject
    private EntityManager em;
    private Class<T> entityClass;

    public GenericRepositoryImpl(Class<T> entityClass) {

        this.entityClass = entityClass;
    }

    public GenericRepositoryImpl() {
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(this.entityClass);
        Root<T> rootEntry = cq.from(this.entityClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allObjects = em.createQuery(all);
        return allObjects.getResultList();
    }

    @Override
    public List<T> findByFieldName(String fieldName, Object value) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(this.entityClass);
        Root<T> root = cq.from(this.entityClass);
        cq.select(root).where(cb.equal(root.get(fieldName), value));
        TypedQuery<T> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Optional<T> findById(ID id) {
        T result = em.find(entityClass, id);
        return Optional.ofNullable(result);

    }


    @Override
    public void save(T t) {
        em.persist(t);
    }

    @Override
    public void update(T t) {
        em.merge(t);
    }

    @Override
    public void delete(T t) {

        em.getTransaction().begin();
        try {
            em.remove(em.merge(t));
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

}
