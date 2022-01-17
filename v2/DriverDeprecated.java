import classes.*;
public class DriverDeprecated  {
  public static void main(String[] args) {
    System.out.println("\033[?25l");
    ClipControl runner = new ClipControl();
    Thread thread = new Thread(runner);
    
    thread.start();
    Menu menu = new Menu();
    Monster monster = new Monster("org");
    //runs the game here
    menu.load();
    Map gameMap = new Map();
    TestingCharacter charlie = new TestingCharacter();
    gameMap.load(Constants.Levels.floorOne, charlie);
    gameMap.update();
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(200);
      } catch (Exception e) {
        System.out.println("err");
      }
      gameMap.right(charlie);
      gameMap.update();
    }
    System.out.println("\033[?25h");
  
    thread.interrupt();
    
  }
}
