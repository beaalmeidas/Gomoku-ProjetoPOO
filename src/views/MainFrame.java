package src.views;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private CardLayout layout;
    private JPanel mainPanel;
    private ImageIcon windowIcon = new ImageIcon(getClass().getResource("/assets/gomoku-logo.png"));

    public MainFrame() {
        setTitle("Gomoku");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(windowIcon.getImage());

        layout = new CardLayout();
        mainPanel = new JPanel(layout);

        mainPanel.add(new MenuScreen(layout, mainPanel), "Menu");
        mainPanel.add(new PvPRegisterScreen(layout, mainPanel), "PvP Register Names");
        //mainPanel.add(new GameScreen(layout, mainPanel), "GameScreen");

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
