package components;

import dao.AdminDAO;
import swing.Button;
import swing.MyPasswordField;
import swing.MyTextField;
import view.JanelaPrincipal;

import java.awt.*;
import javax.swing.*;

public class PainelLoginAndRegister extends javax.swing.JLayeredPane {

    public PainelLoginAndRegister() {
        initComponents();
        estilizarPainel();      // Configura aparência do painel
        initLogin();            // Monta os componentes de login
        login.setVisible(true);
    }

    // Configura estilo visual do painel
    private void estilizarPainel() {
        login.setOpaque(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arc = 40;

        // Desenha sombra
        g2.setColor(new Color(0, 0, 0, 35));
        g2.fillRoundRect(8, 8, getWidth() - 16, getHeight() - 16, arc, arc);

        // Desenha fundo arredondado
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
    }

    // Cria os componentes da tela de login
    private void initLogin() {

        login.setLayout(new net.miginfocom.swing.MigLayout(
                "wrap", "push[center]push", "push[]25[]10[]10[]25[]push"
        ));

        // Título
        JLabel label = new JLabel("Login");
        label.setFont(new Font("SansSerif", Font.BOLD, 32));
        label.setForeground(new Color(7, 164, 121));
        login.add(label, "gapbottom 15");

        // Campo de credencial
        MyTextField txtId = new MyTextField();
        txtId.setHint("Credencial");
        txtId.setBackground(new Color(240, 255, 250));
        txtId.setFont(new Font("SansSerif", Font.PLAIN, 15));
        login.add(txtId, "w 65%, h 45!");

        // Campo de senha
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setHint("Senha");
        txtPass.setBackground(new Color(240, 255, 250));
        txtPass.setFont(new Font("SansSerif", Font.PLAIN, 15));
        login.add(txtPass, "w 65%, h 45!");

        // Botão de login
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(Color.WHITE);
        cmd.setText("Login");
        cmd.setFont(new Font("SansSerif", Font.BOLD, 15));
        login.add(cmd, "w 40%, h 40!");

        // Ação do botão
        cmd.addActionListener(e -> {
            String id = txtId.getText();
            String pass = new String(txtPass.getPassword());

            AdminDAO dao = new AdminDAO();

            try {
                if (dao.login(id, pass)) {
                    JOptionPane.showMessageDialog(this, "Bem-vindo admin!");

                    // Fecha a janela atual
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    frame.dispose();

                    // Abre a janela principal
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
        login = new JPanel();
        setLayout(new BorderLayout());
        add(login, BorderLayout.CENTER);
    }

    // Não utilizado no momento
    public void showRegister(boolean show) {}

    private JPanel login;
}
