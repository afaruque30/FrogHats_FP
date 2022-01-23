import java.util.ArrayList;
import java.util.Scanner;

import classes.Monster;
import constants.Floor;
import constants.Tile;
import mapentities.*;
import classes.*;
import music.*;

public class Woo {
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
                case APPLE:
                    map.add(new Apple(map, (Location) entity[0]));
                    break;
                case GUARD:
                    map.add(new GoodGuard(map, (Location) entity[0]));
                    break;
                case SHEEP:
                    map.add(new Sheep(map, (Location) entity[0]));
                    break;
                default:
            }
        }
        return map;
    }

    public static boolean check(Woo driver, Player player, TileMap map, Thread thread, Protagonist protag) {
        for (MapEntity o : map.entities) {
            if (player.getLocation().equals(o.getLocation()) && (o instanceof Sheep)) {
                var e = Math.random();
                if (e < 0.3) {
                    System.out.println("You have succesfully tamed Dorothea");
                    try {
                        Thread.sleep(2000);
                    } catch (Exception al) {
                        //TODO: handle exception
                    }
                    protag.items[5] = 1;
                    map.remove(o);
                    map.map[player.getLocation().row][player.getLocation().col] = Tile.keyToTile('G');
                    map.add(player);
                } else {
                    System.out.println("Hmm, Dorothea seems to refuse to acknoledge you, try again");
                    try {
                        Thread.sleep(2000);
                    } catch (Exception al) {
                        //TODO: handle exception
                    }
                }
                player.moveTo(new Location(player.getLocation().row + 1, player.getLocation().col ));
                return false;
                

            }
            if (player.getLocation().equals(o.getLocation()) && (o instanceof GoodGuard)) {
                if (NpcQuest.guardInteraction(protag)) {
                    map.remove(o);
                    map.map[player.getLocation().row][player.getLocation().col] = Tile.keyToTile('G');
                    map.add(player);
                }
                player.moveTo(new Location(player.getLocation().row, player.getLocation().col - 1));
                return false;
            }
            if (player.getLocation().equals(o.getLocation()) &&  (o instanceof Apple)) {
                map.remove(o);
                map.map[player.getLocation().row][player.getLocation().col] = Tile.keyToTile('G');
                map.add(player);
                protag.foundApple();
                System.out.println("Hey! You found an apple, wonder what those do..." + "\nTotal Apples: " + protag.apples);
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    //TODO: handle exception
                }
                return false;
            }
            if (player.getLocation().equals(o.getLocation()) &&  (o instanceof Npc) && player.getLocation().row == 10 && player.getLocation().col == 53) {
                TileMap.clearScreen();
                map.render();
                NpcQuest.killQuest(protag);
                player.moveTo(new Location(player.getLocation().row, player.getLocation().col - 1));
                return false;
            }
            if (player.getLocation().equals(o.getLocation()) &&  (o instanceof Npc) && player.getLocation().row == 13 && player.getLocation().col == 19) {
                TileMap.clearScreen();
                map.render();
                NpcQuest.artifactQuest(protag);
                player.moveTo(new Location(player.getLocation().row + 1, player.getLocation().col));
                return false;
            }
            if (player.getLocation().equals(o.getLocation()) &&  (o instanceof Npc) && player.getLocation().row == 18 && player.getLocation().col == 1) {
                TileMap.clearScreen();
                map.render();
                NpcQuest.hutMan(protag);
                player.moveTo(new Location(player.getLocation().row - 1, player.getLocation().col));
                return false;
            }
            if (player.getLocation().equals(o.getLocation()) &&  (o instanceof Npc) && player.getLocation().row == 6 && player.getLocation().col == 9) {
                TileMap.clearScreen();
                map.render();
                NpcQuest.appleQuest(protag);
                player.moveTo(new Location(player.getLocation().row - 1, player.getLocation().col));
                return false;
            }
            if (player.getLocation().equals(o.getLocation()) &&  (o instanceof Npc) && player.getLocation().row == 12 && player.getLocation().col == 40) {
                TileMap.clearScreen();
                map.render();
                NpcQuest.lostSheep(protag);
                player.moveTo(new Location(player.getLocation().row, player.getLocation().col + 1));
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
                    if (map.map[y][x+1] == Tile.keyToTile('G')) {
                        map.map[y][x] = Tile.keyToTile('G');
                    } else {
                        map.map[y][x] = Tile.keyToTile('Y');
                    }
                    
                    map.add(player);
                    protag.kill();
                    
                    if (protag.getLevel() == 5) {
                        ClassPrestiges.prestige(driver);
                        protag.kill();
                    }
                    protag.setHealth(protag.getMaxHealth());
                    return true;
                } else {
                    player.moveTo(new Location(player.getLocation().row + 1, player.getLocation().col));
                    protag.setHealth(protag.getMaxHealth());
                    return true;
                }
                
                

                

            }
              //do this
            
            if (player.getLocation().equals(o.getLocation()) && !(o instanceof Enemy) && !(o instanceof Player) && !(o instanceof Npc)) {
                if (protag.getKills() >= 2) {
                    thread.interrupt();
                    
                    Shop.purchase(protag);
                } else {
                    
                    System.out.println("Kill some mobs before accessing please!");
                    
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                    player.moveTo(new Location(player.getLocation().row - 1, player.getLocation().col));
                    return false;
                }
                player.moveTo(new Location(player.getLocation().row - 1, player.getLocation().col));
                return true;

            }

        }
        return false;
    }
    public static void main(String[] args) {
        var e = true;
        Woo driver = new Woo();


        ClipControl runner2 = new ClipControl();
        
        
        Menu menu = new Menu();
        ClassPrestiges classes = new ClassPrestiges();
        runner2.setSong(0);
        try {
            runner2.load();
        } catch (Exception el) {
            //TODO: handle exception
        }
        Thread thread1 = new Thread(runner2);
        thread1.start();
        menu.present();
        menu.load(thread1);

        classes.pickAClass(driver, thread1);
        

        // pregame music

        ClipControl runner = new ClipControl();
        runner.setSong(6);
        try {
            runner.load();
        } catch (Exception el) {
            //TODO: handle exception
        }
        Thread thread = new Thread(runner);
        thread.start();

        

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
            if (player.getLocation().equals(map.end) && driver.protag.items[2] == 0 && currLevel == 1) {
                System.out.println("Hmm, you can't advance just yet!");
                try {
                    Thread.sleep(2000);
                } catch (Exception o) {
                    //TODO: handle exception
                }
            } else if(player.getLocation().equals(map.end) && currLevel != 2) {
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
