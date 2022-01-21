package mapentities;

import classes.Monster;
import constants.BColor;
import constants.FColor;

public class EnemyBoss extends MapEntity {
    private Monster content;

    public EnemyBoss(TileMap map, Location location, Monster[] monsterTable) {
        super(map, location, FColor.PURPLE, 'B');
        content = monsterTable[(int) (Math.random() * monsterTable.length)];
    }

    public String render() {
        return BColor.BLACK.toString() + color.toString() + display;
    }
}