package mapentities;

import classes.Monster;
import constants.BColor;
import constants.FColor;

public class Enemy extends MapEntity {
    private Monster content;

    public Enemy(TileMap map, Location location, Monster[] monsterTable) {
        super(map, location, FColor.RED, 'M');
        content = monsterTable[(int) (Math.random() * monsterTable.length)];
    }

    public String render() {
        return BColor.BLACK.toString() + color.toString() + display;
    }
}