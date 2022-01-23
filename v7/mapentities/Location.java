package mapentities;

public class Location {
    public int row;
    public int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Location location) {
        return this.row == location.row && this.col == location.col;
    }
}
