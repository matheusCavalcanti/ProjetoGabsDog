package projeto.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import projeto.modelo.Historico;

public class HistoricoDAO extends GenericDAO<Historico> {
    
    public HistoricoDAO() {
        super(Historico.class);
    }
    
    public List<Historico> findByAnimal(Integer Animal) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        TypedQuery<Historico> query = manager.createQuery(
				  "select c from Historico c "
				+ "where c.idAnimal = :pAnimal", Historico.class);
        
        query.setParameter("pAnimal", Animal);
        
        List<Historico> historicos = query.getResultList();
        
        manager.getTransaction().commit();
        manager.close();
        
        return historicos;
    }
    
}
