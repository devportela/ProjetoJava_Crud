    import java.sql.*;
    import java.sql.Connection;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.List;
    import java.util.ArrayList;




    public class ClienteDAO {
        private Connection conn; //guarda uma conexao ja existente com o banco de dados

        public ClienteDAO(Connection conn) {
            this.conn = conn; //metodo construtos para acessar o banco

        }  }



    // SALVAR CLIENTE
    // -------------------------

    public void salvar(Cliente cliente){
        String sql = "INSERT INTO clientes (nome, email, cpf, telefone, endereco, receberNotificacao )" +
                " VALUES (?, ?, ? , ? , ? , ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql); // monta a query e envia para o banco
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setBoolean(6, cliente.isReceberNotificacao());
            stmt.executeUpdate(); // executa o banco
            stmt.close();           //finaliza a operacao
        } catch(SQLException e){
            e.printStackTrace();
        }
        //query e um comando ou instrução que enviamos ao banco exemplo : "inset", "delete"
    }

    //LISTAR CLIENTES
    //-----------------------

    public List<Cliente>listar(){
        List <Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                c.setReceberNotificacao(rs.getBoolean("receberNotificacao"));

                lista.add(c);
            }
            rs.close();
            stmt.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return lista;

    }

    //ATUALIZAR CLIENTE

    public void atualizar(Cliente cliente) {

        String sql = "UPDATE clientes SET nome = ?, email = ?, cpf = ?, telefone = ?, endereco = ?, receberNotificacao = ? " +
                "WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setBoolean(6, cliente.isReceberNotificacao());
            stmt.setInt(7, cliente.getId());
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    // EXCLUIR CLIENTE

    public void excluir(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
