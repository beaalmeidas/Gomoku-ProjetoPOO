package src.models.gaming;


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
        int count;

        count = 1 + countDirection(board, line, column, piece, 0, 1) + countDirection(board, line, column, piece, 0, -1);
        if (count >= 5) return true;

        count = 1 + countDirection(board, line, column, piece, 1, 0) + countDirection(board, line, column, piece, -1, 0);
        if (count >= 5) return true;

        count = 1 + countDirection(board, line, column, piece, 1, 1) + countDirection(board, line, column, piece, -1, -1);
        if (count >= 5) return true;

        count = 1 + countDirection(board, line, column, piece, 1, -1) + countDirection(board, line, column, piece, -1, 1);
        if (count >= 5) return true;

        return false;
    }

    private static int countDirection(Board board, int startLine, int startCol, Piece piece, int dx, int dy) {
        int count = 0;
        int x = startLine + dx;
        int y = startCol + dy;

        while (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            Piece current = board.getCell(x, y);
            if (current != null && current.equals(piece)) {
                count++;
                x += dx;
                y += dy;
            } else {
                break;
            }
        }
        return count;
    }
}
