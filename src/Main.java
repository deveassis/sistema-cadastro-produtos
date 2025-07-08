import Model.Produto;
import Repository.ProdutoRepository;
import Service.ProdutoService;

public class Main {
    public static void main(String[] args) {
      ProdutoService service = new ProdutoService();

      // Cadastrar Produtos
        System.out.println("--------------------------");
        System.out.println("Cadastrando produtos");
      service.createProduto(1, "Chocolate", 12.50, 4);
      service.createProduto(2, "Doritos", 12.50, 2);
      service.createProduto(3, "Ruffles", 11.50, 1);
        System.out.println("--------------------------");
        System.out.println("Atualizando produto por ID");

      // Atualizar produto pelo id
      service.atualizarProdutoPorid(2, "Lays", 10.89, 1);
        System.out.println("--------------------------");

        System.out.println("Removendo produto por id");

        //Remover pelo id
      service.removerPorId(1);

        System.out.println("--------------------------");
        System.out.println("Listando produtos");

      //Listar Produto
      service.listarProdutos();

        System.out.println("--------------------------");
        System.out.println("Buscando produto por nome");

      //Buscar produto pelo nome
      service.buscarProdutoPorNome("Doritos");

    }
}