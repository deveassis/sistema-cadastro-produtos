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

    public void updateById(String nome){
        String sql = "SELECT * FROM produtos WHERE nome = ?";
        try(Connection conn = ConexaoBanco.getConexao()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet response = stmt.executeQuery();

            while(response.next()){
                int idUpdate = response.getInt("id");
                String nomeUpdate = response.getString("nome");
                Double precoUpdate = response.getDouble("preco");
                int quantidadeUpdate = response.getInt("quantidade");
                System.out.println("Dados atuais: " + idUpdate + "-" + nomeUpdate + "-" + precoUpdate + "-" + quantidadeUpdate);
            }

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

        String sql = "SELECT * FROM produtos";
        try(Connection conn = ConexaoBanco.getConexao()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");
                System.out.println("Id: " +id + ", " + nome + ", " +  preco + "," + quantidade + " ,");
            }
            if(produtos.isEmpty()){
                System.out.println("Nao ha produtos cadastrados, registre um produto.");
            }
        }catch(SQLException e){

        }
        return produtos;
    }
}
