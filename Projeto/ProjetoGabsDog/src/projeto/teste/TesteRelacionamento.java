package projeto.teste;

import java.util.Calendar;
import javax.persistence.EntityManager;
import projeto.modelo.Animal;
import projeto.modelo.Cliente;
import projeto.modelo.TipoSexo;
import projeto.util.JPAUtil;

public class TesteRelacionamento {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        cliente.setNome("Danilo");
        cliente.setEndereco("Rua SS numero 1544");
        cliente.setCpf("120.777.548-55");
        cliente.setTelefone("3323-1212");
        cliente.setCelular("(18) 99775-3322");
        cliente.setEmail("danilo@hotmail.com");
        cliente.setCep("19814-300");
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
