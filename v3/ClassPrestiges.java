
/**
 * Useless class until I move YoRPG into another class and whatnot
 */

import java.io.*;

import classes.Protagonist;
import classes.*;

public class ClassPrestiges implements InputThing {
    
    static String classPick;
    private String name;

    static String[] basicClasses = {"Archer", "Swordsman", "Tank", "Wizard"};

    public ClassPrestiges() {

    }

    public void pickAClass(Driver driver) {
        System.out.println("What is your name?");
        name = receiveInput();
        driver.protag.setName(name);
        
        System.out.println("Please choose thy starting class!" +
                       "\n\t1. Tank\n\t2. Archer\n\t3. Wizard"
                       + "\n\t4. Swordsman"); 
        for (;;) {
            try {
                classPick = receiveInput();
                if (classPick.equals("1")) {
                    driver.protag = new Tank(driver.protag.getName());
                    break;
                } else if (classPick.equals("2")) {
                    driver.protag = new Archer(name);
                    break;
                } else if (classPick.equals("3")) {
                    driver.protag = new Wizard(name);
                    break;
                } else if (classPick.equals("4")) {
                    driver.protag = new Swordsman(name);
                    break;
                } else if (classPick.equals("info")) {
                    System.out.println(
                        Tank.about() + Archer.about() + Wizard.about() + Swordsman.about()    
                    );
                } else {
                    System.out.println("Thy pick is not valid! Again!");
                }  
            } catch (Exception m) {
                System.out.println("Thy pick is not valid! Again!");
            }
        }
    }
    public static void main(String[] args) {
     
    }
}