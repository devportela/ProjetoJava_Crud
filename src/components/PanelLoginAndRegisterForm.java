package components;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

public class PanelLoginAndRegisterForm extends JPanel {

    private JPanel login;

    public PanelLoginAndRegisterForm() {
        initComponents();   // Inicializa os componentes do painel
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        // Painel destinado ao formulário de login
        login = new JPanel();

        // Layout principal do painel
        setLayout(new java.awt.BorderLayout());

        // Configuração visual do painel de login
        login.setBackground(Color.WHITE);

        // Define layout interno do painel de login
        GroupLayout loginLayout = new GroupLayout(login);
        login.setLayout(loginLayout);

        // Define dimensões horizontais
        loginLayout.setHorizontalGroup(
                loginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 327, Short.MAX_VALUE)
        );

        // Define dimensões verticais
        loginLayout.setVerticalGroup(
                loginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        // Adiciona o painel de login ao centro do layout
        add(login, java.awt.BorderLayout.CENTER);
    }
}
