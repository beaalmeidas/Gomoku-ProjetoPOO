package src.models.player;

import src.models.enums.PieceColorsEnum;
import src.models.enums.PlayerTypesEnum;


public class BotPlayer extends Player{
    public BotPlayer(PieceColorsEnum pieceColor) {
        this.name = "Bot";
        this.pieceColor = pieceColor;
        this.playerType = PlayerTypesEnum.BOT;
    }

    public int botMove(int line, int column) {
        // implementar
    }
}
