package src.views;


import javax.swing.*;
import java.awt.*;


public class BackgroundPanel extends JPanel {
    private final Color baseColor = Color.decode("#ffc800");
    private final Color gridColor = new Color(200, 140, 60);
    private final int tileSize = 40;

    public BackgroundPanel() {
        setOpaque(true);
        setPreferredSize(new Dimension(800, 800));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(baseColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        }
}