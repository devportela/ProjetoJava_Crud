package dao;

import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends Produto{
    private Connection conn;

    public ProdutoDAO(){
        conn = Conexao.getConnection();
    }

    public void salvar(Produto produto){
        String sql = "INSERT INTO produto(nome, descricao, quantidade, precoUnitario, fornecedor)" + "VALUES(?,?,?,?,?)";
//metodo de atualizacao, como fazer?
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPrecoUnitario());
            stmt.setString(5, produto.getFornecedor());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // metodo atualizar
    public void atualizar(Produto produto){
        String sql= "update produto set nome = ?, descricao = ?, quantidade = ?, precoUnitario = ?, fornecedor = ? where id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPrecoUnitario());
            stmt.setString(5, produto.getFornecedor());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Produto produto){
        String sql = "Delete from produto WHERE id=?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //metodo listar

    public List<Produto> listar(){
        List<Produto>lista = new ArrayList<>();
        String sql = "SELECT * from Produto";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("Nome"));
                produto.setDescricao(rs.getString("Descrição"));
                produto.setQuantidade(rs.getInt("Quantidade"));
                produto.setPrecoUnitario(rs.getFloat("Preço Unitário"));
                produto.setFornecedor(rs.getString("Fornecedor"));
                lista.add(produto);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
}
