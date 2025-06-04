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

        PvPRegisterScreen pvpRegisterScreen = new PvPRegisterScreen(layout, mainPanel);
        MenuScreen menuScreen = new MenuScreen(layout, mainPanel, pvpRegisterScreen);

        mainPanel.add(menuScreen, "Menu");
        mainPanel.add(pvpRegisterScreen, "PvP Register Names");
        mainPanel.add(new PvBRegisterScreen(layout, mainPanel), "PvB Register Name");
        mainPanel.add(new CreditsScreen(layout, mainPanel), "CreditsScreen");

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

