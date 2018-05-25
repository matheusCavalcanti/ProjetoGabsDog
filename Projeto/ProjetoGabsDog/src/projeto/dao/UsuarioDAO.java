package projeto.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import projeto.modelo.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario>{
    
    public UsuarioDAO() {
        super(Usuario.class);
    }
    
    public List<Usuario> findNome(String Nome) {
        String jpql = "from Usuario u where u.nome like ?";
        
        return find(jpql, Nome);
    }
    
    public Usuario findUsuario(String Nome) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        Query query = manager.createQuery("from Usuario u where u.nome = :pNome");
        query.setParameter("pNome", Nome);
        
        Object usuario = query.getSingleResult();
        
        manager.getTransaction().commit();
        manager.close();
        
        return (Usuario) usuario;
    }
    
}
