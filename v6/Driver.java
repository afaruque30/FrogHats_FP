import java.util.ArrayList;
import java.util.Scanner;

import classes.Monster;
import constants.Floor;
import constants.Tile;
import mapentities.*;
import classes.*;
import music.*;

public class Driver {
    boolean e = true;
    Protagonist protag = new Protagonist();

    public static TileMap loadMap(Floor floor) {
        TileMap map = new TileMap(floor.getStart(), floor.getEnd());
        map.load(floor.getFilename());
        for (Object[] entity : floor.getEntities()) {
            switch ((Tile) entity[1]) {
                case MONSTER:
                    map.add(new Enemy(map, (Location) entity[0], (Monster[]) entity[2]));
                    break;
                case BOSS:
                    map.add(new EnemyBoss(map, (Location) entity[0], (Monster[]) entity[2]));
                    break;
                case SHOP:
                    map.add(new ShopOwner(map, (Location) entity[0]));
                    break;
                case NPC:
                    map.add(new Npc(map, (Location) entity[0]));
                    break;
                default:
            }
        }
        return map;
    }

    public static boolean check(Driver driver, Player player, TileMap map, Thread thread, Protagonist protag) {
        for (MapEntity o : map.entities) {
            if (player.getLocation().equals(o.getLocation()) &&  (o instanceof Npc) && player.getLocation().row == 10 && player.getLocation().col == 53) {
                TileMap.clearScreen();
                map.render();
                NpcQuest.killQuest(protag);
                return false;
            }
            if (player.getLocation().equals(o.getLocation()) && o instanceof EnemyBoss) {
                thread.interrupt();
               if (BossFight.bossFight(protag)) {
                   EndScreen.win();
                   driver.e = false;
                   return false;
               } else {
                    EndScreen.lose();
                    driver.e = false;
                    return false;
               }
                //BOSSFIGHT
               //if FALSE GO TO END SCREEN
               // if TRUE GO TO END SCREEN
            }
            if (player.getLocation().equals(o.getLocation()) && o instanceof Enemy) {

                var x = o.getLocation().col;
                var y = o.getLocation().row;

                thread.interrupt();
                if (Battle.perform(protag)) {
                    map.remove(o);
                    map.map[y][x] = Tile.keyToTile('Y');
                    map.add(player);
                    return true;
                } else {
                    player.moveTo(new Location(player.getLocation().row + 1, player.getLocation().col));
                    return true;
                }
                
                

                

            }
              //do this
            
            if (player.getLocation().equals(o.getLocation()) && !(o instanceof Enemy) && !(o instanceof Player) && !(o instanceof Npc)) {
                thread.interrupt();
                protag.giveCoins(100000);
                protag.increaseLevel(10000, 1000000);
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
                case "t":
                    player.move(-1, 0);
                    player.move(-1, 0);
                    break;
                case "f":
                    player.move(0, -1);
                    player.move(0, -1);
                    break;
                case "g":
                    player.move(1, 0);
                    player.move(1, 0);
                    break;
                case "h":
                    player.move(0, 1);
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

            if(check(driver, player, map, thread, driver.protag)) {
                runner = new ClipControl();
                
                runner.setSong(6);
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
