package src.views;

import java.awt.*;
import javax.swing.*;
import java.net.URL;

import src.models.enums.PieceColorsEnum;
import src.models.gaming.Board;
import src.models.gaming.Match;
import src.models.gaming.Piece;
import src.models.player.Player;


public class GameScreen extends BackgroundPanel {
    private Board board;
    private Match match;
    private JButton[][] buttons;
    private JLabel turnLabel;
    private ImageIcon blackIcon;
    private ImageIcon whiteIcon;

    public GameScreen(CardLayout layout, JPanel mainPanel, Player p1, Player p2) {
        setLayout(new BorderLayout());

        this.board = new Board();
        this.match = new Match(p1, p2, board);
        this.buttons = new JButton[Board.SIZE][Board.SIZE];

        // BLACK ICON
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/assets/black-piece-icon.png"));
        Image scaledBlackImage = icon1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        blackIcon = new ImageIcon(scaledBlackImage);
        
        // WHITE ICON
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/assets/white-piece-icon.png"));
        Image scaledWhiteImage = icon2.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        whiteIcon = new ImageIcon(scaledWhiteImage);
        
        // TOP PANEL WITH TURN INDICATION AND LEAVE BUTTON
        turnLabel = new JLabel("Turn: " + match.getCurrentPlayer().getName());
        turnLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        JButton leaveButton = new JButton("Leave Game");
        leaveButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        leaveButton.addActionListener(e -> layout.show(mainPanel, "Menu"));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(turnLabel, BorderLayout.WEST);
        topPanel.add(leaveButton, BorderLayout.EAST);
        topPanel.setOpaque(false);

        add(topPanel, BorderLayout.NORTH);

        // GRID PANEL
        JPanel gridPanel = new JPanel(new GridLayout(Board.SIZE, Board.SIZE));
        gridPanel.setBackground(Color.MAGENTA);

        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(60, 60));
                btn.setFocusPainted(false);
                final int row = i, col = j;
                btn.addActionListener(e -> handleMove(row, col, btn));
                buttons[i][j] = btn;
                gridPanel.add(btn);
            }
        }

        add(gridPanel, BorderLayout.CENTER);
    }

    private void handleMove(int row, int col, JButton btn) {
        Player current = match.getCurrentPlayer();
        Piece piece = new Piece(current.getPieceColor(), current, row, col);

        if (board.placePiece(piece, row, col)) {
            btn.setText("");
            if (current.getPieceColor() == PieceColorsEnum.BLACK) {
                btn.setIcon(blackIcon);
            } else {
                btn.setIcon(whiteIcon);
            }

            btn.setEnabled(false);

            if (Board.checkForWin(board, row, col, piece)) {
                JOptionPane.showMessageDialog(this, current.getName() + " wins!");
                disableBoard();
            } else {
                match.switchPlayer();
                turnLabel.setText("Turn: " + match.getCurrentPlayer().getName());
            }
        }
    }

    private void disableBoard() {
        for (JButton[] row : buttons)
            for (JButton btn : row)
                btn.setEnabled(false);
    }
}
