package components;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class MainForm extends JPanel {

    private PanelCover cover;
    private PainelLoginAndRegister loginPanel;

    public MainForm() {
        initComponents();
    }

    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(1000, 650));
        setLayout(new BorderLayout());

        // Fundo verde
        cover = new PanelCover();
        add(cover, BorderLayout.CENTER);

        // Painel de Login por cima
        loginPanel = new PainelLoginAndRegister();
        cover.setLayout(null); // Deixa livre para posicionar

        // Centralizar o painel de login
        loginPanel.setBounds(
                325,  // posição X centralizada
                125,  // posição Y centralizada
                350,  // largura do painel
                400   // altura do painel
        );

        cover.add(loginPanel);
    }
}
