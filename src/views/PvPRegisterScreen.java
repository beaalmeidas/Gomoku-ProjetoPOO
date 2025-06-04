package src.views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import src.models.enums.PieceColorsEnum;
import src.models.player.HumanPlayer;

public class PvPRegisterScreen extends BackgroundPanel {
    private CardLayout layout;
    private JPanel mainPanel;

    public PvPRegisterScreen(CardLayout layout, JPanel mainPanel) {
        this.layout = layout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());

        Font labelFont = new Font("SansSerif", Font.BOLD, 18);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 18);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 18);
        Color textColor = Color.WHITE;
        Color inputBgColor = Color.WHITE;
        Color inputFgColor = Color.BLACK;
        Color buttonBgColor = new Color(171, 111, 71, 180);
        Color buttonFgColor = Color.WHITE;

        JTextField player1NameField = new JTextField();
        JTextField player2NameField = new JTextField();
        JComboBox<PieceColorsEnum> player1ColorComboBox = new JComboBox<>(PieceColorsEnum.values());
        JComboBox<PieceColorsEnum> player2ColorComboBox = new JComboBox<>();

        player1ColorComboBox.addActionListener(e -> {
            PieceColorsEnum selected = (PieceColorsEnum) player1ColorComboBox.getSelectedItem();
            player2ColorComboBox.removeAllItems();
            for (PieceColorsEnum color : PieceColorsEnum.values()) {
                if (!color.equals(selected)) {
                    player2ColorComboBox.addItem(color);
                }
            }
            if (player2ColorComboBox.getItemCount() > 0) {
                player2ColorComboBox.setSelectedIndex(0);
            }
        });
        player1ColorComboBox.setSelectedIndex(0);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
        titlePanel.setOpaque(false);
        JLabel titleLabel = new JLabel("Player VS Player");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel contentGridPanel = new JPanel(new GridLayout(4, 2, 20, 20));
        contentGridPanel.setOpaque(false);
        contentGridPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));

        JLabel player1NameLabel = new JLabel("Player 1 Name:");
        player1NameLabel.setFont(labelFont);
        player1NameLabel.setForeground(textColor);
        contentGridPanel.add(player1NameLabel);

        player1NameField.setFont(inputFont);
        player1NameField.setBackground(inputBgColor);
        player1NameField.setForeground(inputFgColor);
        player1NameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        contentGridPanel.add(player1NameField);

        JLabel player1ColorLabel = new JLabel("Player 1 Color:");
        player1ColorLabel.setFont(labelFont);
        player1ColorLabel.setForeground(textColor);
        contentGridPanel.add(player1ColorLabel);

        player1ColorComboBox.setFont(inputFont);
        player1ColorComboBox.setBackground(inputBgColor);
        player1ColorComboBox.setForeground(inputFgColor);
        player1ColorComboBox.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        contentGridPanel.add(player1ColorComboBox);

        JLabel player2NameLabel = new JLabel("Player 2 Name:");
        player2NameLabel.setFont(labelFont);
        player2NameLabel.setForeground(textColor);
        contentGridPanel.add(player2NameLabel);

        player2NameField.setFont(inputFont);
        player2NameField.setBackground(inputBgColor);
        player2NameField.setForeground(inputFgColor);
        player2NameField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        contentGridPanel.add(player2NameField);

        JLabel player2ColorLabel = new JLabel("Player 2 Color:");
        player2ColorLabel.setFont(labelFont);
        player2ColorLabel.setForeground(textColor);
        contentGridPanel.add(player2ColorLabel);

        player2ColorComboBox.setFont(inputFont);
        player2ColorComboBox.setBackground(inputBgColor);
        player2ColorComboBox.setForeground(inputFgColor);
        player2ColorComboBox.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        contentGridPanel.add(player2ColorComboBox);

        add(contentGridPanel, BorderLayout.CENTER);

        JPanel startGameButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        startGameButtonPanel.setOpaque(false);
        startGameButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JButton startGameButton = new JButton("Start Game");
        startGameButton.setFont(buttonFont);
        startGameButton.setPreferredSize(new Dimension(250, 50));
        startGameButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startGameButton.setFocusPainted(false);
        startGameButton.setBorder(new LineBorder(buttonFgColor, 2, true));
        startGameButton.setBackground(buttonBgColor);
        startGameButton.setForeground(buttonFgColor);

        startGameButton.addActionListener(e -> {
            String name1 = player1NameField.getText().trim();
            String name2 = player2NameField.getText().trim();
            PieceColorsEnum color1 = (PieceColorsEnum) player1ColorComboBox.getSelectedItem();
            PieceColorsEnum color2 = (PieceColorsEnum) player2ColorComboBox.getSelectedItem();

            if (name1.isEmpty() || name2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Both players have to enter their names.");
                return;
            }
            if (name1.equalsIgnoreCase(name2)) {
                JOptionPane.showMessageDialog(this, "Please enter different names.");
                return;
            }
            if (color1 == null || color2 == null) {
                JOptionPane.showMessageDialog(this, "Please choose colors for both players.");
                return;
            }
            if (color1.equals(color2)) {
                JOptionPane.showMessageDialog(this, "Players must choose different colors.");
                return;
            }

            HumanPlayer player1 = new HumanPlayer(name1, color1);
            HumanPlayer player2 = new HumanPlayer(name2, color2);

            GameScreen game = new GameScreen(layout, mainPanel, player1, player2);
            mainPanel.add(game, "GameScreen");
            layout.show(mainPanel, "GameScreen");
        });
        startGameButtonPanel.add(startGameButton);

        JButton backButton = new JButton("Back to Menu");
        backButton.setFont(buttonFont);
        backButton.setPreferredSize(new Dimension(200, 40));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setBorder(new LineBorder(buttonFgColor, 2, true));
        backButton.setBackground(buttonBgColor);
        backButton.setForeground(buttonFgColor);

        backButton.addActionListener(e -> {
            layout.show(mainPanel, "Menu");
        });

        JPanel actionButtonsPanel = new JPanel();
        actionButtonsPanel.setLayout(new BoxLayout(actionButtonsPanel, BoxLayout.Y_AXIS));
        actionButtonsPanel.setOpaque(false);
        actionButtonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        actionButtonsPanel.add(startGameButtonPanel);
        actionButtonsPanel.add(Box.createVerticalStrut(10));
        JPanel backButtonWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButtonWrapper.setOpaque(false);
        backButtonWrapper.add(backButton);
        actionButtonsPanel.add(backButtonWrapper);

        add(actionButtonsPanel, BorderLayout.SOUTH);
    }
}