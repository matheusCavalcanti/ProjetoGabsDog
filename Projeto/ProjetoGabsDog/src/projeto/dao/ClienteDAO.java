package projeto.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import projeto.modelo.Animal;
import projeto.modelo.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {
    
    public ClienteDAO() {
        super(Cliente.class);
    }
    
    public List<Cliente> findNome(String Nome) {
        String jpql = "from Cliente c where c.nome like ?";
        
        return find(jpql, Nome);
    }
    
    public Cliente findCli(String Nome) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        Query query = manager.createQuery("from Cliente c where c.nome = :pNome");
        query.setParameter("pNome", Nome);
        
        Object cliente = query.getSingleResult();
        
        manager.getTransaction().commit();
        manager.close();
        
        return (Cliente) cliente;
    }
    
}
