package Service;

import Model.Produto;
import Repository.ProdutoRepository;
public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService() {
        this.repository = new ProdutoRepository();
    }

    public void createProduto(int id, String nome, Double preco, int quantidade){
        Produto novoProduto = new Produto(id, nome, preco, quantidade);
        repository.store(novoProduto);
        System.out.println("Produto cadastrado com sucesso");
    }

    public void listarProdutos(){
        for(Produto p: repository.index()){
            System.out.println(p);
        }
    }

    public void atualizarProdutoId(int id){
        repository.findById(id);
        System.out.println("passei aqui");
    }

}
