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

public class BossFight  implements InputThing{
    public static void load(){

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
    public static boolean bossFight(Protagonist protag) {
        int i;
        String delayThing;
        InputThing input = new InputThing() {
            @Override
            public String receiveInput() {
                // TODO Auto-generated method stub
                return InputThing.super.receiveInput();
            }
        };
      
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*A mysterious voice starts speaking*");
        System.out.println("It seems that you have reached my lair. I would applaud you if you weren't going to die soon!");
        System.out.println("Those puny monsters are NOTHING. Feel the wrath of my pwer and tremble!");
        System.out.println("Your life is now over. Guards KILL THIS HERO!\n(Enter to Continue)");
        delayThing = input.receiveInput();
        
        Guard guard1 = new Guard();
        Guard guard2 = new Guard();
        Boss boss = new Boss();
        while(guard1.isAlive() && protag.isAlive()) {
          for(;;) {
            try {
              Dialogue.listOptions(protag);
              
              i = Integer.parseInt( input.receiveInput() );
              if (i < (protag.attackTypes.length + 1) && i > 0) {
                break;
              } else {
                System.out.println("Thee hath picked no valid option!");
              }
            }
            catch ( Exception e ) {
              System.out.println("Thee hath picked no number!");
            }
          }
    
          
          protag.setAttackType(protag.attackTypes[i - 1]);
          
          
          Dialogue.dealDamage(protag, guard1);
          
        }
        if (!guard1.isAlive()) {
          System.out.println("Hmm. It seems you have slain one of my guards. Guard 2 Attack!");
          protag.resetHealth();
          try {
              Thread.sleep(2000);
          } catch (Exception e) {
              //TODO: handle exception
          }
    
        } else {
          System.out.println("Twas a valiant attempt! Game over");
          return false;
        }
        while(guard2.isAlive() && protag.isAlive()) {
          while(true) {
            try {
              Dialogue.listOptions(protag);
              
              i = Integer.parseInt(input.receiveInput() );
              if (i < (protag.attackTypes.length + 1) && i > 0) {
                break;
              } else {
                System.out.println("Thee hath picked no valid option!");
              }
            }
            catch ( Exception e ) {
              System.out.println("Thee hath picked no number!");
            }
          }
    
          
          protag.setAttackType(protag.attackTypes[i - 1]);
          
          
          Dialogue.dealDamage(protag, guard2);
          
        }
        if (!guard2.isAlive()) {
          System.out.println("Hmm. It seems you have slain both my guards. I guess it is time for me to attack!");
          protag.resetHealth();
          try {
            Thread.sleep(2000);
        } catch (Exception e) {
            //TODO: handle exception
        }
    
        } else {
          System.out.println("Twas a valiant attempt!");
          return false;
        }
        System.out.println("I am much powerful than my guards. Don't think this will be easy.");
        while(boss.isAlive() && protag.isAlive()) {
          while(true) {
              refresh(protag, boss);
            try {
              Dialogue.listOptions(protag);
              
              i = Integer.parseInt( input.receiveInput() );
              if (i < (protag.attackTypes.length + 1) && i > 0) {
                break;
              } else {
                System.out.println("Thee hath picked no valid option!");
              }
            }
            catch ( Exception e ) {
              System.out.println("Thee hath picked no number!");
            }
          }
    
          
          protag.setAttackType(protag.attackTypes[i - 1]);
          
          
          Dialogue.dealDamage(protag, boss);
          
        }
        if (boss.isAlive()) {
          System.out.println("Twas a valiant attempt!");
          return false;
        }
    
        System.out.println("*Gasp* How is this possible? I-i am the MOST POWERFUL BEING IN THE UNIVERSE!");
        System.out.println("I have one more attack left. Since I am dying I will perform my most powerful attack yet...");
        System.out.println("SELF DESTRUCTION! MWAHAHAHA!");
        System.out.println("*You frantically look around to try to escape but it is too late.*" +
                             "\nGoodbye Hero. Boss utters this with his last breath and closes his eyes.");    
                             
        System.out.println("Boss performs his final attack: Self Destruction. Everything goes white.");
        System.out.println("Press 1 to continue");
        
        for (;;) {
          try {
            i = Integer.parseInt( input.receiveInput() );
            if (i != 1) {
              System.out.println("Tis just one button... Try again");
            } else {
              break;
            }
    
          } catch (Exception o) {
            System.out.println("Tis just one button... Try again");
          }
        }
          System.out.print("\033[H\033[2J");
          System.out.flush();
          // CHANGE THIS
        if (Shop.bought[5]) {
          return true;
        }
    
        return false;
        
    
      }
      public static void main(String[] args) {
          Protagonist protag = new Protagonist();
          BossFight.bossFight(protag);
      }
}
