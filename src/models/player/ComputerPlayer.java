package src.models.player;

import src.models.enums.PieceColorsEnum;
import src.models.player.Player;


public class ComputerPlayer extends Player{
    public ComputerPlayer(PieceColorsEnum pieceColor) {
        this.name = "Computer";
        this.pieceColor = pieceColor;
    }
}
