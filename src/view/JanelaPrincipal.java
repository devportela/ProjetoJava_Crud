package view;

import dao.ClienteDAO;

import javax.swing.*;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        setTitle("Sistema CRUD - Janela Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        criarMenus();

        setVisible(true);
    }

    private void criarMenus() {
        JMenuBar barraMenu = new JMenuBar();

        // MENU CLIENTE
        JMenu menuCliente = new JMenu("Cliente");

        JMenuItem itemCadastrarCliente = new JMenuItem("Cadastrar");
        JMenuItem itemAtualizarCliente = new JMenuItem("Atualizar");
        JMenuItem itemDeletarCliente = new JMenuItem("Deletar");
        JMenuItem itemListarCliente = new JMenuItem("Listar");

        menuCliente.add(itemCadastrarCliente);
        menuCliente.add(itemAtualizarCliente);
        menuCliente.add(itemDeletarCliente);
        menuCliente.add(itemListarCliente);

        // MENU PRODUTO
        JMenu menuProduto = new JMenu("Produto");

        JMenuItem itemCadastrarProduto = new JMenuItem("Cadastrar");
        JMenuItem itemAtualizarProduto = new JMenuItem("Atualizar");
        JMenuItem itemDeletarProduto = new JMenuItem("Deletar");
        JMenuItem itemListarProduto = new JMenuItem("Listar");

        menuProduto.add(itemCadastrarProduto);
        menuProduto.add(itemAtualizarProduto);
        menuProduto.add(itemDeletarProduto);
        menuProduto.add(itemListarProduto);

        // MENU RELATÓRIO
        JMenu menuRelatorio = new JMenu("Relatórios");

        JMenuItem itemRelCliente = new JMenuItem("Relatório de Clientes");
        JMenuItem itemRelProduto = new JMenuItem("Relatório de Produtos");
        JMenuItem itemRelGeral = new JMenuItem("Relatório Geral");

        menuRelatorio.add(itemRelCliente);
        menuRelatorio.add(itemRelProduto);
        menuRelatorio.add(itemRelGeral);

        // MENU SISTEMA
        JMenu menuSistema = new JMenu("Sistema");
        JMenuItem itemSair = new JMenuItem("Sair");

        menuSistema.add(itemSair);

        // Adiciona menus à barra
        barraMenu.add(menuCliente);
        barraMenu.add(menuProduto);
        barraMenu.add(menuRelatorio);
        barraMenu.add(menuSistema);

        setJMenuBar(barraMenu);

        // AÇÕES DOS MENUS

        // CLIENTE
        itemCadastrarCliente.addActionListener(e -> abrirCadastroCliente());
        itemAtualizarCliente.addActionListener(e -> atualizarCliente());
        itemDeletarCliente.addActionListener(e -> deletarCliente());
        itemListarCliente.addActionListener(e -> listarClientes());

        // PRODUTO
        itemCadastrarProduto.addActionListener(e -> abrirCadastroProduto());
        itemAtualizarProduto.addActionListener(e -> atualizarProduto());
        itemDeletarProduto.addActionListener(e -> deletarProduto());
        itemListarProduto.addActionListener(e -> listarProdutos());

        // RELATÓRIOS
        itemRelCliente.addActionListener(e -> new RelatorioCliente());  // ⬅ AQUI ESTÁ O RELATÓRIO REAL
        itemRelProduto.addActionListener(e -> gerarRelatorioProdutos());
        itemRelGeral.addActionListener(e -> gerarRelatorioGeral());

        // SAIR
        itemSair.addActionListener(e -> System.exit(0));
    }

    // AÇÕES (telas da equipe 2)

    //chamar painel de dados

    private void abrirCadastroCliente(){
        //precisa ajustar a classe cliente
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
