package projeto.teste;

import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import projeto.dao.AnimalDAO;
import projeto.dao.ClienteDAO;
import projeto.dao.EspecieDAO;
import projeto.dao.RacaDAO;
import projeto.dao.TipoProcedDAO;
import projeto.dao.TipoUsuarioDAO;
import projeto.modelo.Animal;
import projeto.modelo.Cliente;
import projeto.modelo.Especie;
import projeto.modelo.Raca;
import projeto.modelo.TipoProced;
import projeto.modelo.TipoSexo;
import projeto.modelo.TipoUsuario;

public class ClasseMain {

    public static void main(String[] args) {
       
        TipoProced tipo = new TipoProced();
        tipo.setDescricao("Atendimento");
        
        TipoProcedDAO tipoProcedDAO = new TipoProcedDAO();
        tipoProcedDAO.save(tipo);
                
        //findEspecie();
        
        /*Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setEndereco("Rua S numero 44");
        cliente.setCpf("400.177.633-80");
        cliente.setTelefone("3323-2017");
        cliente.setCelular("(18) 99775-2020");
        cliente.setEmail("joao@hotmail.com");
        cliente.setCep("19814-400");
        cliente.setCidade("Assis");
        cliente.setUf("SP");
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.save(cliente);
        
        Especie especie = new Especie();
        especie.setDescricao("Canina");
        EspecieDAO especieDAO = new EspecieDAO();
        especieDAO.save(especie);
        
        Raca raca = new Raca();
        raca.setDescricao("Pug");
        raca.setEspecie(especie);
        RacaDAO racaDAO = new RacaDAO();
        racaDAO.save(raca);
                
        Animal animal = new Animal();
        animal.setNome("Bob");
        animal.setEspecie(especie);
        animal.setRaca(raca);
        animal.setPeso(12.5f);
        animal.setCor("Branco");
        animal.setSexo(TipoSexo.M);
        animal.setCastrado(true);
        animal.setNascimento(Calendar.getInstance());
        animal.setCliente(cliente);
        AnimalDAO animalDAO = new AnimalDAO();
        animalDAO.save(animal);*/
        
        
        
    }
    
   private static void findEspecie(){
            Especie especie = new Especie();
            especie.setId(1);
            List<Raca> racas = new RacaDAO().findEspecie(especie);
            
            for (Raca r : racas) {
                System.out.println(r.getDescricao());
            }
        }
}
