package mapentities;

import constants.BColor;
import constants.FColor;

public class GoodGuard extends MapEntity {

    public GoodGuard(TileMap map, Location location) {
        super(map, location, FColor.BLACK, 'G');
        
    }

    public String render() {
        return BColor.PURPLE.toString() + color.toString() + display;
    }
}
