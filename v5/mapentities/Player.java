package mapentities;

import constants.FColor;
import constants.Tile;

public class Player extends MapEntity{
    public Player(TileMap map, Location location) {
        super(map, location, FColor.BLUE, 'O');
    }

    public void move(Location delta) {
        move(delta.row, delta.col);
    }

    public void move(int deltaRow, int deltaCol) {
        int newRow = this.location.row + deltaRow;
        int newCol = this.location.col + deltaCol;
        if(this.map.inBounds(newRow, newCol)) {
            if(this.map.getTile(newRow, newCol) != Tile.WALL) { // note to self: change this to deal with other entities
                this.location = new Location(newRow, newCol);
            }
        }
    }
}