package projeto.teste;

import projeto.dao.LoginDAO;
import projeto.modelo.Usuario;

public class ClasseMain {

    public static void main(String[] args) {
        
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("admin");
        usuario.setSenha("admin");
        
        LoginDAO loginDAO = new LoginDAO();
        boolean existe = loginDAO.logar(usuario);
        
        if (existe == true){
            System.out.println("Usuario autenticado!");
        }
    }

    
}
