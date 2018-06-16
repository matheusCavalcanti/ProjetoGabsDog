package projeto.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import projeto.modelo.Atendimento;

public class AtendimentoDAO extends GenericDAO<Atendimento> {
    
    public AtendimentoDAO() {
        super(Atendimento.class);
    }
    
    public List<Atendimento> findAtend(Object Animal) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        TypedQuery<Atendimento> query = manager.createQuery(
				  "select a from Atendimento a "
				+ "where a.animal = :pAnimal", Atendimento.class);
        
        query.setParameter("pAnimal", Animal);
        
        List<Atendimento> atends = query.getResultList();
        
        manager.getTransaction().commit();
        manager.close();
        
        return atends;
    }
    
}
