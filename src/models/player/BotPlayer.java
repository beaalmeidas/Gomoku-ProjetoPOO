package src.models.player;

import java.util.Random;

import src.models.enums.PieceColorsEnum;
import src.models.enums.PlayerTypesEnum;

import src.models.gaming.Board;


public class BotPlayer extends Player{
    public BotPlayer(PieceColorsEnum pieceColor) {
        this.name = "Bot";
        this.pieceColor = pieceColor;
        this.playerType = PlayerTypesEnum.BOT;
    }

    public int[] botMove(Board board) {
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(Board.SIZE);
            col = rand.nextInt(Board.SIZE);
        } while (board.getCell(row, col) != null);
        return new int[]{row, col};
    }
}
