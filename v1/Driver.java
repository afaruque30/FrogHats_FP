public class Driver {
  public static void main(String[] args) {
    //runs the game here
    Map gameMap = new Map();
    TestingCharacter charlie = new TestingCharacter();
    gameMap.load(Constants.Levels.floorOne, charlie);
    gameMap.clear();
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
