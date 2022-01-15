// IGNORE THIS PLZ

public class Stuff {
  public static void main(String[] args) {
    String test = "";
    for (int i = 0; i < 20; i++) {
      test += "\n";
      for (int e = 0; e < Constants.Screen.MAX_WIDTH_NORMAL; e++) {
        test += "▅";
      }

    }

    System.out.println("\033[0;31m" + test);

  }
}
