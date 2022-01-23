import java.util.LinkedList;
import java.util.Queue;

import mapentities.TileMap;
import music.ClipControl;

public class EndScreen {
    public static void win() {
        String display = "";
        display =    ("               ____ ____  ____  _       ___             ");
        display += ("\n              /    |    \\|    \\| |     /  _]            ");
        display += ("\n             |  o  |  o  |  o  | |    /  [_             ");
        display += ("\n             |     |   _/|   _/| |___|    _]            ");
        display += ("\n             |  _  |  |  |  |  |     |   [_             ");
        display += ("\n             |  |  |  |  |  |  |     |     |            ");
        display += ("\n  __ __ ____ |__|__|__|__|__|__|_____|_____|  ___ ___   ");
        display += ("\n |  |  |    \\| |     /  _]/    |/ ___|  |  | /  _|   \\  ");
        display += ("\n |  |  |  _  | |    /  [_|  o  (   \\_|  |  |/  [_|    \\ ");
        display += ("\n |  |  |  |  | |___|    _|     |\\__  |  _  |    _|  D  |");
        display += ("\n |  :  |  |  |     |   [_|  _  |/  \\ |  |  |   [_|     |");
        display += ("\n |     |  |  |     |     |  |  |\\    |  |  |     |     |");
        display += ("\n  \\__,_|__|__|_____|_____|__|__| \\___|__|__|_____|_____|\n\n");
        String[] credits = {  "               ____ ____  ____  _       ___             ",
                                "              /    |    \\|    \\| |     /  _]            ",
                                    "             |  o  |  o  |  o  | |    /  [_             ",
                                    "             |     |   _/|   _/| |___|    _]            ",
                                    "             |  _  |  |  |  |  |     |   [_             ",
                                    "             |  |  |  |  |  |  |     |     |            ",
                                "  __ __ ____ |__|__|__|__|__|__|_____|_____|  ___ ___   ",
                                " |  |  |    \\| |     /  _]/    |/ ___|  |  | /  _|   \\  ",
                                    " |  |  |  _  | |    /  [_|  o  (   \\_|  |  |/  [_|    \\ ",
                                    " |  |  |  |  | |___|    _|     |\\__  |  _  |    _|  D  |",
                                " |  :  |  |  |     |   [_|  _  |/  \\ |  |  |   [_|     |",
                                    " |     |  |  |     |     |  |  |\\    |  |  |     |     |",
                                "  \\__,_|__|__|_____|_____|__|__| \\___|__|__|_____|_____|\n\n",
                             "Thank you for playing Apple Unleashed",
                             "                                     ",
                             "                                     ",
                             "This game was created by Froghat team",
                             "                                     ",
                             "                                     ",
                             "Consisting of Jason, Abdullah, and Kevin",
                             "                                     ",
                             "                                     ",
                             "Music were procured using online sites",
                             "                                     ",
                             "                                     ",
                             "Game lore, planning was done by Kevin",
                             "                                     ",
                             "                                     ",
                             "Game mechanics and designs were possible",
                             "                                     ",
                             "                                     ",
                             "due to Jason and Abdullah. ",
                             "                                     ",
                             "                                     ",
                             "Thank you to all that performed game testing",
                             "                                     ",
                             "                                     ",
                             "If this game taught us one thing...  ",
                             "                                     ",
                             "                                     ",
                             "It would be the power of teamwork    ",
                             "                                     ",
                             "                                     ",
                             "This game was dedicated to Johnny Appleseed",
                             "                                     ",
                             "                                     ",
                             "from whom we were given inspiration. ",
                             "                                     ",
                             "                                     ",
                             "Thank you.",
                             "                                     ",
                             "                                     ",};
        Queue<String> queue = new LinkedList<String>();

        ClipControl runner = new ClipControl();
        
        runner.setSong(4);
        try {
            runner.load();
        } catch (Exception e) {
            System.err.println("err");
        }
        Thread thread = new Thread(runner);
        thread.start();
        TileMap.clearScreen();
        System.out.println("YOU WIN");
        for (int i = 0; i < credits.length - 4; i++) {
            
            TileMap.clearScreen();
            if (i > 12) {
                System.out.println(display);
            }
            queue.add(credits[i]);
            System.out.println(queue.peek());
            queue.remove();
            queue.add(credits[i + 1]);
            System.out.println(queue.peek());
            queue.remove();
            queue.add(credits[i + 2]);
            System.out.println(queue.peek());
            queue.remove();
            queue.add(credits[i + 3]);
            System.out.println(queue.peek());
            queue.remove();
            queue.add(credits[i + 4]);
            System.out.println(queue.peek());
            queue.remove();
            try {
                Thread.sleep(1500);
            } catch (Exception e) {
                //TODO: handle exception
            }

        }
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        thread.interrupt();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.exit(0);
        
    }
    public static void lose() {
        TileMap.clearScreen();
        ClipControl runner = new ClipControl();
        runner.setSong(5);
        try {
            runner.load();
        } catch (Exception e) {
            System.err.println("err");
        }
        Thread thread = new Thread(runner);
        thread.start();
        try {
            Thread.sleep(1800);
        } catch (Exception e) {
            //TODO: handle exception
        }
        String[] things = {"As your life fades out of existence...", "You think to yourself...", "That your death wasn't in vain...", "You will be remembered by those you met along the way...", "Your friends and family...", "And with a bitter smile..." + "You close your eyes and think about...apples", "You... lost", "The END" };
        for (int i = 0; i < things.length; i++) {
            TileMap.clearScreen();
            
            System.out.println(things[i]);
            try {
                Thread.sleep(6000);
            } catch (Exception e) {
                
                //TODO: handle exception
            }
        }
        try {
            Thread.sleep(120000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        thread.interrupt();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.exit(0);
    }
    public static void main(String[] args) {
        win();
    }
}
