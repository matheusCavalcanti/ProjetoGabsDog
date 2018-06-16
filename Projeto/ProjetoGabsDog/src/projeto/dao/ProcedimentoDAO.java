package projeto.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import projeto.modelo.Procedimento;

public class ProcedimentoDAO extends GenericDAO<Procedimento>{
    
    public ProcedimentoDAO() {
        super(Procedimento.class);
    }
    
    public List<Procedimento> findNome(String Nome, Object Tipo) {
        
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        TypedQuery<Procedimento> query = manager.createQuery(
				  "select p from Procedimento p "
				+ "where p.descricao like :pNome and p.tipo = :pTipo", Procedimento.class);
        
        query.setParameter("pNome", Nome);
        query.setParameter("pTipo", Tipo);
        
        List<Procedimento> proceds = query.getResultList();
        
        manager.getTransaction().commit();
        manager.close();
        
        return proceds;
    }
    
    //buscar procedimentos por tipo
    public List<Procedimento> findProc(Object Tipo) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        TypedQuery<Procedimento> query = manager.createQuery(
				  "select p from Procedimento p "
				+ "where p.tipo = :pTipo", Procedimento.class);
        
        query.setParameter("pTipo", Tipo);
        
        List<Procedimento> proceds = query.getResultList();
        
        manager.getTransaction().commit();
        manager.close();
        
        return proceds;
    }
    
}
