package view;

import dao.ProdutoDAO;
import model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.awt.*;

public class RelatorioProduto extends JFrame {

    private JTable tabela;

    public RelatorioProduto(){
        setTitle("Relatório de Produtos");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        montarTela();

        setVisible(true);
    }

    private void montarTela(){

        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listar();

        // Painel principal
        JPanel painel = new JPanel(new BorderLayout());

        // Modelo da tabela
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Descrição");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Preço Unitário");
        modelo.addColumn("Fornecedor");

        for (Produto p : lista){
            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getDescricao(),
                    p.getQuantidade(),
                    p.getPrecoUnitario(),
                    p.getFornecedor()
            });
        }

        tabela = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabela);
        painel.add(scroll, BorderLayout.CENTER);

        // Label com total de produtos
        JLabel lblTotal = new JLabel("Total de produtos cadastrados: " + lista.size());
        lblTotal.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        painel.add(lblTotal, BorderLayout.SOUTH);

        add(painel);
    }
}
