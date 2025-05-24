//package src.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuScreen extends JPanel{
    public MenuScreen(CardLayout layout, JPanel mainPanel) {
        JLabel label = new JLabel("GOMOKU");

        JButton playerVsPlayerButton = new JButton("Player vs Player");
        JButton playerVsBotButton = new JButton("Player vs Bot");
        JButton scoreboardButton = new JButton("Scoreboard");
        JButton creditsButton = new JButton("Credits");
        JButton leaveGameButton = new JButton("Leave Game");

        playerVsPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(mainPanel, "Teste");
            }
        });

        playerVsBotButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(mainPanel, "Teste");
            }
        });

        scoreboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(mainPanel, "Teste");
            }
        });

        creditsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(mainPanel, "Teste");
            }
        });

        leaveGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(label);
        add(playerVsPlayerButton);
        add(playerVsBotButton);
        add(scoreboardButton);
        add(creditsButton);
        add(leaveGameButton);
    }
}
