package Service;
import java.util.UUID;
import Model.Produto;
import Repository.ProdutoRepository;
public class ProdutoService {

    private int contadorId = 1;
    private ProdutoRepository repository;

    public ProdutoService() {
        this.repository = new ProdutoRepository();
    }

    public void createProduto(String nome, Double preco, int quantidade){

        Produto novoProduto = new Produto(contadorId++, nome, preco, quantidade);
        repository.store(novoProduto);
        System.out.println("Produto cadastrado com sucesso: " + novoProduto.toString());
    }

    public void listarProdutos(){
        for(Produto p: repository.index()){
            System.out.println(p);
        }
    }

    public void atualizarProdutoPorid(int id, String nome, Double preco, int quantidade){
        repository.updateById(id, nome, preco, quantidade);
        System.out.println("O produto cod :" + id + " foi atualizado com sucesso");
    }

    public void buscarProdutoPorNome(String nome){
        repository.searchByName(nome);
    }

    public void removerPorId(int id){
        repository.destroyById(id);
    }

}
