package src.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import src.models.gaming.Scoreboard;
import src.models.player.HumanPlayer;


public class ScoreboardScreen extends JPanel {
    public ScoreboardScreen(CardLayout layout, JPanel mainPanel) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Scoreboard");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        String[] columns = {"Player Name", "Victories"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        List<HumanPlayer> players = Scoreboard.getPlayers();
        for (HumanPlayer player : players) {
            Object[] row = {player.getName(), player.getVictories()};
            tableModel.addRow(row);
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener(e -> layout.show(mainPanel, "Menu"));
        add(backButton, BorderLayout.SOUTH);
    }
}