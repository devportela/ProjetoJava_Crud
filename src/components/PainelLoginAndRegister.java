package components;


import dao.AdminDAO;
import swing.Button;
import swing.MyPasswordField;
import swing.MyTextField;
import view.JanelaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*;

public class PainelLoginAndRegister extends javax.swing.JLayeredPane {

    public PainelLoginAndRegister() {
        initComponents();
        estilizarPainel();     // ✓ deixa o painel bonito
        initLogin();           // ✓ monta os componentes
        login.setVisible(true);
    }

    // --------------------------
    // VISUAL PREMIUM DO PAINEL
    // --------------------------
    private void estilizarPainel() {
        login.setOpaque(false);    // permite desenhar bordas arredondadas
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arc = 40;

        // sombra
        g2.setColor(new Color(0, 0, 0, 35));
        g2.fillRoundRect(8, 8, getWidth() - 16, getHeight() - 16, arc, arc);

        // fundo arredondado
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
    }

    // --------------------------
    // MONTAGEM DO LOGIN
    // --------------------------
    private void initLogin() {

        login.setLayout(new net.miginfocom.swing.MigLayout(
                "wrap", "push[center]push", "push[]25[]10[]10[]25[]push"
        ));

        // --- TÍTULO ---
        javax.swing.JLabel label = new javax.swing.JLabel("Login");
        label.setFont(new Font("SansSerif", Font.BOLD, 32));
        label.setForeground(new Color(7, 164, 121));
        login.add(label, "gapbottom 15");

        // --- CAMPO EMAIL ---
        MyTextField txtId = new MyTextField();
        txtId.setPrefixIcon(new ImageIcon(getClass().getResource("/imgs/mail.png")));
        txtId.setHint("Credencial");
        txtId.setBackground(new Color(240, 255, 250));
        txtId.setFont(new Font("SansSerif", Font.PLAIN, 15));
        login.add(txtId, "w 65%, h 45!");

        // --- CAMPO SENHA ---
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/imgs/pass.png")));
        txtPass.setHint("Senha");
        txtPass.setBackground(new Color(240, 255, 250));
        txtPass.setFont(new Font("SansSerif", Font.PLAIN, 15));
        login.add(txtPass, "w 65%, h 45!");

        // --- BOTÃO LOGIN ---
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(Color.WHITE);
        cmd.setText("Login");
        cmd.setFont(new Font("SansSerif", Font.BOLD, 15));
        login.add(cmd, "w 40%, h 40!");

        cmd.addActionListener(e -> {
            String id = txtId.getText();
            String pass = new String(txtPass.getPassword());

            AdminDAO dao = new AdminDAO(); // aqui cria o DAO correto

            try {
                if (dao.login(id, pass)) {
                    JOptionPane.showMessageDialog(this, "Bem-vindo admin!");

                    // FECHAR A JANELA ATUAL (a de login)
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    frame.dispose();

                    // ABRIR A JANELA PRINCIPAL
                    new JanelaPrincipal();

                } else {
                    JOptionPane.showMessageDialog(this, "Login incorreto.");
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        login = new javax.swing.JPanel();
        setLayout(new java.awt.BorderLayout());
        add(login, java.awt.BorderLayout.CENTER);
    }

    // Sem registro, então não faz nada
    public void showRegister(boolean show) {}

    private javax.swing.JPanel login;
}
