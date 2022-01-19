import java.util.Scanner;
import java.io.File;

import mapentities.*;
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
        TileMap map = new TileMap();
        map.load("Fight.txt"); // change plz to actual scene or smthing
        map.render(true);
       
    }
    public static void perform(Protagonist protag) {
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
        TileMap.clearScreen();
        if (ogrek.getHealth() >= 100) {
            System.out.println("\t\t\t\t\t ENEMY HEALTH: " + ogrek.getHealth());
        } else {
            System.out.println("\t\t\t\t\t  ENEMY HEALTH:  " + ogrek.getHealth());
        }
        load();
        System.out.println("Your Health: " + protag.getHealth());
        System.out.println("Your Attacks:");
        Dialogue.listOptions(protag);
        

      
    }
    public static void main(String[] args) {
        Protagonist protag = new Tank();
        
        perform(protag);
    }
}
