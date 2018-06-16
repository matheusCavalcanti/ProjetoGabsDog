package projeto.servicos;

public class Estoque {
    
    public Estoque() {
        
    }
    
    public int abaterEstoque(int Quantidade, int Numero) {
        Quantidade = Quantidade - Numero;
        
        return Quantidade;
    }
    
}
