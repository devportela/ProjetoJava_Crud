package view;

import dao.ClienteDAO;
import model.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class RelatorioCliente extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;
    private ClienteDAO dao = new ClienteDAO();
    private JLabel total;

    public RelatorioCliente() {
        setTitle("Relatório de Clientes");
        setSize(900, 500);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel(
                new Object[]{"ID", "Nome", "CPF", "Email", "Telefone", "Cidade", "Rua", "Recebe Notificação"}, 0
        );

        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        carregarClientes();

        // ---------------- BOTÕES ----------------
        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnExcluir = new JButton("Excluir");

        btnAtualizar.addActionListener(this::acaoAtualizar);
        btnExcluir.addActionListener(this::acaoExcluir);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnExcluir);

        // ---------------- TOTAL DE CLIENTES ----------------
        total = new JLabel("Total de clientes cadastrados: " + modelo.getRowCount());
        total.setFont(new Font("Arial", Font.BOLD, 16));
        total.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Painel inferior com botões + total
        JPanel painelInferior = new JPanel(new BorderLayout());
        painelInferior.add(painelBotoes, BorderLayout.NORTH);
        painelInferior.add(total, BorderLayout.SOUTH);

        // ---------------- LAYOUT PRINCIPAL ----------------
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    // -----------------------------------------------------
    // CARREGAR CLIENTES
    // -----------------------------------------------------
    private void carregarClientes() {
        modelo.setRowCount(0);

        List<Cliente> lista = dao.listar();

        for (Cliente c : lista) {
            modelo.addRow(new Object[]{
                    c.getId(),
                    c.getNome(),
                    c.getCpf(),
                    c.getEmail(),
                    c.getTelefone(),
                    c.getCidade(),
                    c.getRua(),
                    c.isReceberNotificacao() ? "Sim" : "Não"
            });
        }

        if (total != null) {
            total.setText("Total de clientes cadastrados: " + modelo.getRowCount());
        }
    }

    // -----------------------------------------------------
    // EXCLUIR CLIENTE
    // -----------------------------------------------------
    private void acaoExcluir(ActionEvent e) {
        int linha = tabela.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para excluir!");
            return;
        }

        int id = (int) tabela.getValueAt(linha, 0);

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Deseja mesmo excluir este cliente?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            dao.deletar(id);
            carregarClientes();
        }
    }

    // -----------------------------------------------------
    // ATUALIZAR CLIENTE NO PRÓPRIO RELATÓRIO
    // -----------------------------------------------------
    private void acaoAtualizar(ActionEvent e) {
        int linha = tabela.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para atualizar!");
            return;
        }

        Cliente c = new Cliente();
        c.setId((int) tabela.getValueAt(linha, 0));
        c.setNome((String) tabela.getValueAt(linha, 1));
        c.setCpf((String) tabela.getValueAt(linha, 2));
        c.setEmail((String) tabela.getValueAt(linha, 3));
        c.setTelefone((String) tabela.getValueAt(linha, 4));
        c.setCidade((String) tabela.getValueAt(linha, 5));
        c.setRua((String) tabela.getValueAt(linha, 6));
        c.setReceberNotificacao("Sim".equals(tabela.getValueAt(linha, 7)));

        // POPUP DE EDIÇÃO
        JTextField txtNome = new JTextField(c.getNome());
        JTextField txtCpf = new JTextField(c.getCpf());
        JTextField txtEmail = new JTextField(c.getEmail());
        JTextField txtTelefone = new JTextField(c.getTelefone());
        JTextField txtCidade = new JTextField(c.getCidade());
        JTextField txtRua = new JTextField(c.getRua());
        JCheckBox chkNotificacao = new JCheckBox("Receber Notificação", c.isReceberNotificacao());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nome:")); panel.add(txtNome);
        panel.add(new JLabel("CPF:")); panel.add(txtCpf);
        panel.add(new JLabel("Email:")); panel.add(txtEmail);
        panel.add(new JLabel("Telefone:")); panel.add(txtTelefone);
        panel.add(new JLabel("Cidade:")); panel.add(txtCidade);
        panel.add(new JLabel("Rua:")); panel.add(txtRua);
        panel.add(chkNotificacao);

        int resultado = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Atualizar Cliente",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (resultado == JOptionPane.OK_OPTION) {
            c.setNome(txtNome.getText());
            c.setCpf(txtCpf.getText());
            c.setEmail(txtEmail.getText());
            c.setTelefone(txtTelefone.getText());
            c.setCidade(txtCidade.getText());
            c.setRua(txtRua.getText());
            c.setReceberNotificacao(chkNotificacao.isSelected());

            dao.atualizar(c);
            carregarClientes();
        }
    }

}
