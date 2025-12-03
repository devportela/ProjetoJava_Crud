import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {

        // PORTELA, QUANDO FOR COPIAR, COMEÇA A PARTIR DAQUI ↓
        // NÃO ESQUECE DE IMPORTAR OS PACOTES LÁ EM CIMA TBM

        setTitle("Sistema CRUD com Relatório");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane abas = new JTabbedPane();

        JPanel painelRelatorio = new JPanel(new BorderLayout());

        JLabel tituloRel = new JLabel("Gerar Relatório de Clientes");
        tituloRel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloRel.setFont(new Font("Arial", Font.BOLD, 18));
        painelRelatorio.add(tituloRel, BorderLayout.NORTH);

        JButton btnAbrirRelatorio = new JButton("Abrir Relatório de Clientes");
        btnAbrirRelatorio.setFont(new Font("Arial", Font.PLAIN, 14));
        btnAbrirRelatorio.addActionListener(e -> new RelatorioCliente());

        JPanel centroRel = new JPanel();
        centroRel.add(btnAbrirRelatorio);

        painelRelatorio.add(centroRel, BorderLayout.CENTER);

        abas.add("Relatório", painelRelatorio);

        getContentPane().add(abas);

        setVisible(true);

        // ATÉ AQUI PORTELA ↑
    }

    public static void main(String[] args) {
        new JanelaPrincipal();
    }
}
