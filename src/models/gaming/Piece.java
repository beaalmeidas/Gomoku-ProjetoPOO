package src.models.gaming;

import src.models.enums.PieceColorsEnum;
import src.models.player.Player;


public class Piece {
    private PieceColorsEnum color;
    private Player owner;
    private int line;
    private int column;

    public Piece(PieceColorsEnum color, Player owner, int line, int column) {
        this.color = color;
        this.owner = owner;
        this.line = line;
        this.column = column;
    }

    /*
        Auxilary constructor so an instance
    */
    public Piece(PieceColorsEnum color) {
        this.color = color;
        this.owner = null;
        this.line = -1;
        this.column = -1;
    }

    public PieceColorsEnum getColor() {
        return color;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public String getSymbol() {
        if (color == PieceColorsEnum.BLACK) {
            return "A";
        } else if (color == PieceColorsEnum.WHITE) {
            return "○";
        }
        return "?";
    }

    /*
        Overriding default 'equals' method to make it so java considers 2 or more pieces with the same color equal
        If this isn't implemented, java will always think pieces of the same color are different
    */ 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Piece other = (Piece) obj;
        return color == other.color;
    }
}
