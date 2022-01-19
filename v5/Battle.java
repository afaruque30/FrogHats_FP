import java.util.Scanner;
import java.io.File;

import mapentities.*;
import classes.Bandit;
import classes.Ogre;
import classes.Protagonist;
import classes.Monster;
import classes.Worg;

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
            System.out.println("\t\t\t\t\t\tHEALTH:  " + ogrek.getHealth());
        }
        
        load();

      
    }
    public static void main(String[] args) {
        Protagonist protag = new Protagonist();
        
        perform(protag);
    }
}
