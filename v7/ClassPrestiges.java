
/**
 * Useless class until I move YoRPG into another class and whatnot
 */

import java.io.*;

import classes.*;
import classes.Character;
import mapentities.*;
import input.InputThing;

public class ClassPrestiges implements InputThing {
    enum basicClasses {
        Archer,
        Swordsman,
        Tank,
        Wizard
    }

    static String classPick;
    private String name;

    

    static String[] basicClasses = {"Archer", "Swordsman", "Tank", "Wizard"};

    public ClassPrestiges() {
        name = "";
        classPick = "";
    }

    public void pickAClass(Woo driver, Thread thread) {
        var done = false;
        TileMap.clearScreen();
        System.out.println("What is your name?");
        name = receiveInput();
        driver.protag.setName(name);
        TileMap.clearScreen();
        
        System.out.println("Please choose thy starting class!" +
                       "\n\t1. Tank\n\t2. Archer\n\t3. Wizard"
                       + "\n\t4. Swordsman"); 
        while(!done) {
            
            classPick = receiveInput();
            switch (classPick) {
                case "1":
                    driver.protag = new Tank(driver.protag.getName());
                    done = true;
                    break;
                case "2":
                    driver.protag = new Archer(name);
                    done = true;
                    break;
                case "3":
                    driver.protag = new Wizard(name);
                    done = true;
                    break;
                case "4":
                    driver.protag = new Swordsman(name);
                    done = true;
                    break;
                case "info":
                    System.out.println(
                        Tank.about() + Archer.about() + Wizard.about() + Swordsman.about()    
                    );
                    break;
                default:
                    TileMap.clearScreen();
                    System.out.println("Thy pick is not valid! Again!");
                    System.out.println("Please choose thy starting class!" +
                       "\n\t1. Tank\n\t2. Archer\n\t3. Wizard"
                       + "\n\t4. Swordsman"); 
               
            
            }
        }
        thread.interrupt();
    }
    public static void prestige(Woo driver) {
        String pick = "";
    String[] picks = {"",""};
    System.out.println("\nYour current class : " + driver.protag.getType());
    picks[0] = driver.protag.getType();
    System.out.println("\n\nDear Adventurer, you have reached the point where you can prestige! Choose wisely!");
    int pos = 0;
    for (int i = 0; i < Character.classTypes.length; i++) {
      if (Character.classTypes[i].equals(driver.protag.getType())) {
        pos = i;
      }
    }
    System.out.println("\nHere are your available classes!" +
                       "\n\t1. " + Character.classTypes[pos + 1] + 
                       "\n\t2. " + Character.classTypes[pos + 2]);
    for (;;) {
      try {
        InputThing l = new InputThing() {
            @Override
            public String receiveInput() {
                // TODO Auto-generated method stub
                return InputThing.super.receiveInput();
            }
        };
        pick = l.receiveInput();
        break;
      } catch (Exception o) {
        System.out.println("Invalid Choice. Try Again!");
      }
    }
    // VERY VERY INEFFICIENT
    int apples = driver.protag.apples;
    int[] items = driver.protag.items;
    int[] visits = driver.protag.visits;
    int killCount = driver.protag.getKills();
    if (picks[0].equals("Tank")) {
      if (pick.equals("1")) {
        driver.protag = new Tonk(driver.protag.getMaxHealth(), driver.protag.getStrength(), driver.protag.getAttackRating(), driver.protag.getDefense(), driver.protag.getName(), driver.protag.getLevel(), driver.protag.getSpeed(), driver.protag.getCoins());
      } else {
        driver.protag = new Fortress(driver.protag.getMaxHealth(), driver.protag.getStrength(), driver.protag.getAttackRating(), driver.protag.getDefense(), driver.protag.getName(), driver.protag.getLevel(), driver.protag.getSpeed(), driver.protag.getCoins());
      }
    } else if (picks[0].equals("Archer")) {
      if (pick.equals("1")) {
        driver.protag = new Sniper(driver.protag.getMaxHealth(), driver.protag.getStrength(), driver.protag.getAttackRating(), driver.protag.getDefense(), driver.protag.getName(), driver.protag.getLevel(), driver.protag.getSpeed(), driver.protag.getCoins());
      } else {
        driver.protag = new Gunner(driver.protag.getMaxHealth(), driver.protag.getStrength(), driver.protag.getAttackRating(), driver.protag.getDefense(), driver.protag.getName(), driver.protag.getLevel(), driver.protag.getSpeed(), driver.protag.getCoins());
      }
    } else if (picks[0].equals("Wizard")) {
      if (pick.equals("1")) {
        driver.protag = new Arcane(driver.protag.getMaxHealth(), driver.protag.getStrength(), driver.protag.getAttackRating(), driver.protag.getDefense(), driver.protag.getName(), driver.protag.getLevel(), driver.protag.getSpeed(), driver.protag.getCoins());
      } else {
        driver.protag = new Necromancer(driver.protag.getMaxHealth(), driver.protag.getStrength(), driver.protag.getAttackRating(), driver.protag.getDefense(), driver.protag.getName(), driver.protag.getLevel(), driver.protag.getSpeed(), driver.protag.getCoins());
      }
    } else {
      if (pick.equals("1")) {
        driver.protag = new Paladin(driver.protag.getMaxHealth(), driver.protag.getStrength(), driver.protag.getAttackRating(), driver.protag.getDefense(), driver.protag.getName(), driver.protag.getLevel(), driver.protag.getSpeed(), driver.protag.getCoins());
      } else {
        driver.protag = new Barbarian(driver.protag.getMaxHealth(), driver.protag.getStrength(), driver.protag.getAttackRating(), driver.protag.getDefense(), driver.protag.getName(), driver.protag.getLevel(), driver.protag.getSpeed(), driver.protag.getCoins());
      }
    }
    driver.protag.apples = apples;
    driver.protag.items = items;
    driver.protag.visits = visits;
    driver.protag.killCount = killCount;
    System.out.println("\nYour new stats:\n" + driver.protag.toString());
    System.out.println("Congradulations on your new class. Enjoy 10 free coins that thee hath earned for prestiging");
    try {
        Thread.sleep(2000);
    } catch (Exception e) {
        //TODO: handle exception
    }
    driver.protag.giveCoins(10);
    }
}