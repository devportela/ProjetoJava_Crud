import components.MainForm;
import components.PanelCover;
import components.PainelLoginAndRegister;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class Main extends javax.swing.JFrame {

    private javax.swing.JLayeredPane bg;                // Camada principal para sobreposição de componentes
    private MigLayout layout;                           // Layout manager flexível do MigLayout
    private PanelCover cover;                           // Painel de fundo (verde)
    private PainelLoginAndRegister loginPanel;         // Painel de login e registro

    public Main() {
        initComponents();   // Inicializa componentes Swing padrão
        init();             // Inicializa layout customizado e adiciona painéis
    }

    private void init() {
        layout = new MigLayout("fill, insets 0");       // Layout principal sem margens

        cover = new PanelCover();                        // Painel de fundo
        loginPanel = new PainelLoginAndRegister();      // Painel de login

        bg.setLayout(new MigLayout("fill", "[grow]", "[grow]")); // Layout da camada principal

        // Adiciona o fundo verde
        bg.add(cover, "grow");

        // Configura posição e tamanho do painel de login
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

        // Layout da camada principal
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

        // Layout do frame principal
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

        pack();                       // Ajusta tamanho de acordo com os componentes
        setLocationRelativeTo(null);  // Centraliza janela
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setTitle("Login Admin");
        frame.setSize(1051, 699);             // Tamanho fixo
        frame.setResizable(false);
        frame.setContentPane(new MainForm()); // Conteúdo principal
        frame.pack();                          // Ajusta tamanho automaticamente
        frame.setLocationRelativeTo(null);    // Centraliza tela
        frame.setVisible(true);                // Exibe janela
    }
}
