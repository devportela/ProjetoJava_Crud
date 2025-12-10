package dao;

import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection conn;

    public ProdutoDAO() {
        conn = Conexao.getConnection();   // Conexão única para a classe
    }

    // Cadastra um novo produto no banco
    public void cadastrar(Produto produto) {
        String sql = "INSERT INTO produto(nome_prod, descricao, quantidade, precoUnitario, fornecedor) "
                + "VALUES(?,?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPrecoUnitario());
            stmt.setString(5, produto.getFornecedor());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Atualiza um produto existente
    public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET nome_prod=?, descricao=?, quantidade=?, precoUnitario=?, fornecedor=? "
                + "WHERE id_prod=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPrecoUnitario());
            stmt.setString(5, produto.getFornecedor());
            stmt.setInt(6, produto.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove um produto do banco pelo ID
    public void delete(int id) {
        String sql = "DELETE FROM produto WHERE id_prod=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // Retorna a lista de todos os produtos cadastrados
    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setId(rs.getInt("id_prod"));
                produto.setNome(rs.getString("nome_prod"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
                produto.setFornecedor(rs.getString("fornecedor"));

                lista.add(produto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
