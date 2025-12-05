package view;

import javax.swing.*;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        setTitle("Sistema CRUD - Janela Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        criarMenus();

// Define tamanho fixo
        setSize(360, 67);
        setResizable(false);
        setVisible(true);

    }

    private void criarMenus() {
        JMenuBar barraMenu = new JMenuBar();

        // MENU CLIENTE
        JMenu menuCliente = new JMenu("Cliente");

        // MENU PRODUTO
        JMenu menuProduto = new JMenu("Produto");


        // MENU RELATÓRIO
        JMenu menuRelatorio = new JMenu("Relatórios");

        JMenuItem itemRelCliente = new JMenuItem("Relatório de Clientes");
        JMenuItem itemRelProduto = new JMenuItem("Relatório de Produtos");

        menuRelatorio.add(itemRelCliente);
        menuRelatorio.add(itemRelProduto);

        // MENU SISTEMA
        JMenu menuSistema = new JMenu("Sistema");
        JMenuItem itemSair = new JMenuItem("Sair");

        menuSistema.add(itemSair);

        // Adiciona menus à barra com espaçamento
        barraMenu.add(menuCliente);
        barraMenu.add(Box.createHorizontalStrut(35));  // espaço
        barraMenu.add(menuProduto);
        barraMenu.add(Box.createHorizontalStrut(35));  // espaço
        barraMenu.add(menuRelatorio);
        barraMenu.add(Box.createHorizontalStrut(35));  // espaço
        barraMenu.add(menuSistema);
        setJMenuBar(barraMenu);

        // AÇÕES DOS MENUS



        // RELATÓRIOS
        itemRelCliente.addActionListener(e -> new RelatorioCliente());  // ⬅ AQUI ESTÁ O RELATÓRIO REAL
        itemRelProduto.addActionListener(e -> gerarRelatorioProdutos());
        // SAIR
        itemSair.addActionListener(e -> System.exit(0));
    }

    // AÇÕES (telas da equipe 2)

    private void abrirCadastroCliente() {
        JOptionPane.showMessageDialog(this, "ABRIR tela de cadastro de CLIENTE");
    }

    private void atualizarCliente() {
        JOptionPane.showMessageDialog(this, "ABRIR tela de atualizar CLIENTE");
    }

    private void deletarCliente() {
        JOptionPane.showMessageDialog(this, "DELETAR CLIENTE");
    }

    private void listarClientes() {
        JOptionPane.showMessageDialog(this, "LISTAR CLIENTES");
    }

    private void abrirCadastroProduto() {
        JOptionPane.showMessageDialog(this, "ABRIR tela de cadastro de PRODUTO");
    }

    private void atualizarProduto() {
        JOptionPane.showMessageDialog(this, "ABRIR tela de atualizar PRODUTO");
    }

    private void deletarProduto() {
        JOptionPane.showMessageDialog(this, "DELETAR PRODUTO");
    }

    private void listarProdutos() {
        JOptionPane.showMessageDialog(this, "LISTAR PRODUTOS");
    }

    private void gerarRelatorioProdutos() {
        JOptionPane.showMessageDialog(this, "GERAR RELATÓRIO DE PRODUTOS");
    }

    private void gerarRelatorioGeral() {
        JOptionPane.showMessageDialog(this, "GERAR RELATÓRIO GERAL");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JanelaPrincipal());
    }
}
