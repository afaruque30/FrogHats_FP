public class Driver {
  public static void main(String[] args) throws Exception, InterruptedException {
    //runs the game here
    Map gameMap = new Map();
    TestingCharacter charlie = new TestingCharacter();
    gameMap.load(Constants.Levels.floorOne, charlie);
    Runtime.getRuntime().exec("clear");

    // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
    gameMap.update();
    
    //ayyo is that ur brother
   
  
  }
}
