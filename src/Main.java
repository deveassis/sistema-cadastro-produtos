import Service.ProdutoService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      ProdutoService service = new ProdutoService();
      Scanner scanner = new Scanner(System.in);
      int op;
        System.out.println("Iniciando os facilitadores");
        System.out.println("Digite uma das opcoes abaixo");
        System.out.println("=========================================");
        System.out.println("1 - Acessar sistema de cadastros");
        System.out.println("2 - Sair do sistema");
        System.out.println("=========================================");
        do {
          op = scanner.nextInt();
          switch (op){
              case 1:
                  service.showMenu();
                  int optionInsert = scanner.nextInt();
                  switch(optionInsert){
                      case  1:
                          service.createProduto();
                          break;
                      case 2:
                          service.listarProdutos();
                          break;
                      case 3:
                          service.atualizarProdutoPorid();
                          break;
                      case 4:
                          service.buscarProdutoPorNome();
                          break;
                      default:
                          System.out.println("=========================================");
                          System.out.println("Opcao invalida do submenu.");
                          break;
                  }
                  break;
              case 2:
                  System.out.println("Saindo do sistema...");
                  break;
              default:
                  System.out.println("Opcao invalida");
                  break;
          }
          System.out.println("=========================================");
          System.out.println("Voce deseja?");
          System.out.println("1 - Retornar ao menu");
          System.out.println("2 - Sair do sistema");
      } while (op != 2);
      scanner.close();
    }
}