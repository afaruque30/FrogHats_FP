import java.util.Scanner;
import java.io.File;

import mapentities.*;
import music.ClipControl;
import classes.Bandit;
import classes.Dialogue;
import classes.Ogre;
import classes.Protagonist;
import classes.Monster;
import classes.Worg;
import classes.*;
import input.InputThing;

public class Battle implements InputThing {
    

    enum Monsters {
        OGRE,
        WORG,
        BANDIT
    }
    public static void load() {
        System.out.println("        |\\                     /)");
        System.out.println("        /\\_\\\\__               (_//");
        System.out.println("       |   `>\\-`     _._       //`)");
        System.out.println("        \\ /` \\\\  _.-`:::`-._  //");
        System.out.println("         `    \\|`    :::    `|/");
        System.out.println("               |     :::     |");
        System.out.println("               |.....:::.....|");
        System.out.println("               |:::::::::::::|");
        System.out.println("               |     :::     |");
        System.out.println("               \\     :::     /");
        System.out.println("                \\    :::    /");
        System.out.println("                 `-. ::: .-'");
        System.out.println("                  //`:::`\\\\");
        System.out.println("                 //   '   \\\\");
        System.out.println("                |/         \\\\");
        
        //TileMap map = new TileMap();
        //map.load("Fight.txt"); // change plz to actual scene or smthing
        //map.render(true);


    }
    public static void refresh(Protagonist protag, Monster ogrek) {
        TileMap.clearScreen();
        if (ogrek.getHealth() >= 100) {
            System.out.println("\\t\\t\\t\\t\\t ENEMY HEALTH: " + ogrek.getHealth());
        } else {
            if (ogrek.getHealth() >= 0) {
                System.out.println("\\t\\t\\t\\t\\t  ENEMY HEALTH:  " + ogrek.getHealth());
            } else {
                System.out.println("\\t\\t\\t\\t\\t  ENEMY HEALTH:   0" );
            }   
            
        }
        load();
        System.out.println("Your Health: " + protag.getHealth());
    }
    public static void startMusic() {
        ClipControl runner1 = new ClipControl();
        runner1.setSong(2);
        try {
            runner1.load();
        } catch (Exception e) {
            System.err.println("err");
        }
        Thread thread1 = new Thread(runner1);
        thread1.start();
    }
    public static boolean perform(Protagonist protag) {
        ClipControl runner1 = new ClipControl();
        runner1.setSong(2);
        try {
            runner1.load();
        } catch (Exception e) {
            System.err.println("err");
        }
        Thread thread1 = new Thread(runner1);
        thread1.start();
        InputThing input = new InputThing() {
            @Override
            public String receiveInput() {
                // TODO Auto-generated method stub
                return InputThing.super.receiveInput();
            }
        };
        
        Monster ogrek = new Monster();
        int pick = (int) (Math.random() * 3.0) + 1;
        if (pick == 1) {
            ogrek = new Bandit();
        } else if (pick == 2) {
            ogrek = new Ogre();
        } else {
            ogrek = new Worg();
        }
        while (ogrek.isAlive()) {
            refresh(protag, ogrek);
            System.out.println("Your Attacks:");
            
            int i = 0;
            for(;;) {
                try {
                  Dialogue.listOptions(protag);
                  String o = input.receiveInput();
                  if (o.equals("exit")) {thread1.interrupt(); return false;}
                  i = Integer.parseInt( o );

                  
                  if (i < (protag.attackTypes.length + 1) && i > 0) {
                    break;
                  } else {
                      refresh(protag, ogrek);
                    System.out.println("Thee hath picked no valid option!");
                  }
                }
                catch ( Exception e ) {
                  refresh(protag, ogrek);
                  System.out.println("Thee hath picked no number!");
                }
              }
            
        
            
            protag.setAttackType(protag.attackTypes[i - 1]);


            var dealDamage = Dialogue.dealDamage(protag, ogrek);
            refresh(protag, ogrek);
            System.out.println(dealDamage);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
         



        }
        protag.giveCoins(100);
        if ( !ogrek.isAlive() && !protag.isAlive() ) {
            Dialogue.bothDie();
            try {
                Thread.sleep(3000);
                //LIVES --?
            } catch (Exception e) {
                //TODO: handle exception

            }
        }
        if ( !protag.isAlive() ) {
            EndScreen.lose();
            try {
                Thread.sleep(3000);
                //LIVES --?
            } catch (Exception e) {
                //TODO: handle exception

            }
        }
        else if ( !ogrek.isAlive() ) {
            int f = 0;
            TileMap.clearScreen();
            Dialogue.beastDies();
            protag.attackRating += 0.05;
            while (true) {
              try {
                f = Integer.parseInt(input.receiveInput());
                if (f > 0 && f < 3) {
                  break;
                } else {
                  System.out.println("Not a valid choice");
                }
              } catch (Exception z) {
                System.out.println("Thee hath picked no number!");
              }
            }

            if (f == 1) {
              protag.increaseLevel(2, 0);
            } else {
              protag.increaseLevel(0, 2);
            }
            
           
        }
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        TileMap.clearScreen();
       
        thread1.interrupt();
        return true;

    }
    // public static void main(String[] args) {
    //     Protagonist protag = new Tank();

    //     perform(protag);
    //     while(true) {

    //     }
    // }
}
