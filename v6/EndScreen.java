import mapentities.TileMap;
import music.ClipControl;

public class EndScreen {
    public static void win() {
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
        while (true) {
            
        }
        
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
        String[] things = {"As your life fades out of existence...", "You think to yourself...", "That your death wasn't in vain...", "You will be remembered by those you met along the way...", "Your friends and family...", "And with a bitter smile..." + "You close your eyes and float away...", "The END" };
        for (int i = 0; i < things.length; i++) {
            TileMap.clearScreen();
            
            System.out.println(things[i]);
            try {
                Thread.sleep(6000);
            } catch (Exception e) {
                
                //TODO: handle exception
            }
        }
        while(true) {

        }
    }
    public static void main(String[] args) {
        win();
    }
}
