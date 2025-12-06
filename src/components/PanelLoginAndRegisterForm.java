package components;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

public class PanelLoginAndRegisterForm extends JPanel {

    private JPanel login;

    public PanelLoginAndRegisterForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        // Apenas painel LOGIN
        login = new JPanel();

        setLayout(new java.awt.BorderLayout());

        // Painel LOGIN
        login.setBackground(new Color(255, 255, 255));

        GroupLayout loginLayout = new GroupLayout(login);
        login.setLayout(loginLayout);

        loginLayout.setHorizontalGroup(
                loginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 327, Short.MAX_VALUE)
        );

        loginLayout.setVerticalGroup(
                loginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, java.awt.BorderLayout.CENTER);
    }
}
