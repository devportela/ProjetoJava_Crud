package view;

import dao.ProdutoDAO;
import model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

// Classe para exibir relatório de produtos e permitir atualização/exclusão
public class RelatorioProduto extends JFrame {

    private JTable tabela;                  // Tabela que exibe os produtos
    private DefaultTableModel modelo;       // Modelo de dados da tabela
    private ProdutoDAO dao = new ProdutoDAO(); // DAO para manipulação do banco
    private JLabel total;                   // Label para mostrar total de produtos

    public RelatorioProduto() {
        setTitle("Relatório de Produtos");
        setSize(900, 500);
        setLocationRelativeTo(null);

        // Configura modelo de tabela com colunas
        modelo = new DefaultTableModel(
                new Object[]{"ID", "Nome", "Descrição", "Quantidade", "Preço Unitário", "Fornecedor"}, 0
        );

        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        // Carrega dados do banco
        carregarProdutos();

        // ---------------- BOTÕES ----------------
        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnExcluir = new JButton("Excluir");

        // Ações dos botões
        btnAtualizar.addActionListener(this::acaoAtualizar);
        btnExcluir.addActionListener(this::acaoExcluir);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnExcluir);

        // ---------------- TOTAL DE PRODUTOS ----------------
        total = new JLabel("Total de produtos cadastrados: " + modelo.getRowCount());
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
    // CARREGA PRODUTOS NO MODELO DA TABELA
    // -----------------------------------------------------
    private void carregarProdutos() {
        modelo.setRowCount(0); // Limpa a tabela

        List<Produto> lista = dao.listar();

        for (Produto p : lista) {
            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getDescricao(),
                    p.getQuantidade(),
                    p.getPrecoUnitario(),
                    p.getFornecedor()
            });
        }

        // Atualiza label com total de produtos
        if (total != null) {
            total.setText("Total de produtos cadastrados: " + modelo.getRowCount());
        }
    }

    // -----------------------------------------------------
    // AÇÃO DE EXCLUIR PRODUTO
    // -----------------------------------------------------
    private void acaoExcluir(ActionEvent e) {
        int linha = tabela.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir!");
            return;
        }

        int id = (int) tabela.getValueAt(linha, 0);

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Deseja mesmo excluir este produto?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            dao.delete(id); // Remove do banco
            carregarProdutos(); // Recarrega tabela após exclusão
        }
    }

    // -----------------------------------------------------
    // AÇÃO DE ATUALIZAR PRODUTO
    // -----------------------------------------------------
    private void acaoAtualizar(ActionEvent e) {
        int linha = tabela.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para atualizar!");
            return;
        }

        // Cria objeto Produto a partir da linha selecionada
        Produto p = new Produto();
        p.setId((int) tabela.getValueAt(linha, 0));
        p.setNome((String) tabela.getValueAt(linha, 1));
        p.setDescricao((String) tabela.getValueAt(linha, 2));
        p.setQuantidade((int) tabela.getValueAt(linha, 3));
        p.setPrecoUnitario((double) tabela.getValueAt(linha, 4));
        p.setFornecedor((String) tabela.getValueAt(linha, 5));

        // Painel popup para edição dos campos
        JTextField txtNome = new JTextField(p.getNome());
        JTextField txtDesc = new JTextField(p.getDescricao());
        JTextField txtQtd = new JTextField(String.valueOf(p.getQuantidade()));
        JTextField txtPreco = new JTextField(String.valueOf(p.getPrecoUnitario()));
        JTextField txtFornecedor = new JTextField(p.getFornecedor());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nome:")); panel.add(txtNome);
        panel.add(new JLabel("Descrição:")); panel.add(txtDesc);
        panel.add(new JLabel("Quantidade:")); panel.add(txtQtd);
        panel.add(new JLabel("Preço Unitário:")); panel.add(txtPreco);
        panel.add(new JLabel("Fornecedor:")); panel.add(txtFornecedor);

        int resultado = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Atualizar Produto",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (resultado == JOptionPane.OK_OPTION) {
            // Atualiza objeto produto com novos valores
            p.setNome(txtNome.getText());
            p.setDescricao(txtDesc.getText());
            p.setQuantidade(Integer.parseInt(txtQtd.getText()));
            p.setPrecoUnitario(Double.parseDouble(txtPreco.getText()));
            p.setFornecedor(txtFornecedor.getText());

            dao.atualizar(p); // Atualiza no banco
            carregarProdutos(); // Recarrega tabela
        }
    }
}
