package projeto.teste;

import javax.persistence.EntityManager;
import projeto.modelo.Animal;
import projeto.modelo.Cliente;
import projeto.util.JPAUtil;

public class TesteBuscaConta {
    
    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        Cliente cliente = em.find(Cliente.class, 4);
        Animal animal = em.find(Animal.class, 2);
        
        em.remove(cliente);
        em.remove(animal);
       
        em.getTransaction().commit();
        em.close();
        
    }
}
