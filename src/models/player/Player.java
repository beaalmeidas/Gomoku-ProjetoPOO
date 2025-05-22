package src.models.player;
import src.models.enums.PlayerTypesEnum;


public abstract class Player {
    private PlayerTypesEnum playerType;
    int points;

    public abstract void getPoints();
    public abstract void setPoints();
}
