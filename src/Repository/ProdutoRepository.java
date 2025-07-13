package Repository;
import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.sql.*;
import db.ConexaoBanco;

public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();

    public void store(String nome, Double preco, int quantidade) throws SQLException {

       String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";
       try(Connection conn = ConexaoBanco.getConexao();
           PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setInt(3, quantidade);
            stmt.executeUpdate();

            System.out.println("Produto cadastrado com sucesso");
       }catch(SQLException e){
           System.err.println("❌ Erro ao cadastrar produto: " + e.getMessage());
           e.printStackTrace();
       }
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
        if(produtos.isEmpty()){
            System.out.println("Nao ha produtos cadastrados, registre um produto.");
        }
        String sql = "SELECT * FROM produtos";
        try(Connection conn = ConexaoBanco.getConexao()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeQuery();
        }catch(SQLException e){

        }
        return produtos;
    }
}
