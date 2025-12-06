package gui;

import dao.ClienteDAO;
import model.Cliente;

import javax.swing.*;
import java.awt.*;

public class ClienteGUI extends JFrame {



    private JButton botaoExcluir;
    private JButton botaoSalvar;

    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoEmail;
    private JTextField campoTelefone;
    private JTextField campoRua;
    private JTextField campoCidade;
    private JCheckBox campoReceberNT;
    private JPanel panelBotoes;

    public ClienteGUI() {
        setTitle("Tela de Clientes");
        setSize(320, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // <-- IMPORTANTE
        initComponents();
        setVisible(true); // <-- GARANTE QUE ABRA AO INSTANCIAR
    }

    // Campo com borda arredondada
    private JTextField arredondarCampo(JTextField campo) {
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(150,150,150), 1, true),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
        return campo;
    }

    private void initComponents() {

        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(2, 10, 5, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 0, 6, 0);
        gbc.weightx = 1;

        int row = 0;

        // TÍTULO
        JLabel titulo = new JLabel("Cadastro de Clientes", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 10, 37, 0);
        painel.add(titulo, gbc);
        // ===== CAMPOS DO BANCO =====

        // NOME
        row++;
        gbc.gridwidth = 1;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(6, 1, 6, 0);
        painel.add(new JLabel("Nome:"), gbc);

        campoNome = arredondarCampo(new JTextField(15));
        campoNome.setPreferredSize(new Dimension(180, 26));
        gbc.gridx = 1;
        gbc.insets = new Insets(6, -110, 6, 0);
        painel.add(campoNome, gbc);

// CPF
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.insets = new Insets(6, 1, 6, 0);
        painel.add(new JLabel("CPF:"), gbc);

        campoCpf = arredondarCampo(new JTextField(15));
        campoCpf.setPreferredSize(new Dimension(180, 26));
        gbc.gridx = 1;
        gbc.insets = new Insets(6, -110, 6, 0);
        painel.add(campoCpf, gbc);


// EMAIL
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.insets = new Insets(6, 1, 6, 0);
        painel.add(new JLabel("E-mail:"), gbc);

        campoEmail = arredondarCampo(new JTextField(15));
        campoEmail.setPreferredSize(new Dimension(180, 26));
        gbc.gridx = 1;
        gbc.insets = new Insets(6, -110, 6, 0);
        painel.add(campoEmail, gbc);

// TELEFONE
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.insets = new Insets(6, 1, 6, 0);
        painel.add(new JLabel("Telefone:"), gbc);

        campoTelefone = arredondarCampo(new JTextField(15));
        campoTelefone.setPreferredSize(new Dimension(180, 26));
        gbc.gridx = 1;
        gbc.insets = new Insets(6, -110, 6, 0);
        painel.add(campoTelefone, gbc);

// RUA
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.insets = new Insets(6, 1, 6, 0);
        painel.add(new JLabel("Rua:"), gbc);

        campoRua = arredondarCampo(new JTextField(15));
        campoRua.setPreferredSize(new Dimension(180, 26));
        gbc.gridx = 1;
        gbc.insets = new Insets(6, -110, 6, 0);
        painel.add(campoRua, gbc);

// CIDADE
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.insets = new Insets(6, 1, 6, 0);
        painel.add(new JLabel("Cidade:"), gbc);

        campoCidade = arredondarCampo(new JTextField(15));
        campoCidade.setPreferredSize(new Dimension(180, 26));
        gbc.gridx = 1;
        gbc.insets = new Insets(6, -110, 6, 0);
        painel.add(campoCidade, gbc);

// RECEBER NOTÍCIAS
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.insets = new Insets(6, 5, 6, 0);
        painel.add(new JLabel("Receber Notificações?"), gbc);

        campoReceberNT = new JCheckBox("Sim");
        gbc.gridx = 1;
        gbc.insets = new Insets(6, -10, 6, 0);
        painel.add(campoReceberNT, gbc);

// BOTÕES
        row++;
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 15, 0, 0);
        panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 0));
        botaoSalvar = new JButton("Salvar");
        JButton botaoLimpar = new JButton("Limpar");
        panelBotoes.add(botaoLimpar);
        panelBotoes.add(botaoSalvar);
        painel.add(panelBotoes, gbc);

        // AÇÕES
        botaoSalvar.addActionListener(evt -> salvarCliente());
        botaoLimpar.addActionListener(evt -> limparCampos());


        add(painel);
    }

    private void salvarCliente() {
        {
            // ===== VALIDAÇÃO =====
            if (campoNome.getText().trim().isEmpty() ||
                    campoCpf.getText().trim().isEmpty() ||
                    campoEmail.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Preencha pelo menos Nome, CPF e Email!",
                        "Campos Obrigatórios",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // ===== MONTAR OBJETO CLIENTE =====
            Cliente c = new Cliente();
            c.setNome(campoNome.getText());
            c.setCpf(campoCpf.getText());
            c.setEmail(campoEmail.getText());
            c.setTelefone(campoTelefone.getText());
            c.setCidade(campoCidade.getText());
            c.setRua(campoRua.getText());
            c.setReceberNotificacao(campoReceberNT.isSelected());

            // ===== SALVAR NO BANCO =====
            ClienteDAO dao = new ClienteDAO();

            try {
                dao.salvar(c);
                JOptionPane.showMessageDialog(this,
                        "Cliente salvo com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);

                // Limpa os campos após salvar
                limparCampos();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao salvar cliente: " + e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    private void limparCampos() {
        campoNome.setText("");
        campoCpf.setText("");
        campoEmail.setText("");
        campoTelefone.setText("");
        campoRua.setText("");
        campoCidade.setText("");
        campoReceberNT.setSelected(false);
    }

}
