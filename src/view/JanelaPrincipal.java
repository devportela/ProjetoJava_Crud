package view;

import javax.swing.*;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        setTitle("Sistema CRUD - Janela Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        criarMenus();

        setSize(360, 67);
        setResizable(false);
        setVisible(true);


    }
    private void criarMenus() {
        JMenuBar barraMenu = new JMenuBar();

        // =============== MENU CLIENTE ===============
        JMenu menuCliente = new JMenu("Cliente");
        JMenuItem itemCadCliente = new JMenuItem("Painel Cadastro De Cliente");
        menuCliente.add(itemCadCliente);

        // =============== MENU PRODUTO ===============
        JMenu menuProduto = new JMenu("Produto");
        JMenuItem itemCadProduto = new JMenuItem("Painel Cadastro De Produto");
        menuProduto.add(itemCadProduto);

        // =============== MENU RELATÓRIOS ===============
        JMenu menuRelatorio = new JMenu("Relatórios");
        JMenuItem itemRelCliente = new JMenuItem("Relatório de Clientes");
        JMenuItem itemRelProduto = new JMenuItem("Relatório de Produtos");
        menuRelatorio.add(itemRelCliente);
        menuRelatorio.add(itemRelProduto);

        // =============== MENU SISTEMA ===============
        JMenu menuSistema = new JMenu("Sistema");
        JMenuItem itemSair = new JMenuItem("Sair");
        menuSistema.add(itemSair);

        // ---- Adiciona menus à barra com espaço ----
        barraMenu.add(menuCliente);
        barraMenu.add(Box.createHorizontalStrut(35));
        barraMenu.add(menuProduto);
        barraMenu.add(Box.createHorizontalStrut(35));
        barraMenu.add(menuRelatorio);
        barraMenu.add(Box.createHorizontalStrut(35));
        barraMenu.add(menuSistema);

        setJMenuBar(barraMenu);

        // =============== AÇÕES ====================
        // MENU CLIENTE
        //itemCadCliente.addActionListener(e -> new PainelClienteGUI());

        // MENU PRODUTO
        //itemCadProduto.addActionListener(e -> new PainelProdutoGUI());

        // RELATÓRIOS
        itemRelCliente.addActionListener(e -> new RelatorioCliente());
        itemRelProduto.addActionListener(e -> new RelatorioProduto());

        // SAIR
        itemSair.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JanelaPrincipal());
    }
}
