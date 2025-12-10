package view;

import gui.PainelClienteGUI;
import gui.PainelProdutoGUI;

import javax.swing.*;

// Classe que representa a janela principal do sistema CRUD
public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        setTitle("Sistema CRUD - Janela Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cria a barra de menus e itens
        criarMenus();

        // Configurações básicas da janela
        setSize(450, 67);
        setResizable(false);
        setVisible(true);
    }

    // Método para criar a barra de menus e adicionar ações
    private void criarMenus() {
        JMenuBar barraMenu = new JMenuBar();

        // =============== MENU CLIENTE ===============
        JMenu menuCliente = new JMenu("Cliente");
        menuCliente.setIcon(new ImageIcon("src/imgs/cliente_icon.png")); // Ícone do menu
        JMenuItem itemCadCliente = new JMenuItem("Painel Cadastro De Cliente");
        menuCliente.add(itemCadCliente);

        // =============== MENU PRODUTO ===============
        JMenu menuProduto = new JMenu("Produto");
        menuProduto.setIcon(new ImageIcon("src/imgs/produto_icon.png"));
        JMenuItem itemCadProduto = new JMenuItem("Painel Cadastro De Produto");
        menuProduto.add(itemCadProduto);

        // =============== MENU RELATÓRIOS ===============
        JMenu menuRelatorio = new JMenu("Relatórios");
        menuRelatorio.setIcon(new ImageIcon("src/imgs/relatorio.png"));
        JMenuItem itemRelCliente = new JMenuItem("Relatório de Clientes");
        JMenuItem itemRelProduto = new JMenuItem("Relatório de Produtos");
        menuRelatorio.add(itemRelCliente);
        menuRelatorio.add(itemRelProduto);

        // =============== MENU SISTEMA ===============
        JMenu menuSistema = new JMenu("Sistema");
        menuSistema.setIcon(new ImageIcon("src/imgs/sistema_icon.png"));
        JMenuItem itemSair = new JMenuItem("Sair");
        menuSistema.add(itemSair);

        // ---- Adiciona menus à barra com espaçamento ----
        barraMenu.add(menuCliente);
        barraMenu.add(Box.createHorizontalStrut(35));
        barraMenu.add(menuProduto);
        barraMenu.add(Box.createHorizontalStrut(35));
        barraMenu.add(menuRelatorio);
        barraMenu.add(Box.createHorizontalStrut(35));
        barraMenu.add(menuSistema);

        // Define a barra de menus na janela
        setJMenuBar(barraMenu);

        // =============== AÇÕES DOS ITENS DE MENU ====================
        itemCadCliente.addActionListener(e -> new PainelClienteGUI()); // Abrir painel cliente
        itemCadProduto.addActionListener(e -> new PainelProdutoGUI()); // Abrir painel produto
        itemRelCliente.addActionListener(e -> new RelatorioCliente()); // Gerar relatório clientes
        itemRelProduto.addActionListener(e -> new RelatorioProduto()); // Gerar relatório produtos
        itemSair.addActionListener(e -> System.exit(0)); // Sair do sistema
    }
}
