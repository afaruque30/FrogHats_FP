
/**
 * Useless class until I move YoRPG into another class and whatnot
 */

import java.io.*;

import classes.Protagonist;
import classes.*;
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

    public void pickAClass(Driver driver) {
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
    }
}