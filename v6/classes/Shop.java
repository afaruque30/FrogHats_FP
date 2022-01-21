package classes;
import classes.Protagonist;
import classes.ShopLoader;
import input.InputThing;
/**
 * Shop for YoRPG
 */
import mapentities.*;
import music.*;
import classes.*;

import classes.Protagonist;
import constants.BColor;
import constants.FColor;
import constants.*;

import java.io.*;


public class Shop implements InputThing{

    static InputStreamReader isr = new InputStreamReader( System.in );
    static BufferedReader in = new BufferedReader( isr );

    static String o;
    //(Only 1 shop allowed per game!)
    static String[] artifacts = {"Ring o' Power", "Relic of TONKiness", "Gem of Confidence", "Heart of an Eagle", "Rabbit's foot", "?????"};

    static int[] price = {10, 30, 80, 30, 5, 100};
    static int[] boost = {10, 20, 1, 50, 10, 1};
    public static boolean[] bought = {false, false, false, false, false, false};

    //not the best
    public static int find(String name) {
        for (int i = 0; i < artifacts.length; i++) {
            if (name.equals(artifacts[i])) {
                return i;
            }
        }
        return -1;
    }

    public static void buyItem(String name, Protagonist e) {
        int pos = find(name);
        if (bought[pos]) {
            System.out.println("Thee hath already bought " + artifacts[pos]);
        } else if (e.getCoins() < price[pos]) {
            System.out.println("Hmm. Thee does not seem to have enough coins!");
        } else {
            e.giveCoins(-1 * price[pos]);
            System.out.println("Enjoy thy newly bought " + artifacts[pos] + "!");
            e.artifactChange(pos);
            bought[pos] = true;
            e.update(pos);
        }
    }
    public static void load(Protagonist e) {
      
      String toptitle = "";
      for (int i = 0; i < 3; i++) {
        toptitle += "\n"; 
        for (int j = 0; j < 60; j++) {
            if (i == 1 && j == 26) {
                toptitle += BColor.CYAN + "" + FColor.BLACK + "SHOP" + FColor.WHITE + BColor.BLACK;
                j += 4;
            }
            toptitle += BColor.CYAN + " " + BColor.BLACK;
        }
        
      }     
      TileMap.clearScreen();
      System.out.println(toptitle + BColor.BLACK + FColor.BLACK);
      String test = "";
      String availabilty = "";
      for (int i = 0; i < 6; i++) {
        
        for (ShopLoader shop : ShopLoader.values()) {
            test += loadOptions(e, shop, i);
            availabilty += available(e, shop, i);
            
        }
        if (i != 5) test += "\n";
        
    }
        System.out.println(test + BColor.BLACK + "" + FColor.WHITE);
        System.out.println("============================================================");
        System.out.println(availabilty);
        System.out.println("============================================================");
        
    }
    public static void loadBeg() {
        ClipControl runner = new ClipControl();
        runner.setSong(1);
        try {
            runner.load();
        } catch (Exception oaijsfalkdsf) {
            System.err.println("err");
        }
        Thread thread = new Thread(runner);
        thread.start();
    }
    public static String available(Protagonist e, ShopLoader shop, int i) {
        if (i == 0) {
            switch (shop) {
                case RING: 
                    return (e.artifacts[0] == 0) ? " IN STOCK " : "SOLD     ";
                case RELIC: 
                    return (e.artifacts[1] == 0) ? " IN STOCK " : "SOLD     ";
                case GEM: 
                     return (e.artifacts[2] == 0) ? " IN STOCK " : "SOLD     "; 
                case HEART: 
                    return (e.artifacts[3] == 0) ? " IN STOCK " : "SOLD     ";
                case RABBIT: 
                    return (e.artifacts[4] == 0) ? " IN STOCK " : "SOLD     "; 
                case UN: 
                    return (e.artifacts[5] == 0) ? " IN STOCK " : "SOLD     "; 
            }
        }
        return "";
    }
    public static String loadOptions(Protagonist e, ShopLoader shop, int i) {
      return shop.image[i];
    }
    public static void purchase(Protagonist e) {
       
        ClipControl runner = new ClipControl();
        runner.setSong(1);
        try {
            runner.load();
        } catch (Exception oaijsfalkdsf) {
            System.err.println("err");
        }
        Thread thread = new Thread(runner);
        thread.start();
        while(true) {
            try {
                load(e);
                InputThing l = new InputThing() {
                    @Override
                    public String receiveInput() {
                        // TODO Auto-generated method stub
                        return InputThing.super.receiveInput();
                    }
                };
                System.out.println("Type in 1-6 to buy, or 7 to exit" + " YOUR COINS: " + e.getCoins());
                var f = l.receiveInput();


                if (f.equals("1")) {
                    buyItem("Ring o' Power", e);
                } else if (f.equals("2")) {
                    buyItem("Relic of TONKiness", e);
                } else if (f.equals("3")) {
                    buyItem("Gem of Confidence", e);
                } else if (f.equals("4")) {
                    buyItem("Heart of an Eagle", e);
                } else if (f.equals("5")) {
                    buyItem("Rabbit's foot", e);
                } else if (f.equals("6")) {
                    buyItem("?????", e);
                } else if (f.equals("7")) {
                    break;
                } else if (f.equals("info")) {
                    listOptions(e);
                } else {
                System.out.println("Thee hath not picked a vlid option!");
                }
                try {
                    Thread.sleep(2000);
                } catch (Exception p) {
                    //TODO: handle exception
                }

          } catch(Exception m) {
            System.out.println("Thee hath not picked a valid option!");
          }

        }
        
        
        System.out.println("\nWhy thank you and have a good day!");
        System.out.println("\nNew stats: \n" + e.toString());
        thread.interrupt();
        try {
            Thread.sleep(2000);
        } catch (Exception p) {
            //TODO: handle exception
        }
    }
    public static void listOptions(Protagonist e) {
        System.out.println("\nWelcome to the shop!" +
                             "\nHere we sell all kinds of goodies" +
                             "\nTo help aid you on your journey!" +
                             "\nOur current inventory of magical items:" +
                             "\n\t1. Ring O Power: Boost Strength by 10 - 10 Coins" +
                             "\n\t2. Relic of TONKiness: Boost defense by 20 - 30 Coins" +
                             "\n\t3. Gem of confidence: Boost attack rating by 1 - 80 Coins" +
                             "\n\t4. Heart of an eagle: Boost maxhealth by 50 - 30 Coins" +
                             "\n\t5. Rabbit's foot: Boost speed by 10 - 5 Coins" +
                             "\n\t6. ????? - ????" +
                             "\n\t7. Exit" +
                             "\n\tBuy something or type 7 to exit!" +
                             "\n\tYour coins: " + e.getCoins());
    }
    
}
