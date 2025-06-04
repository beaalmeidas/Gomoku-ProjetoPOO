package src.models.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import src.models.enums.PieceColorsEnum;
import src.models.enums.PlayerTypesEnum;

import src.models.gaming.Board;
import src.models.gaming.Piece;


public class BotPlayer extends Player{
    private final Random randomNumber = new Random();

    public BotPlayer(PieceColorsEnum pieceColor) {
        this.name = "Bot";
        this.pieceColor = pieceColor;
        this.playerType = PlayerTypesEnum.BOT;
    }

    public int[] botMove(Board board) {
        // first, checking if there's 4 bot pieces lined up, which would result in winning
        int[] winningMove = findBestMove(board, this.pieceColor, 4);
        if (winningMove != null) {
            return winningMove;
        }

        // if not, trying to block the player if they have 4 pieces lined up
        PieceColorsEnum opponentColor = (this.pieceColor == PieceColorsEnum.BLACK ? PieceColorsEnum.WHITE : PieceColorsEnum.BLACK);
        int[] blockMove = findBestMove(board, opponentColor, 4);
        if (blockMove != null) {
            return blockMove;
        }
        
        // if not either, trying a random move
        return smartRandomMove(board);
    }

    // targetColor = opponent color
    // count = for counting pieces of the same color in a row
    private int[] findBestMove(Board board, PieceColorsEnum targetColor, int count) {
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                if (board.getCell(row, col) != null) continue;

                board.setCell(row, col, targetColor);

                if (board.countInAllDirections(row, col, targetColor) == count + 1) {
                    board.setCell(row, col, null);
                    return new int[]{row, col};
                }

                board.setCell(row, col, null);
            }
        }
        return null;
    }

    // looks for a good new move, near other bot-placed pieces
    private int[] smartRandomMove(Board board) {
        List<int[]> candidates = new ArrayList<>();

        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                if (board.getCell(row, col) != null) continue;

                if (hasNearbyPiece(board, row, col, this.pieceColor)) {
                    candidates.add(new int[]{row, col});
                }
            }
        }

        if (!candidates.isEmpty()) {
            return candidates.get(randomNumber.nextInt(candidates.size()));
        }

        // completely random move, if no bot-placed pieces are available
        int row, col;
        do {
            row = randomNumber.nextInt(Board.SIZE);
            col = randomNumber.nextInt(Board.SIZE);
        } while (board.getCell(row, col) != null);
        return new int[]{row, col};
    }

    private boolean hasNearbyPiece(Board board, int row, int col, PieceColorsEnum color) {
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) {
                    continue;
                }
                int r = row + dr;
                int c = col + dc;
                if (r >= 0 && r < Board.SIZE && c >= 0 && c < Board.SIZE) {
                    Piece p = board.getCell(r, c);

                    if (p != null && p.getColor() == color) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
