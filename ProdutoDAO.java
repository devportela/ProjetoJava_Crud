import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ProdutoDAO {
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
            stmt.setString(2, produto.gerDescricao());
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

    //falta metodo listar
}
