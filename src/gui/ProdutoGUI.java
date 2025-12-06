package gui;

import dao.ProdutoDAO;
import model.Produto;

import javax.swing.*;
import java.awt.*;

public class ProdutoGUI extends JFrame {

    private JTextField campoNome;
    private JTextField campoDescricao;
    private JTextField campoQuantidade;
    private JTextField campoPreco;
    private JTextField campoFornecedor;

    private JButton botaoSalvar;

    public ProdutoGUI() {
        setTitle("Cadastro de Produtos");
        setSize(320, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();
        setVisible(true);
    }

    // Campo com borda arredondada
    private JTextField arredondarCampo(JTextField campo) {
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(150, 150, 150), 1, true),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
        return campo;
    }

    private void initComponents() {

        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(2, 10, 5, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 0, 6, 0);
        gbc.weightx = 1;

        int row = 0;

        // TÍTULO
        JLabel titulo = new JLabel("Cadastro de Produtos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 15, 37, 0);
        painel.add(titulo, gbc);

        // ===== CAMPOS =====

        // NOME
        row++;
        gbc.gridwidth = 1;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.insets = new Insets(6, -8, 6, 0);
        painel.add(new JLabel("Nome:"), gbc);

        campoNome = arredondarCampo(new JTextField(13));
        campoNome.setPreferredSize(new Dimension(10, 26));
        gbc.gridx = 1;
        gbc.insets = new Insets(6, -2, 6, 0);
        painel.add(campoNome, gbc);

        // DESCRICAO
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.insets = new Insets(6, -8, 6, 0);
        painel.add(new JLabel("Descrição:"), gbc);
        campoDescricao = arredondarCampo(new JTextField(13));
        campoDescricao.setPreferredSize(new Dimension(10, 26));
        gbc.gridx = 1;
        gbc.insets = new Insets(6, -2, 6, 0);
        painel.add(campoDescricao, gbc);

        // QUANTIDADE
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.insets = new Insets(6, -8, 6, 0);
        painel.add(new JLabel("Quantidade:"), gbc);

        campoQuantidade = arredondarCampo(new JTextField(13));
        campoQuantidade.setPreferredSize(new Dimension(10, 26));
        gbc.gridx = 1;
        gbc.insets = new Insets(6, -2, 6, 0);
        painel.add(campoQuantidade, gbc);

        // PREÇO UNITÁRIO
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.insets = new Insets(6, -8, 6, 0);
        painel.add(new JLabel("Preço Unitário:"), gbc);
        campoPreco = arredondarCampo(new JTextField(13));
        campoPreco.setPreferredSize(new Dimension(180, 26));
        gbc.gridx = 1;
        gbc.insets = new Insets(6, -2, 6, 0);
        painel.add(campoPreco, gbc);

        // FORNECEDOR
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.insets = new Insets(6, -8, 6, 0);
        painel.add(new JLabel("Fornecedor:"), gbc);

        campoFornecedor = arredondarCampo(new JTextField(13));
        campoFornecedor.setPreferredSize(new Dimension(180, 26));
        gbc.gridx = 1;
        gbc.insets = new Insets(6, -2, 6, 0);
        painel.add(campoFornecedor, gbc);

        // BOTÕES
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 15, 0, 0);

        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 0));
        botaoSalvar = new JButton("Salvar");
        JButton botaoLimpar = new JButton("Limpar");

        panelBotoes.add(botaoLimpar);
        panelBotoes.add(botaoSalvar);
        painel.add(panelBotoes, gbc);

        // AÇÕES
        botaoSalvar.addActionListener(e -> salvarProduto());
        botaoLimpar.addActionListener(e -> limparCampos());

        add(painel);
    }

    private void salvarProduto() {

        // Validação simples
        if (campoNome.getText().trim().isEmpty() ||
                campoQuantidade.getText().trim().isEmpty() ||
                campoPreco.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Preencha Nome, Quantidade e Preço!",
                    "Campos obrigatórios",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {

            Produto p = new Produto();
            p.setNome(campoNome.getText());
            p.setDescricao(campoDescricao.getText());
            p.setQuantidade(Integer.parseInt(campoQuantidade.getText()));
            p.setPrecoUnitario(Double.parseDouble(campoPreco.getText()));
            p.setFornecedor(campoFornecedor.getText());

            ProdutoDAO dao = new ProdutoDAO();
            dao.cadastrar(p);

            JOptionPane.showMessageDialog(this,
                    "Produto salvo com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            limparCampos();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Erro ao salvar produto: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoDescricao.setText("");
        campoQuantidade.setText("");
        campoPreco.setText("");
        campoFornecedor.setText("");
    }
}
