package mapentities;

import constants.BColor;
import constants.FColor;

public class Npc extends MapEntity {

    public Npc(TileMap map, Location location) {
        super(map, location, FColor.BLACK, 'N');
        
    }

    public String render() {
        return BColor.WHITE.toString() + color.toString() + display;
    }
}
