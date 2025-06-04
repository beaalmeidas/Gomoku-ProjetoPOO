package src.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class CreditsScreen extends BackgroundPanel {
    private CardLayout layout;
    private JPanel mainPanel;

    public CreditsScreen(CardLayout layout, JPanel mainPanel) {
        this.layout = layout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 25));
        titlePanel.setOpaque(false);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel label = new JLabel("Credits");
        label.setFont(new Font("SansSerif", Font.BOLD, 32));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel japaneseLabel = new JLabel("クレジット");
        japaneseLabel.setFont(new Font("Serif", Font.BOLD, 20));
        japaneseLabel.setForeground(Color.WHITE);
        japaneseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        textPanel.add(label);
        textPanel.add(japaneseLabel);

        titlePanel.add(textPanel);

        add(titlePanel, BorderLayout.NORTH);

        JPanel creditsContentPanel = new JPanel();
        creditsContentPanel.setLayout(new BoxLayout(creditsContentPanel, BoxLayout.Y_AXIS));
        creditsContentPanel.setOpaque(true);
        creditsContentPanel.setBackground(new Color(171, 111, 71));
        creditsContentPanel.setBorder(
            BorderFactory.createCompoundBorder(
                new LineBorder(Color.WHITE, 2),
                BorderFactory.createEmptyBorder(5, 20, 5, 20)
            )
        );
        creditsContentPanel.setPreferredSize(new Dimension(550, -1));
        creditsContentPanel.setMaximumSize(new Dimension(550, Integer.MAX_VALUE));
        creditsContentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Font nameFont = new Font("SansSerif", Font.PLAIN, 16);
        Color nameColor = Color.WHITE;
        Color squareColor = Color.WHITE;

        JLabel projectDescriptionLabel = new JLabel(
            "<html><div style='text-align: center;'>"
            + "This Gomoku project was developed as an assignment for the Object-Oriented Programming course."
            + "<br>It aims to replicate the classic game rules in Java, within an intuitive graphical interface."
            + "</div></html>");
        projectDescriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 17));
        projectDescriptionLabel.setForeground(Color.WHITE);
        projectDescriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] memberNames = {
            "Beatriz Almeida de Souza Silva - バイアス",
            "José Carlos de Oliveira Neto - カルリーニョス",
            "Lucas Pontes Amorim - ルーカス",
            "Rigel Sales de Souza - リゲル"
        };

        creditsContentPanel.add(projectDescriptionLabel);
        creditsContentPanel.add(Box.createVerticalStrut(20));

        for (int i = 0; i < memberNames.length; i++) {
            JPanel memberEntryPanel = new JPanel();
            memberEntryPanel.setLayout(new GridBagLayout());
            memberEntryPanel.setOpaque(false);

            GridBagConstraints gbcEntry = new GridBagConstraints();
            gbcEntry.insets = new Insets(0, 0, 0, 10);
            gbcEntry.anchor = GridBagConstraints.CENTER;

            JLabel squareIconLabel = new JLabel("▪");
            squareIconLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
            squareIconLabel.setForeground(squareColor);
            memberEntryPanel.add(squareIconLabel, gbcEntry);

            JLabel nameLabel = new JLabel(memberNames[i]);
            nameLabel.setFont(nameFont);
            nameLabel.setForeground(nameColor);
            gbcEntry.gridx = 1;
            gbcEntry.weightx = 1.0;
            gbcEntry.fill = GridBagConstraints.HORIZONTAL;
            memberEntryPanel.add(nameLabel, gbcEntry);

            creditsContentPanel.add(memberEntryPanel);
            if (i < memberNames.length - 1) {
                creditsContentPanel.add(Box.createVerticalStrut(5));
            }
        }

        creditsContentPanel.add(Box.createVerticalStrut(20));

        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setOpaque(false);
        centerWrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        centerWrapper.add(creditsContentPanel, gbc);

        add(centerWrapper, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Menu");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        backButton.setPreferredSize(new Dimension(200, 40));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        backButton.setBackground(new Color(171, 111, 71));
        backButton.setForeground(Color.WHITE);

        backButton.addActionListener(e -> {
            this.layout.show(this.mainPanel, "Menu");
        });

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 50));
        southPanel.setOpaque(false);
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        southPanel.add(backButton);

        add(southPanel, BorderLayout.SOUTH);
    }
}
