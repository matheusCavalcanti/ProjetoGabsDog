package projeto.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import projeto.modelo.Animal;

public class AnimalDAO extends GenericDAO<Animal> {

    public AnimalDAO() {
        super(Animal.class);
    }

    public List<Animal> findNome(String Nome) {
        String jpql = "from Animal a where a.nome like ?";
        
        return find(jpql, Nome);
    }
    
    public List<Animal> findCli(Object Cliente) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        TypedQuery<Animal> query = manager.createQuery(
				  "select a from Animal a "
				+ "where a.cliente = :pCliente", Animal.class);
        
        query.setParameter("pCliente", Cliente);
        
        List<Animal> animais = query.getResultList();
        
        manager.getTransaction().commit();
        manager.close();
        
        return animais;
    }
    
    public Animal findAni(String Nome) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        Query query = manager.createQuery("from Animal a where a.nome = :pNome");
        query.setParameter("pNome", Nome);
        
        Object animal = query.getSingleResult();
        
        manager.getTransaction().commit();
        manager.close();
        
        return (Animal) animal;
    }
    
}
