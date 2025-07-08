package Repository;
import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();

    public void store(Produto produto){
        var produtoSave = produtos.add(produto);
    }

    public void updateById(int id, String nome, Double preco, int quantidade){
        for(Produto p: produtos){
            if(p.getId() == id){
                System.out.println("O produto :" + p.toString());

                p.setNome(nome);
                p.setPreco(preco);
                p.setQuantidade(quantidade);
                System.out.println("Passou a ser: " + p.toString());

            }
        }
    }

    public void searchByName(String nome){
        for(Produto p: produtos){
            if(Objects.equals(p.getNome(), nome)){
                System.out.println(p.toString());
            }
        }
    }


    public void destroyById(int id) {
        for (Produto p: produtos){
            if(p.getId() == id){
                System.out.println("Excluindo o produto..." + p.toString() );
            }
        }
        produtos.removeIf(p -> p.getId() == id);
    }

    public List<Produto> index(){
        return produtos;
    }
}
