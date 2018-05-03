package projeto.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    
    private EntityManagerFactory emf;
    private static JPAUtil instance;

    public JPAUtil(){
        this.emf = Persistence.createEntityManagerFactory("ProjetoGabsDogPU");
    }
    
    public static synchronized JPAUtil getInstance() {
        if (instance == null) {
            instance = new JPAUtil();
        }
        return instance;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
}
