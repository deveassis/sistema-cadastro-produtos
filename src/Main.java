import Model.Produto;
import Repository.ProdutoRepository;
import Service.ProdutoService;

import java.lang.classfile.instruction.SwitchCase;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      ProdutoService service = new ProdutoService();


      System.out.println("--------------------------");
      System.out.println("Escolha uma das opções abaixo: ");
      Scanner optionsTerm = new Scanner(System.in);
        System.out.println("1 - Cadastrar Produto ");
        System.out.println("2 - Listar Produtos ");
        System.out.println("3 - Atualizar  Produto");
        System.out.println("4 - Pesquisar produto por nome");
        int optionInsert = optionsTerm.nextInt();
        switch(optionInsert){
          case  1:
              System.out.println("Vamos cadastrar um novo produto!");
                Scanner myProduct = new Scanner(System.in);
                 myProduct.useLocale(Locale.US); // <- aceita ponto decimal como 12.30
              System.out.println("Informe o nome do produto: ");
                 String name = myProduct.nextLine();
              System.out.println("Informe o preco do produto: ");
                  double preco = myProduct.nextDouble();
              System.out.println("Informe a quantidade de itens: ");
                 int quantidade = myProduct.nextInt();
                 service.createProduto(name, preco, quantidade);
              break;
          case 2:
              System.out.println("Estamos carregando a lista de produtos...");
              service.listarProdutos();

            case 3:
                System.out.println("Informe abaixo o id do produto que voce deseja atualizar o preco: ");
                Scanner updateProduct = new Scanner(System.in);
                int  searchId = updateProduct.nextInt();
                System.out.println("Ok, agora informe o novo nome do produto: ");
                String nameProduct = updateProduct.nextLine();
                System.out.println("Ok, agora informe o novo preco: ");
                Double priceProduct = updateProduct.nextDouble();
                System.out.println("Ok, agora informe a quantidade: ");
                int quantityProduct = updateProduct.nextInt();


        }


    }
}