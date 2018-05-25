package projeto.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import projeto.modelo.Raca;

public class RacaDAO extends GenericDAO<Raca>{
    
    public RacaDAO() {
        super(Raca.class);
    }
    
    public List<Raca> findEspecie(Object especie) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        
        TypedQuery<Raca> query = manager.createQuery(
				  "select r from Raca r "
				+ "where r.especie = :pEspecie", Raca.class);
        
        query.setParameter("pEspecie", especie);
        
        List<Raca> racas = query.getResultList();
        
        manager.getTransaction().commit();
        manager.close();
        
        return racas;
       
    }
}
