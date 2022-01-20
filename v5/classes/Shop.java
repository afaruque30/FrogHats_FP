package classes;

/**
 * Shop for YoRPG
 */
import mapentities.*;

import classes.*;
import java.io.*;

public class Shop {

    static InputStreamReader isr = new InputStreamReader( System.in );
    static BufferedReader in = new BufferedReader( isr );

    static String f;
    //(Only 1 shop allowed per game!)
    static String[] artifacts = {"Ring o' Power", "Relic of TONKiness", "Gem of Confidence", "Heart of an Eagle", "Rabbit's foot", "?????"};

    static int[] price = {10, 30, 80, 30, 5, 100};
    static int[] boost = {10, 20, 1, 50, 10, 1};
    static boolean[] bought = {false, false, false, false, false, false};

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
      ClipControl runner = new ClipControl();
      runner.setSong(1);
      try {
          runner.load();
      } catch (Exception oaijsfalkdsf) {
          System.err.println("err");
      }
      Thread thread = new Thread(runner);
      thread.start();
      for (ShopLoader shop : ShopLoader.values()) {
        loadOptions(e, shop);
        System.out.println(shop.image);
      }
    }
    public static void loadOptions(Protagonist e, ShopLoader shop) {
      switch (shop) {
        case RING:
          if (e.artifacts[0] == 0) {
            System.out.println("ALREADY BOUGHT");
          }
          break;

      }
    }
    public static void purchase(Protagonist e) {
        while(true) {
            try {
                listOptions(e);
                f = in.readLine();
                System.out.println(f);

                if (f.equals("1")) {
                    buyItem("Ring O Power", e);
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
                } else {
                System.out.println("Thee hath not picked a vlid option!");
                }

          } catch(Exception m) {
            System.out.println("Thee hath not picked a valid option!");
          }

        }
        System.out.println("\nWhy thank you and have a good day!");
        System.out.println("\nNew stats: \n" + e.toString());
    }
    public static void listOptions(Protagonist e) {
        System.out.println("\nWelcome to Silly Serpent's shop!" +
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
    public static void main(String[] args) {
      Shop shop = new Shop();
      Protagonist protag = new Protagonist();
      shop.load(protag);
    }
}
