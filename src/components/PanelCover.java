package components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelCover extends JPanel {

    public PanelCover() {
        setOpaque(false);   // Permite que o fundo gradiente seja pintado manualmente
        setLayout(null);    // Permite posicionamento absoluto dos componentes
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Cria o degradê vertical do painel
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(40, 190, 90),
                0, getHeight(), new Color(0, 90, 40)
        );

        // Desenha o fundo com o degradê
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
