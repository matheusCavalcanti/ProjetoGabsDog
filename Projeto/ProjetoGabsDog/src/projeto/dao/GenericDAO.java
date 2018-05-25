package projeto.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import projeto.util.JPAUtil;

public abstract class GenericDAO<T extends Serializable> {
    
    private Class<T> aClass;
    
    protected GenericDAO(Class<T> aClass) {
        this.aClass = aClass;
    }
    
    protected EntityManager getEntityManager() {
        return JPAUtil.getInstance().getEntityManager();
    }
    
    public T findOne(String jpql, Object... params){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        Query query = manager.createQuery(jpql);
        
        for (int i=0; i < params.length; i++){
            query.setParameter(i+1, params[i]);
        }
        
        T entity = (T)query.getSingleResult();
        
        manager.getTransaction().commit();
        manager.close();
        
        return entity;
    }
    
    public List<T> find(String jpql, Object... params){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        Query query = manager.createQuery(jpql);
        
        for (int i=0; i < params.length; i++){
            query.setParameter(i, params[i]);
        }
        
        List<T> entities = query.getResultList();
        
        manager.getTransaction().commit();
        manager.close();
        
        return entities;
    }
    
    public List<T> findAll() {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        Query query = manager.createQuery("from " + aClass.getSimpleName());
        
        List<T> entities = query.getResultList();
        
        manager.getTransaction().commit();
        manager.close();
        
        return entities;
    }
    
    public T findById(Integer id){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        T entity = (T) manager.find(aClass, id);
        
        manager.getTransaction().commit();
        manager.close();
        
        return entity;
    }
    
    public void save(T entity){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void uptade(T entity){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void delete(Integer id){
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.remove(manager.getReference(aClass, id));
        manager.getTransaction().commit();
        manager.close();
    }
    
    
}
