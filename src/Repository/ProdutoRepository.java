package Repository;
import Model.Produto;
import java.util.ArrayList;
import java.util.List;
public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();

    public void store(Produto produto){
        var produtoSave = produtos.add(produto);
    }

    public void findById(int id){
        for(Produto p: produtos){
            if(p.getId() == id){
                return;
            }
        }
    }

    public List<Produto> index(){
        return produtos;
    }
}
