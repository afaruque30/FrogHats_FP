package mapentities;


import constants.BColor;
import constants.FColor;

public class ShopOwner extends MapEntity {

    public ShopOwner(TileMap map, Location location) {
        super(map, location, FColor.BLACK, '$');
        
    }

    public String render() {
        return BColor.YELLOW.toString() + color.toString() + display;
    }
}
