package projeto.teste;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import projeto.modelo.Animal;
import projeto.modelo.Cliente;
import projeto.util.JPAUtil;

public class TesteJPQL {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();                
        em.getTransaction().begin();
        
        Cliente cliente = new Cliente();
        cliente.setId(3);
        
        String jpql = "select a from Animal a where a.cliente = :pCliente ";
        Query query = em.createQuery(jpql);
        query.setParameter("pCliente", cliente);
        
        
        List<Animal> resultados = query.getResultList();
        
        for (Animal animal : resultados) {
            System.out.println("Nome:" + animal.getNome());
            System.out.println("Cor:" + animal.getCor());
        }
        
        em.getTransaction().commit();        
        em.close();
        
        
        
    }

    
}
