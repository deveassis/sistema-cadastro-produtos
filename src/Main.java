import Model.Produto;
import Repository.ProdutoRepository;
import Service.ProdutoService;

public class Main {
    public static void main(String[] args) {
      ProdutoService service = new ProdutoService();
      service.createProduto(1, "Chocolate", 12.50, 4);
      service.listarProdutos();
      service.atualizarProdutoId(1);
    }
}