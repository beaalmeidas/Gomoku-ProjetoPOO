package src.models.player;
import src.models.enums.PlayerTypesEnum;
import src.models.enums.PieceColorsEnum;


public abstract class Player {
    protected PlayerTypesEnum playerType;
    protected PieceColorsEnum pieceColor;
    protected String name;

    public String getName() {
        return name;
    }

    public PieceColorsEnum getPieceColor() {
        return pieceColor;
    }

    public PlayerTypesEnum getPlayerType() {
        return playerType;
    }
}
