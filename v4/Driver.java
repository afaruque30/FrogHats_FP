import java.util.Scanner;

import classes.Monster;
import constants.Floor;
import constants.Tile;
import mapentities.Enemy;
import mapentities.Location;
import mapentities.Player;
import mapentities.ShopOwner;
import mapentities.TileMap;
import classes.*;

public class Driver {
    Protagonist protag = new Protagonist();

    public static TileMap loadMap(Floor floor) {
        TileMap map = new TileMap();
        map.load(floor.getFilename());
        for (Object[] entity : floor.getEntities()) {
            switch ((Tile) entity[1]) {
                case MONSTER:
                    map.add(new Enemy(map, (Location) entity[0], (Monster[]) entity[2]));
                    break;
                case SHOP:
                    map.add(new ShopOwner(map, (Location) entity[0]));
                    break;
                default:
            }
        }
        return map;
    }

    public static void main(String[] args) {
        var e = true;
        Driver driver = new Driver();
        ClipControl runner = new ClipControl();
        Menu menu = new Menu();
        ClassPrestiges classes = new ClassPrestiges();
        runner.setSong(0);
        Thread thread = new Thread(runner);
        thread.start();
        menu.load();
        classes.pickAClass(driver);;
        
        TileMap map = loadMap(Floor.ONE);
        Player player = new Player(map, new Location(9, 2));
        
        map.add(player);
        while (e) {
            map.render();
            Scanner in = new Scanner(System.in);
            switch (in.nextLine()) {
                case "w":
                    player.move(-1, 0);
                    break;
                case "a":
                    player.move(0, -1);
                    break;
                case "s":
                    player.move(1, 0);
                    break;
                case "d":
                    player.move(0, 1);
                    break;
                case "exit":
                    e = false;
                    break;
                    
                default:
            }
            if (player.getLocation().equals(map.entities.get(0).getLocation())) map.entities.remove(0);
        }
        thread.interrupt();
       
    }
}