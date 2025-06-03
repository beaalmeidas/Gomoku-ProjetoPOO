package src.models.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import src.models.enums.PieceColorsEnum;
import src.models.enums.PlayerTypesEnum;

import src.models.gaming.Board;


public class BotPlayer extends Player{
    private final Random randomNumber = new Random();

    public BotPlayer(PieceColorsEnum pieceColor) {
        this.name = "Bot";
        this.pieceColor = pieceColor;
        this.playerType = PlayerTypesEnum.BOT;
    }

    public int[] botMove(Board board) {
        int[] winningMove = findBestMove(board, this.pieceColor, 4);
    }

    /*
        targetColor = oppponent color
        count = for counting pieces of the same color in a row
    */
    public int[] findBestMove(Board board, PieceColorsEnum targetColor, int count) {
        for (int row = 0; row < Board.SIZE; row++)  {
            for (int col = 0; col < Board.SIZE; col++) {
                if (board.getCell(row, col) != null) continue; // verifying if cell is already full

                board.setCell(row, col, targetColor);

                boolean isGoodMove = board.countInAllDirections(row, col, targetColor) == count + 1;

                board.setCell(row, col, null);

                if (isGoodMove) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

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
            return candidates.get(rand.nextInt(candidates.size()));
        }

        // fallback: completamente aleatório
        int row, col;
        do {
            row = rand.nextInt(Board.SIZE);
            col = rand.nextInt(Board.SIZE);
        } while (board.getCell(row, col) != null);
        return new int[]{row, col};
    }

    private boolean hasNearbyPiece(Board board, int row, int col, PieceColorsEnum color) {
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                int r = row + dr;
                int c = col + dc;
                if (r >= 0 && r < Board.SIZE && c >= 0 && c < Board.SIZE) {
                    if (board.getCell(r, c) == color) return true;
                }
            }
        }
        return false;
    }

    /*
    public int[] botMove(Board board) {
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(Board.SIZE);
            col = rand.nextInt(Board.SIZE);
        } while (board.getCell(row, col) != null);
        return new int[]{row, col};
    }
    */
}
