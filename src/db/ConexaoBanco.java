package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static final String url = "jdbc:mysql://localhost:3306/sistemacadastro?useSSL=false&serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("Erro na conexao com banco de dados" + e.getMessage());
        }
    }


}
