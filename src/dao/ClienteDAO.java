package dao;
import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void salvar(Cliente c) {
        String sql = "INSERT INTO cliente (nome, cpf, email, telefone, cidade, rua, receberNT) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getCidade());
            stmt.setString(6, c.getRua());
            stmt.setBoolean(7, c.isReceberNotificacao());

            stmt.execute();
            System.out.println("Cliente salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    // ===========================
    //  LISTAR CLIENTES
    // ===========================
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();

                c.setId(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setCidade(rs.getString("cidade"));
                c.setRua(rs.getString("rua"));
                c.setReceberNotificacao(rs.getBoolean("receberNT")); // ← CORREÇÃO

                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }


    // ===========================
    //  ATUALIZAR CLIENTE
    // ===========================
    public void atualizar(Cliente c) {
        String sql = "UPDATE cliente SET nome=?, cpf=?, email=?, telefone=?, cidade=?, rua=?, receberNT=? "
                + "WHERE id_cliente=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getCidade());
            stmt.setString(6, c.getRua());
            stmt.setBoolean(7, c.isReceberNotificacao());
            stmt.setInt(8, c.getId());

            stmt.execute();
            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    // ===========================
    //  DELETAR CLIENTE
    // ===========================
    public void deletar(int id) {
        String sql = "DELETE FROM cliente WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Cliente excluído!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}


