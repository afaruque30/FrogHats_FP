package mapentities;

import classes.Shop;
import constants.BColor;
import constants.FColor;

public class ShopOwner extends MapEntity {
    private Shop content;

    public ShopOwner(TileMap map, Location location) {
        super(map, location, FColor.BLACK, '$');
        content = new Shop();
    }

    public String render() {
        return BColor.YELLOW.toString() + color.toString() + display;
    }
}
