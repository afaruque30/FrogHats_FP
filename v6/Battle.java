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

public class Battle implements InputThing {
    

    enum Monsters {
        OGRE,
        WORG,
        BANDIT
    }
    public static void load() {
        System.out.println(//insert art here
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "+
            "\n                                                            "
            );

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
    public static void perform(Protagonist protag) {
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
        var pick = (int) (Math.random() * 3) + 1;
        switch(pick) {
            case 1:
                ogrek = new Ogre();
            case 2:
                ogrek = new Worg();
            case 3:
                ogrek = new Bandit();

        }
        while (ogrek.isAlive()) {
            refresh(protag, ogrek);
            System.out.println("Your Attacks:");
            Dialogue.listOptions(protag);
            var inputRaw = input.receiveInput();
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
        // if ( !smaug.isAlive() && !pat.isAlive() ) {
        //     Dialogue.bothDie();
        //     try {
        //         Thread.sleep(3000);
        //         //LIVES --?
        //     } catch (Exception e) {
        //         //TODO: handle exception

        //     }
        // }
        // else if ( !smaug.isAlive() ) {
        //     Dialogue.beastDies();
        //     pat.attackRating += 0.05;
        //     while (true) {
        //       try {
        //         f = Integer.parseInt(in.readLine());
        //         if (f > 0 && f < 3) {
        //           break;
        //         } else {
        //           System.out.println("Not a valid choice");
        //         }
        //       } catch (Exception z) {
        //         System.out.println("Thee hath picked no number!");
        //       }
        //     }

        //     if (f == 1) {
        //       pat.increaseLevel(2, 0);
        //     } else {
        //       pat.increaseLevel(0, 2);
        //     }
        //     if (pat.getLevel() == 5 ) {
        //       this.prestige();
        //     }
        TileMap.clearScreen();
        System.out.println("YOU HAVE SLAIN MOB");
        thread.interrupt();


    }
    public static void main(String[] args) {
        Protagonist protag = new Tank();

        perform(protag);
    }
}
