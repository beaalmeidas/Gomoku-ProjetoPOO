package src.views;

import javax.swing.*;
import java.awt.*;


public class MenuScreen extends BackgroundPanel {
    private CardLayout layout;
    private JPanel mainPanel;
    private PvPRegisterScreen pvpRegisterScreen;

    public MenuScreen(CardLayout layout, JPanel mainPanel, PvPRegisterScreen pvpRegisterScreen) {
        setLayout(new BorderLayout());
        this.layout = layout;
        this.mainPanel = mainPanel;
        this.pvpRegisterScreen = pvpRegisterScreen;

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 40));
        titlePanel.setOpaque(false);

        ImageIcon icon = new ImageIcon(getClass().getResource("/assets/gomoku-logo.png"));
        Image img = icon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        JLabel iconLabel = new JLabel(icon);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel label = new JLabel("GOMOKU");
        label.setFont(new Font("SansSerif", Font.BOLD, 32));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel japaneseLabel = new JLabel("五目並べ");
        japaneseLabel.setFont(new Font("Serif", Font.BOLD, 20));
        japaneseLabel.setForeground(Color.WHITE);
        japaneseLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        textPanel.add(label);
        textPanel.add(japaneseLabel);

        titlePanel.add(iconLabel);
        titlePanel.add(textPanel);

        add(titlePanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setOpaque(false);

        String[] buttonLabels = {
            "Player vs Player", "Player vs Bot", "Scoreboard", "Credits", "Leave Game"
        };

        for (String text : buttonLabels) {
            JButton button = new JButton(text);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
            button.setBackground(Color.WHITE);
            button.setForeground(Color.BLACK);
            button.setFont(new Font("SansSerif", Font.BOLD, 16));
            button.setPreferredSize(new Dimension(200, 40));
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));

            if (text.equals("Leave Game")) {
                button.addActionListener(e -> System.exit(0));
            } else if (text.equals("Player vs Player")) {
                button.addActionListener(e -> {
                    pvpRegisterScreen.resetFields();
                    layout.show(mainPanel, "PvP Register Names");
                });
            } else if (text.equals("Player vs Bot")) {
                button.addActionListener(e -> {
                    pvpRegisterScreen.resetFields();
                    layout.show(mainPanel, "PvB Register Name");
                });
            } else if (text.equals("Scoreboard")) {
                button.addActionListener(e -> {
                    mainPanel.remove(mainPanel.getComponent(3)); // Remove Scoreboard antigo (índice fixo)
                    mainPanel.add(new ScoreboardScreen(layout, mainPanel), "Scoreboard");
                    layout.show(mainPanel, "Scoreboard");
                });
            } else if (text.equals("Credits")) {
                button.addActionListener(e -> layout.show(mainPanel, "CreditsScreen"));
            }

            buttonPanel.add(button);
        }

        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setOpaque(false);
        centerWrapper.add(buttonPanel); 

        add(centerWrapper, BorderLayout.CENTER);
    }
}
