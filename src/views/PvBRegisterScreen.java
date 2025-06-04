package src.views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import src.models.enums.PieceColorsEnum;
import src.models.player.HumanPlayer;


public class PvBRegisterScreen extends BackgroundPanel {
    private CardLayout layout;
    private JPanel mainPanel;

    public PvBRegisterScreen(CardLayout layout, JPanel mainPanel) {
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

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
        titlePanel.setOpaque(false);
        JLabel titleLabel = new JLabel("Player VS Bot");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel contentGridPanel = new JPanel(new GridBagLayout());
        contentGridPanel.setOpaque(false);
        contentGridPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL; 

        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.anchor = GridBagConstraints.WEST;
        JLabel playerNameLabel = new JLabel("Enter your name:");
        playerNameLabel.setFont(labelFont);
        playerNameLabel.setForeground(textColor);
        contentGridPanel.add(playerNameLabel, gbc);

        gbc.gridx = 1; 
        gbc.gridy = 0; 
        gbc.anchor = GridBagConstraints.WEST;
        JTextField playerName = new JTextField();
        playerName.setFont(inputFont);
        playerName.setBackground(inputBgColor);
        playerName.setForeground(inputFgColor);
        playerName.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        playerName.setPreferredSize(new Dimension(200, 50)); 
        contentGridPanel.add(playerName, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.anchor = GridBagConstraints.WEST;
        JLabel playerColorLabel = new JLabel("Choose color:");
        playerColorLabel.setFont(labelFont);
        playerColorLabel.setForeground(textColor);
        contentGridPanel.add(playerColorLabel, gbc);

        gbc.gridx = 1; 
        gbc.gridy = 1; 
        gbc.anchor = GridBagConstraints.WEST;
        JComboBox<PieceColorsEnum> playerColor = new JComboBox<>(PieceColorsEnum.values());
        playerColor.setFont(inputFont);
        playerColor.setBackground(inputBgColor);
        playerColor.setForeground(inputFgColor);
        playerColor.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        playerColor.setPreferredSize(new Dimension(200, 50));
        contentGridPanel.add(playerColor, gbc);

        add(contentGridPanel, BorderLayout.CENTER);

        JPanel actionButtonsPanel = new JPanel();
        actionButtonsPanel.setLayout(new BoxLayout(actionButtonsPanel, BoxLayout.Y_AXIS));
        actionButtonsPanel.setOpaque(false);
        actionButtonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JPanel startGameButtonWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        startGameButtonWrapper.setOpaque(false);
        JButton startGameButton = new JButton("Start Game");
        startGameButton.setFont(buttonFont);
        startGameButton.setPreferredSize(new Dimension(250, 50));
        startGameButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startGameButton.setFocusPainted(false);
        startGameButton.setBorder(new LineBorder(buttonFgColor, 2, true));
        startGameButton.setBackground(buttonBgColor);
        startGameButton.setForeground(buttonFgColor);
        startGameButtonWrapper.add(startGameButton);
        actionButtonsPanel.add(startGameButtonWrapper);

        actionButtonsPanel.add(Box.createVerticalStrut(10));

        JPanel backButtonWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButtonWrapper.setOpaque(false);
        JButton backButton = new JButton("Back to Menu");
        backButton.setFont(buttonFont);
        backButton.setPreferredSize(new Dimension(200, 40));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setBorder(new LineBorder(buttonFgColor, 2, true));
        backButton.setBackground(buttonBgColor);
        backButton.setForeground(buttonFgColor);
        backButtonWrapper.add(backButton);
        actionButtonsPanel.add(backButtonWrapper);

        add(actionButtonsPanel, BorderLayout.SOUTH);

        startGameButton.addActionListener(e -> {
            String name = playerName.getText().trim();
            PieceColorsEnum color = (PieceColorsEnum) playerColor.getSelectedItem();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "You have to enter a name.");
                return;
            }
            if (color == null) {
                JOptionPane.showMessageDialog(this, "Você precisa escolher uma cor para sua peça.");
                return;
            }

            HumanPlayer player1 = new HumanPlayer(name, color);
            HumanPlayer player2 = new HumanPlayer(name, color);

            GameScreen game = new GameScreen(layout, mainPanel, player1, player2);
            mainPanel.add(game, "GameScreen");
            layout.show(mainPanel, "GameScreen");
        });

        backButton.addActionListener(e -> {
            layout.show(mainPanel, "Menu");
        });
    }
}
