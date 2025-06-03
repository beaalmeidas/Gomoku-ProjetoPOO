package src.models.player;

import src.models.enums.PieceColorsEnum;
import src.models.enums.PlayerTypesEnum;


public class HumanPlayer extends Player {
    protected int victories = 0;
    protected int points = 0;

    public HumanPlayer(String name, PieceColorsEnum pieceColor) {
        this.name = name;
        this.pieceColor = pieceColor;
        this.playerType = PlayerTypesEnum.HUMAN;
    }

    public void setName(String nameInput) {
        this.name = nameInput;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories() {
        victories++;
    }

    public void resetVictories() {
        victories = 0;
    }
}
