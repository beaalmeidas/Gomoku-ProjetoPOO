package src.models.gaming;

import src.models.player.*;


public class Match {
    Player player1;
    Player player2;
    Board board;
    Player currentPlayer;

    public Match(Player p1, Player p2, Board board) {
        this.player1 = p1;
        this.player2 = p2;
        this.board = board;
        this.currentPlayer = player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
