package Service;
import java.sql.SQLException;
import java.util.*;

import Model.Produto;
import Repository.ProdutoRepository;
public class ProdutoService {

    private int contadorId = 1;
    private ProdutoRepository repository;

    public ProdutoService() {
        this.repository = new ProdutoRepository();
    }

    public void showMenu(){
        List<String> menu = new ArrayList<>();
        menu.add("1- Cadastrar Produto");
        menu.add("2- Exibir produtos cadastrados");
        menu.add("3- Atualizar Produto");
        menu.add("4- Pesquisar produto por nome");
        System.out.println("Digite o numero de uma das opcoes abaixo");
        for(int i = 0; i < menu.size(); i++){
            System.out.println(menu.get(i));
        }
    }

    public void createProduto() throws SQLException {
        System.out.println("=========================================");
        System.out.println("Vamos cadastrar um novo produto!");
        Scanner myProduct = new Scanner(System.in);
        myProduct.useLocale(Locale.US);
        System.out.println("Informe o nome do produto: ");
        String name = myProduct.nextLine();
        System.out.println("Informe o preco do produto: ");
        double preco = myProduct.nextDouble();
        System.out.println("Informe a quantidade de itens: ");
        int quantidade = myProduct.nextInt();
        repository.store(name, preco, quantidade);
        System.out.println("Produto cadastrado com sucesso: ");
    }

    public void listarProdutos(){
        System.out.println("=========================================");
        System.out.println("Verificando lista de produtos...");
        if(!repository.index().isEmpty()){
            for(Produto p: repository.index()){
                System.out.println(p);
            }
        }

    }

    public void atualizarProdutoPorid(){
        System.out.println("=========================================");
        System.out.println("Informe abaixo o nome do produto que voce deseja atualizar: ");
        Scanner updateProduct = new Scanner(System.in);
        String  searcheName = updateProduct.nextLine();
        System.out.println("Ok, agora informe o novo nome do produto: ");
        String nameProduct = updateProduct.nextLine();
        System.out.println("Ok, agora informe o novo preco: ");
        Double priceProduct = updateProduct.nextDouble();
        System.out.println("Ok, agora informe a quantidade: ");
        int quantityProduct = updateProduct.nextInt();
        repository.updateById(searcheName);
    }

    public void buscarProdutoPorNome(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("Informe abaixo o nome do produto que voce deseja consultar estoque: ");
        String name = scanner.nextLine();
        if(!name.isEmpty()){
            repository.searchByName(name);
        }else{
            System.out.println("Voce nao informou o nome do produto, tente novamente");
        }
    }

    public void removerPorId(int id){
        repository.destroyById(id);
    }

}
