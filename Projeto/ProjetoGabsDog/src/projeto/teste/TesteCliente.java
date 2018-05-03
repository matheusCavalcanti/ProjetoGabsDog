package projeto.teste;

import java.util.Calendar;
import javax.persistence.EntityManager;
import projeto.modelo.Animal;
import projeto.modelo.Cliente;
import projeto.modelo.TipoSexo;

import projeto.util.JPAUtil;

/**
 *
 * @author Matheus
 */

public class TesteCliente {
    
    public static void main(String[] args){
        
        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setEndereco("Rua S numero 44");
        cliente.setCpf("400.177.633-80");
        cliente.setTelefone("3323-2017");
        cliente.setCelular("(18) 99775-2020");
        cliente.setEmail("joao@hotmail.com");
        cliente.setCep("19814-400");
        cliente.setCidade("Assis");
        cliente.setUf("SP");
        
        Animal animal = new Animal();
        animal.setNome("Bob");
        animal.setEspecie("Canina");
        animal.setRaca("Vira-Lata");
        animal.setPeso(12.5f);
        animal.setCor("Branco");
        animal.setSexo(TipoSexo.M);
        animal.setCastrado(true);
        animal.setNascimento(Calendar.getInstance());
        animal.setCliente(cliente);
        
        EntityManager em = new JPAUtil().getEntityManager();
                
        em.getTransaction().begin();
        
        
        em.persist(cliente);
        em.persist(animal);
        em.getTransaction().commit();
        
        em.close();
    }
        
}
