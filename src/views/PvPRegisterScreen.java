package src.views;

import javax.swing.*;
import java.awt.*;

import src.models.enums.PieceColorsEnum;
import src.models.player.HumanPlayer;


public class PvPRegisterScreen extends JPanel {
    public PvPRegisterScreen(CardLayout layout, JPanel mainPanel) {
        setLayout(new GridLayout(5, 2, 10, 10));

        JTextField player1Name = new JTextField();
        JTextField player2Name = new JTextField();

        JComboBox<PieceColorsEnum> player1Color = new JComboBox<>(PieceColorsEnum.values());
        JComboBox<PieceColorsEnum> player2Color = new JComboBox<>(PieceColorsEnum.values());

        player1Color.addActionListener(e -> {
            PieceColorsEnum selected = (PieceColorsEnum) player1Color.getSelectedItem();
            player2Color.removeAllItems();
            for (PieceColorsEnum color : PieceColorsEnum.values()) {
                if (!color.equals(selected)) {
                    player2Color.addItem(color);
                }
            }
        });

        player1Color.setSelectedIndex(0);

        add(new JLabel("Enter Player 1's name:"));
        add(player1Name);

        add(new JLabel("Choose color:"));
        add(player1Color);

        add(new JLabel("Enter Player 2's name:"));
        add(player2Name);

        add(new JLabel("Choose color:"));
        add(player2Color);

        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(e -> {
            String name1 = player1Name.getText().trim();
            String name2 = player2Name.getText().trim();
            PieceColorsEnum color1 = (PieceColorsEnum) player1Color.getSelectedItem();
            PieceColorsEnum color2 = (PieceColorsEnum) player2Color.getSelectedItem();

            if (name1.isEmpty() || name2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Both players have to enter their names.");
                return;
            }

            HumanPlayer player1 = new HumanPlayer(name1, color1);
            HumanPlayer player2 = new HumanPlayer(name2, color2);

            GameScreen game = new GameScreen(layout, mainPanel, player1, player2);
            mainPanel.add(game, "GameScreen");
            layout.show(mainPanel, "GameScreen");
        });

        add(new JLabel());
        add(startGameButton);
    }
}
