package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

    private static final String SQL_LOGIN =
            "SELECT 1 FROM admin WHERE id_admin = ? AND senha = ? LIMIT 1";

    public boolean login(String id, String password) {
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_LOGIN)) {

            stmt.setString(1, id);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
