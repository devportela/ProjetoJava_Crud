package view;

import components.PanelCover;
import components.PainelLoginAndRegister;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class Main extends javax.swing.JFrame {
    private javax.swing.JLayeredPane bg;
    private MigLayout layout;
    private PanelCover cover;
    private PainelLoginAndRegister loginPanel;

    public Main() {
        initComponents();
        init();
    }

    private void init() {

        layout = new MigLayout("fill, insets 0");

        cover = new PanelCover();                 // FUNDO VERDE
        loginPanel = new PainelLoginAndRegister(); // PAINEL DE LOGIN

        bg.setLayout(new MigLayout("fill", "[grow]", "[grow]"));

        // ADICIONA O FUNDO VERDE
        bg.add(cover, "grow");

        // ADICIONA O PAINEL DE LOGIN POR CIMA
        cover.setLayout(null);
        loginPanel.setBounds(
                (933 - 350) / 2,
                (537 - 400) / 2,
                350, 400
        );
        cover.add(loginPanel);
        bg.add(loginPanel, "center, w 350!, h 400!");


    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 933, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 537, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bg)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setTitle("Login");
        // AQUI define o tamanho
        frame.setSize(1051, 699);
        frame.setResizable(false);
        frame.setContentPane(new MainForm());
        frame.pack();                // <-- Ajusta o tamanho automaticamente
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


}
