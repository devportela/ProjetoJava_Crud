import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static Connection getConnection() {
        try {

            String url = "jdbc:mysql://localhost:3306/projetocrudclient";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Erro na conexao:" + e.getMessage());

        }
    }
}