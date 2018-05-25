package projeto.dao;

import java.util.List;
import projeto.modelo.Fornecedor;

public class FornecedorDAO extends GenericDAO<Fornecedor>{
    
    public FornecedorDAO() {
        super(Fornecedor.class);
    }
    
    public List<Fornecedor> findNome(String Nome) {
        String jpql = "from Fornecedor f where f.nome like ?";
        
        return find(jpql, Nome);
    }
    
}
