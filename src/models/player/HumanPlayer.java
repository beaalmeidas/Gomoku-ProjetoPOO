package src.models.player;

import src.models.enums.PieceColorsEnum;
import src.models.player.Player;


public class HumanPlayer extends Player {
    private String name;
    private PieceColorsEnum pieceColor;

    public HumanPlayer(String name, PieceColorsEnum pieceColor) {
        this.name = name;
        this.pieceColor = pieceColor;
    }

    // fazer a logica de todos esses
    public void getPoints();
    
    public void setPoints();
    
    public void getName();
    
    public void setName();

    public int playerMove(int line, int column);
}
