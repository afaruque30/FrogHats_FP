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

        TileMap map = new TileMap();
        map.load("Fight.txt"); // change plz to actual scene or smthing
        map.render(true);


    }
    public static void refresh(Protagonist protag, Monster ogrek) {
        TileMap.clearScreen();
        if (ogrek.getHealth() >= 100) {
            System.out.println("\t\t\t\t\t ENEMY HEALTH: " + ogrek.getHealth());
        } else {
            System.out.println("\t\t\t\t\t  ENEMY HEALTH:  " + ogrek.getHealth());
        }
        load();
        System.out.println("Your Health: " + protag.getHealth());
    }
    public static boolean perform(Protagonist protag) {
        InputThing input = new InputThing() {
            @Override
            public String receiveInput() {
                // TODO Auto-generated method stub
                return InputThing.super.receiveInput();
            }
        };
        ClipControl runner = new ClipControl();
        runner.setSong(2);
        try {
            runner.load();
        } catch (Exception e) {
            System.err.println("err");
        }
        Thread thread = new Thread(runner);
        thread.start();
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
            Dialogue.listOptions(protag);

            var inputRaw = input.receiveInput();
            if (inputRaw.equals("exit")) {thread.interrupt(); return false;}
            int inputInt = 0;
            try {
                inputInt = Integer.parseInt(inputRaw);
            } catch (Exception e) {
                //TODO: handle exception
            }
            protag.setAttackType(protag.attackTypes[inputInt - 1]);


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
        else if ( !ogrek.isAlive() ) {
            int f = 0;
            Dialogue.beastDies();
            // protag.attackRating += 0.05;
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
            if (protag.getLevel() == 5 ) {
            //   this.prestige();
            }
            protag.kill();
        }
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        TileMap.clearScreen();
       
        thread.interrupt();
        return true;

    }
    public static void main(String[] args) {
        Protagonist protag = new Tank();

        perform(protag);
    }
}
