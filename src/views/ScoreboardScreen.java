package src.views;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import src.models.gaming.Scoreboard;
import src.models.player.HumanPlayer;


public class ScoreboardScreen extends BackgroundPanel {
    public ScoreboardScreen(CardLayout layout, JPanel mainPanel) {
        setLayout(new BorderLayout(20, 20));

        JLabel title = new JLabel("Scoreboard");
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(title, BorderLayout.NORTH);

        String[] columns = {"Player Name", "Victories"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<HumanPlayer> players = Scoreboard.getPlayers();
        for (HumanPlayer player : players) {
            Object[] row = {player.getName(), player.getVictories()};
            tableModel.addRow(row);
        }

        JTable table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setFont(new Font("SansSerif", Font.PLAIN, 18));
        table.setForeground(new Color(50, 30, 0)); 

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        table.getTableHeader().setBackground(new Color(171, 111, 71));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(171, 111, 71), 3));
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Menu");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(171, 111, 71));
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setPreferredSize(new Dimension(150, 50));
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        backButton.addActionListener(e -> layout.show(mainPanel, "Menu"));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); 
        buttonPanel.add(backButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
