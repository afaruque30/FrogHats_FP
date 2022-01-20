import java.util.ArrayList;
import java.util.Scanner;

import classes.Monster;
import constants.Floor;
import constants.Tile;
import mapentities.*;
import classes.*;
import music.*;

public class Driver {
    Protagonist protag = new Protagonist();

    public static TileMap loadMap(Floor floor) {
        TileMap map = new TileMap(floor.getStart(), floor.getEnd());
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
    public static boolean check(Driver driver, Player player, TileMap map, Thread thread, Protagonist protag) {
        for (MapEntity o : map.entities) {
            if (player.getLocation().equals(o.getLocation()) && o instanceof Enemy) {

                var x = o.getLocation().col;
                var y = o.getLocation().row;

                thread.interrupt();
                Battle.perform(protag);
                

                map.remove(o);
                map.map[y][x] = Tile.keyToTile('Y');
                map.add(player);
                return true;

            }
            if (player.getLocation().equals(o.getLocation()) && !(o instanceof Enemy) && !(o instanceof Player)) {
                thread.interrupt();
                Shop.purchase(protag);
                
                return true;

            }

        }
        return false;
    }
    public static void main(String[] args) {
        var e = true;
        Driver driver = new Driver();
        ClipControl runner = new ClipControl();
        driver.protag.giveCoins(1000);
        Menu menu = new Menu();
        ClassPrestiges classes = new ClassPrestiges();
        runner.setSong(0);
        try {
            runner.load();
        } catch (Exception el) {
            //TODO: handle exception
        }
        Thread thread = new Thread(runner);
        thread.start();
        menu.load(thread);

        classes.pickAClass(driver);;

        int currLevel = 0;
        TileMap[] maps = {loadMap(Floor.ONE), loadMap(Floor.TWO), loadMap(Floor.THREE)};
        TileMap map = maps[currLevel];
        Player player = new Player(map, map.start);

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
            if(player.getLocation().equals(map.end) && currLevel != 2) {
                map.entities.remove(player);
                currLevel++;
                map = maps[currLevel];
                player = new Player(map, map.start);
                map.add(player);
                player.move(0, 1);
            }
            if(player.getLocation().equals(map.start) && currLevel != 0) {
                map.entities.remove(player);
                currLevel--;
                map = maps[currLevel];
                player = new Player(map, map.end);
                map.add(player);
                player.move(0, -1);
            }

            //horribly inefficient and just bad design overall

            // if (map.entities.size() == 2) { UNLOCK NEW LEVEL
            //     e = false;
            // }
                    // map.remove(map.entities.get(i));
                    // map.map[4][4] = Tile.keyToTile('Y');

            if(check(driver, player, map, thread, driver.protag)) {
                runner = new ClipControl();
                
                runner.setSong(0);
                try {
                    runner.load();
                } catch (Exception el) {
                    //TODO: handle exception
                }
                thread = new Thread(runner);
                thread.start();
            }
        }
        // thread.interrupt();

    }
}
