package src.views;

import javax.swing.*;

import src.models.enums.PieceColorsEnum;
import src.models.player.HumanPlayer;

import java.awt.*;

public class PvBRegisterScreen extends JPanel {
    public PvBRegisterScreen(CardLayout layout, JPanel mainPanel) {
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Enter your name:"));
        JTextField playerName = new JTextField();
        add(playerName);

        add(new JLabel("Choose color:"));
        JComboBox<PieceColorsEnum> playerColor = new JComboBox<>(PieceColorsEnum.values());
        add(playerColor);

        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(e -> {
            String name = playerName.getText().trim();
            PieceColorsEnum color = (PieceColorsEnum) playerColor.getSelectedItem();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "You have to enter a name.");
                return;
            }

            HumanPlayer player1 = new HumanPlayer(name, color);
            HumanPlayer player2 = new HumanPlayer(name, color);

            GameScreen game = new GameScreen(layout, mainPanel, player1, player2);
            mainPanel.add(game, "GameScreen");
            layout.show(mainPanel, "GameScreen");
        });

        add(new JLabel());
        add(startGameButton);
    }
}
