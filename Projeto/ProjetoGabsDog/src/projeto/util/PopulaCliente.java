package projeto.util;

import javax.persistence.EntityManager;
import projeto.modelo.Cliente;

public class PopulaCliente {
    
    public static void main (String[] args){
    
        EntityManager manager = new JPAUtil().getEntityManager();
        
        manager.getTransaction().begin();
        
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();
        Cliente cliente4 = new Cliente();
        
        cliente1.setNome("João");
        cliente1.setEndereco("Rua B numero 555");
        cliente1.setCpf("111.222.554-10");
        cliente1.setTelefone("3323-4554");
        cliente1.setCelular("(18) 99442-7710");
        cliente1.setEmail("joao@hotmail.com");
        cliente1.setCep("19800-300");
        cliente1.setCidade("Assis");
        cliente1.setUf("SP"); 
        
        cliente2.setNome("Renato");
        cliente2.setEndereco("Rua Olá numero 555");
        cliente2.setCpf("555.111.777-10");
        cliente2.setTelefone("3323-8800");
        cliente2.setCelular("(18) 99774-0010");
        cliente2.setEmail("renato@hotmail.com");
        cliente2.setCep("19800-405");
        cliente2.setCidade("Candido Mota");
        cliente2.setUf("SP"); 
        
        cliente3.setNome("Lucas");
        cliente3.setEndereco("Rua Bola 8 numero 2");
        cliente3.setCpf("655.748.120-10");
        cliente3.setTelefone("3323-9877");
        cliente3.setCelular("(18) 99004-4550");
        cliente3.setEmail("lucas@hotmail.com");
        cliente3.setCep("19800-760");
        cliente3.setCidade("Paraguaçu");
        cliente3.setUf("SP"); 
       
        cliente4.setNome("Carlos");
        cliente4.setEndereco("Rua Boa noite numero 45");
        cliente4.setCpf("123.654.888-20");
        cliente4.setTelefone("3323-2017");
        cliente4.setCelular("(18) 99555-2018");
        cliente4.setEmail("carlos@hotmail.com");
        cliente4.setCep("19800-300");
        cliente4.setCidade("Assis");
        cliente4.setUf("SP"); 
        
        manager.persist(cliente1);
        manager.persist(cliente2);
        manager.persist(cliente3);
        manager.persist(cliente4);
        
        
        manager.getTransaction().commit();
        
        manager.close();
    }
    
}
