import java.awt.*;

import javax.swing.*;

import src.models.enums.PieceColorsEnum;
import src.models.gaming.Board;
import src.models.gaming.Match;
import src.models.gaming.Piece;
import src.models.player.Player;


public class GameScreen extends BackgroundPanel {
    private Board board;
    private Match match;
    private JButton[][] buttons;

    public GameScreen(CardLayout layout, JPanel mainPanel, Player p1, Player p2) {
        setLayout(new BorderLayout());

        this.board = new Board();
        this.match = new Match(p1, p2, board);
        this.buttons = new JButton[Board.SIZE][Board.SIZE];

        JPanel gridPanel = new JPanel(new GridLayout(Board.SIZE, Board.SIZE));
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(40, 40));
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
            btn.setText(current.getPieceColor() == PieceColorsEnum.BLACK ? "●" : "○");
            btn.setEnabled(false);

            if (Board.checkForWin(board, row, col, piece)) {
                JOptionPane.showMessageDialog(this, current.getName() + " wins!");
                disableBoard();
            } else {
                match.switchPlayer();
            }
        }
    }

    private void disableBoard() {
        for (JButton[] row : buttons)
            for (JButton btn : row)
                btn.setEnabled(false);
    }
}
