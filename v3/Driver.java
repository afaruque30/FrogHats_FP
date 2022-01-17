import classes.Protagonist;
import classes.*;

public class Driver {
    // All the characters involved
    Protagonist protag = new Protagonist();
    
    public static void main(String[] args) {
        ClassPrestiges classes = new ClassPrestiges();
        Driver driver = new Driver();
        Map gameMap = new Map();
        Menu menu = new Menu();

        ClipControl runner = new ClipControl();
        runner.setSong(0);
        Thread thread = new Thread(runner);

        System.out.println("\033[?25l");
    
        
        Monster monster = new Monster("org");
        //runs the game here
        
        
        // thread.start();
        // menu.load();
        // classes.pickAClass(driver);
        // thread.interrupt();
        
        TestingCharacter charlie = new TestingCharacter();
        gameMap.load(Constants.Levels.floorOne, charlie);
        gameMap.update();
        
        gameMap.interact(charlie);
        gameMap.update();
        
        System.out.println("\033[?25h");
        System.out.println(Constants.Backgrounds.BLACK_BACKGROUND);
        
        
    }
}