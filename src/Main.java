import Model.Produto;
import Repository.ProdutoRepository;
import Service.ProdutoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      ProdutoService service = new ProdutoService();
      // Cadastrar Produtos
        System.out.println("--------------------------");
        System.out.println("Cadastrando produtos");

      Scanner myProduct = new Scanner(System.in);
      myProduct.useLocale(Locale.US); // <- aceita ponto decimal como 12.30


      ArrayList<String> listaOpcoes = new ArrayList<String>();

      System.out.println("Nome: ");
      String name = myProduct.nextLine();

      System.out.println("Preço: ");
      double preco = myProduct.nextDouble();

      System.out.println("Quantidade: ");
      int quantidade = myProduct.nextInt();

      service.createProduto(name, preco, quantidade);


    }
}