package mapentities;

import constants.BColor;
import constants.FColor;

public class Sheep extends MapEntity {

    public Sheep(TileMap map, Location location) {
        super(map, location, FColor.BLACK, 'S');
        
    }

    public String render() {
        return BColor.WHITE.toString() + color.toString() + display;
    }
}
