package constants;

public enum Tile {
    GRASS (BColor.GREEN,  FColor.YELLOW, ' ', 'G'),
    PATH  (BColor.YELLOW, FColor.BLACK,  ' ', 'Y'),
    WALL  (BColor.WHITE,  FColor.BLUE,   ' ', 'W'),
    DOOR  (BColor.WHITE,  FColor.BLACK,  ' ', 'D'),

    RED (null, FColor.RED, ' ', 'R'),
    
    MONSTER,
    SHOP;

    private final BColor backgroundColor;
    private final FColor textColor;
    private final char   display;
    private final char   key;

    private Tile(BColor backgroundColor, FColor textColor, char display, char key) {
        this.backgroundColor = backgroundColor;
        this.textColor       = textColor;
        this.display         = display;
        this.key             = key;
    }

    private Tile() {
        this.backgroundColor = null;
        this.textColor       = null;
        this.display         = 'n';
        this.key             = 'n';
    }

    public char getKey() {
        return key;
    }

    public BColor getBackground() {
        return backgroundColor;
    }

    public static Tile keyToTile(char key) {
        for (Tile tile : Tile.values()) {
            if (tile.getKey() == key) {
                return tile;
            }
        }
        System.out.println(String.format("%nThere is no key %s.", key));
        return null;
    }

    public String toString() {
        return this.backgroundColor.toString() + this.textColor.toString() + this.display + FColor.RESET;
    }
}
