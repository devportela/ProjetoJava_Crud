package view;

import dao.ClienteDAO;
import model.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class RelatorioCliente extends JFrame {

    public RelatorioCliente() {
        setTitle("Relatório de Clientes");
        setSize(900, 500);
        setLocationRelativeTo(null);

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"ID", "Nome", "CPF", "Email", "Telefone", "Cidade", "Rua", "Recebe Notificação"}, 0
        );

        JTable tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        // CARREGAR OS CLIENTES
        ClienteDAO dao = new ClienteDAO();
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

        // TOTAL DE CLIENTES
        JLabel total = new JLabel("Total de clientes cadastrados: " + lista.size());
        total.setFont(new Font("Arial", Font.BOLD, 16));
        total.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ORGANIZAR LAYOUT
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        add(total, BorderLayout.SOUTH);

        setVisible(true);
    }
}
