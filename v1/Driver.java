import classes.*;
import classes.monsters.*;

public class Driver {
  public static void main(String[] args) {
    Monster monster = new Monster("org");
    //runs the game here
    Map gameMap = new Map();
    TestingCharacter charlie = new TestingCharacter();
    gameMap.load(Constants.Levels.floorOne, charlie);
    final String ANSI_CLS = "\u001b[2J";
    final String ANSI_HOME = "\u001b[H";
    System.out.print(ANSI_CLS + ANSI_HOME);
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
    
  }
}
