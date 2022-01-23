package mapentities;

import constants.BColor;
import constants.FColor;

public class Apple extends MapEntity {

    public Apple(TileMap map, Location location) {
        super(map, location, FColor.RED, 'A');
        
    }

    public String render() {
        return BColor.GREEN.toString() + color.toString() + display;
    }
}
