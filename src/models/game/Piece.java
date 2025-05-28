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
}
