package src.models.gaming;

import src.models.enums.PieceColorsEnum;
import src.models.gaming.Piece;


public class Board {
    private Piece[][] grid;
    public static final int SIZE = 15;

    public Board() {
        grid = new Piece[SIZE][SIZE];
    }

    public boolean placePiece(Piece piece, int line, int column) {
        if (line < 0 || line >= SIZE || column < 0 || column >= SIZE) {
            return false;
        }
        if (grid[line][column] != null) {
            return false;
        }
        grid[line][column] = piece;
        return true;
    }

    public Piece getCell(int line, int column) {
        if (line < 0 || line >= SIZE || column < 0 || column >= SIZE) {
            return null;
        }
        return grid[line][column];
    }

    public void setCell(int row, int col, PieceColorsEnum color) {
        if (color == null) {
            grid[row][col] = null;
        } else {
            grid[row][col] = new Piece(color);
        }
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void showBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(grid[i][j].getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }

    public static boolean checkForWin(Board board, int line, int column, Piece piece) {
        if (piece == null) {
            return false;
        }

        PieceColorsEnum color = piece.getColor();
        int count;

        count = board.countDirection(line, column, 0, 1, color) + board.countDirection(line, column, 0, -1, color) + 1;
        if (count >= 5) return true;

        count = board.countDirection(line, column, 1, 0, color) + board.countDirection(line, column, -1, 0, color) + 1;
        if (count >= 5) return true;

        count = board.countDirection(line, column, 1, 1, color) + board.countDirection(line, column, -1, -1, color) + 1;
        if (count >= 5) return true;

        count = board.countDirection(line, column, 1, -1, color) + board.countDirection(line, column, -1, 1, color) + 1;
        if (count >= 5) return true;

        return false;
    }

    public int countInAllDirections(int row, int col, PieceColorsEnum color) {
        return Math.max(
            Math.max(countDirection(row, col, 1, 0, color), countDirection(row, col, 0, 1, color)), // linha e coluna
            Math.max(countDirection(row, col, 1, 1, color), countDirection(row, col, 1, -1, color)) // diagonais
        );
    }

    private int countDirection(int row, int col, int dRow, int dCol, PieceColorsEnum color) {
        int count = 1;

        int r = row + dRow, c = col + dCol;
        while (
            r >= 0 && r < SIZE &&
            c >= 0 && c < SIZE &&
            getCell(r, c) != null &&
            getCell(r, c).getColor() == color
        ) {
            count++;
            r += dRow;
            c += dCol;
        }

        r = row - dRow;
        c = col - dCol;
        while (
            r >= 0 && r < SIZE &&
            c >= 0 && c < SIZE &&
            getCell(r, c) != null &&
            getCell(r, c).getColor() == color
        ) {
            count++;
            r -= dRow;
            c -= dCol;
        }

        return count;
    }

    // private static int countDirection(Board board, int startLine, int startCol, Piece piece, int dx, int dy) {
    //     int count = 0;
    //     int x = startLine + dx;
    //     int y = startCol + dy;

    //     while (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
    //         Piece current = board.getCell(x, y);
    //         if (current != null && current.equals(piece)) {
    //             count++;
    //             x += dx;
    //             y += dy;
    //         } else {
    //             break;
    //         }
    //     }
    //     return count;
    // }
}
