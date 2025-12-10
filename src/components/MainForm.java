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

        // Define o tamanho padrão do painel principal e o layout
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setLayout(new BorderLayout());

        // Painel de fundo
        cover = new PanelCover();
        add(cover, BorderLayout.CENTER);

        // Painel de login/registro posicionado sobre o fundo
        loginPanel = new PainelLoginAndRegister();
        cover.setLayout(null);  // Permite posicionamento manual

        // Define a posição e tamanho do painel de login
        loginPanel.setBounds(
                325,  // Posição horizontal
                125,  // Posição vertical
                350,  // Largura
                400   // Altura
        );

        // Adiciona o painel de login ao fundo
        cover.add(loginPanel);
    }
}
