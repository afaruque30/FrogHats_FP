package mapentities;

import constants.FColor;

public class MapEntity {
    protected TileMap map;
    protected Location location;
    protected FColor color;
    protected char display;
    

    public MapEntity(TileMap map, Location location, FColor color, char display) {
        this.map      = map;
        this.location = location;
        this.color    = color;
        this.display  = display;
    }

    public Location getLocation() {
        return this.location;
    }

    public String render() {
        return map.getTile(location.row, location.col).getBackground().toString() + color.toString() + display;
    }
}
