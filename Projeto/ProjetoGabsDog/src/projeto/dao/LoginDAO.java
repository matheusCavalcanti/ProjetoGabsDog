package projeto.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import projeto.modelo.Usuario;
import projeto.util.JPAUtil;

public class LoginDAO {

    public boolean logar(Usuario usuario){
        
                JPAUtil jpa = new JPAUtil();
		TypedQuery<Usuario> query = jpa.getEntityManager().createQuery(
				  "select n from Usuario n "
				+ "where n.nome = :pNome and n.senha = :pSenha", Usuario.class);
		
		query.setParameter("pNome", usuario.getNome());
		query.setParameter("pSenha", usuario.getSenha());
		try {
			Usuario resultado =  query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}
		
		jpa.getEntityManager().close();
                
		
		return true;
    }
        
}    

