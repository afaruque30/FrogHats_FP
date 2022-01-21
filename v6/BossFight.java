import mapentities.*;
import music.ClipControl;
import classes.Bandit;
import classes.Dialogue;
import classes.Ogre;
import classes.Protagonist;
import classes.Monster;
import classes.Worg;
import constants.BColor;
import constants.FColor;
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
        ClipControl runner = new ClipControl();
        runner.setSong(3);
        try {
            runner.load();
        } catch (Exception e) {
            System.err.println("err");
        }
        Thread thread = new Thread(runner);
        thread.start();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*A mysterious voice starts speaking*");
        System.out.println("It seems that you have reached my lair. I would applaud you if you weren't going to die soon!");
        System.out.println("Those puny monsters are NOTHING. Feel the wrath of my pwer and tremble!");
        System.out.println("Your life is now over. Guards KILL THIS HERO!\n(continue (or anything) to Continue)");
        delayThing = input.receiveInput();
        
        Guard guard1 = new Guard();
        Guard guard2 = new Guard();
        Boss boss = new Boss();
        while(guard1.isAlive() && protag.isAlive()) {
            refresh(protag, guard1);
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
          
          System.out.println(Dialogue.dealDamage(protag, guard1));
          try {
            Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
          
          
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
          thread.interrupt();
          return false;
        }
        while(guard2.isAlive() && protag.isAlive()) {
          while(true) {
              refresh(protag, guard2);
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
          
          System.out.println(Dialogue.dealDamage(protag, guard2));
          
          try {
            Thread.sleep(2000);
        } catch (Exception e) {
            //TODO: handle exception
        }
          
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
          thread.interrupt();
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
          
          System.out.println(Dialogue.dealDamage(protag, boss));
          
          try {
            Thread.sleep(2000);
        } catch (Exception e) {
            //TODO: handle exception
        }
          
        }
        if (boss.isAlive()) {
          System.out.println("Twas a valiant attempt!");
          thread.interrupt();
          return false;
        }
    
        System.out.println("*Gasp* How is this possible? I-i am the MOST POWERFUL BEING IN THE UNIVERSE!");
        System.out.println("I have one more attack left. Since I am dying I will perform my most powerful attack yet...");
        System.out.println("SELF DESTRUCTION! MWAHAHAHA!");
        System.out.println("*You frantically look around to try to escape but it is too late.*" +
                             "\nGoodbye Hero. Boss utters this with his last breath and closes his eyes.");    
                             
        System.out.println("Boss performs his final attack: Self Destruction. Everything goes white.");
        thread.interrupt();
        
        String white = BColor.WHITE + "";
        String win1 = BColor.WHITE + "";
        String win2 = BColor.WHITE + "";
        String win3 = BColor.WHITE + "";
         for (int z = 0; z < 100; z++) {
            for (int o = 0; o < 50; o++) {
                white += " ";
            }
            white += "\n";
        }
        for (int z = 0; z < 100; z++) {
            for (int o = 0; o < 50; o++) {
                if (z == 95) {
                    win1 += (o == 0) ? FColor.BLACK + "Where Am I?" : "";
                } else {
                    win1 += " ";
                }
                
            }
            win1 += "\n";
        }
        for (int z = 0; z < 100; z++) {
            for (int o = 0; o < 50; o++) {
                if (z == 95) {
                    win2 += (o == 0) ? FColor.BLACK + "The Medallion you received starts glowing, and starts fading away, and suddenly you understand" : "";
                } else {
                    win2 += " ";
                }
                
            }
            win2 += "\n";
        }
        for (int z = 0; z < 100; z++) {
            for (int o = 0; o < 200; o++) {
                if (z == 95) {
                    win3 += (o == 0) ? FColor.BLACK + "So, the medallion saved my life - you think this as you are brought back into reality" : "";
                } else {
                    win3 += " ";
                }
                
            }
            win3 += "\n";
        }
        
        
          // CHANGE THIS
          // Shop.bought[5]
        if (true) {
            thread.interrupt();
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                //TODO: handle exception
            }
            TileMap.clearScreen();
            System.out.println(white);
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                //TODO: handle exception
            }
            System.out.println(win1);
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                //TODO: handle exception
            }
            System.out.println(win2);
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                //TODO: handle exception
            }
            System.out.println(win3);
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                //TODO: handle exception
            }
            System.out.println(BColor.BLACK + "" + FColor.WHITE);
              System.out.print("\033[H\033[2J");
              System.out.flush();
          return true;
        }
        TileMap.clearScreen();
        thread.interrupt();
        return false;
       
        
    
      }
      public static void main(String[] args) {
          Protagonist protag = new Protagonist();
          protag.setHealth(10000);
          protag.increaseLevel(100, 1000000);
          bossFight(protag);
         
       
      }
}
