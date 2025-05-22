package src.models.player;

import src.models.enums.PieceColorsEnum;
import src.models.player.Player;


public class ComputerPlayer {
    private String name COMPUTER_NAME = 'Computer';
    private PieceColorsEnum pieceColor;

    public ComputerPlayer(String name, PieceColorsEnum pieceColor) {
        this.name = name;
        this.pieceColor = pieceColor;
    }
}
