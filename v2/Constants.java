public interface Constants {
    //Constants for the game


    //Hashmap for colors?
    public enum ColorsNames {
      BLACK,
      RED,
      GREEN,
      YELLOW,
      BLUE,
      PURPLE,
      CYAN,
      WHITE
    }
    public interface Colors {
      public static final String BLACK = "\033[0;30m";   // BLACK
      public static final String RED = "\033[0;31m";     // RED
      public static final String GREEN = "\033[0;32m";   // GREEN
      public static final String YELLOW = "\033[0;33m";  // YELLOW
      public static final String BLUE = "\033[0;34m";    // BLUE
      public static final String PURPLE = "\033[0;35m";  // PURPLE
      public static final String CYAN = "\033[0;36m";    // CYAN
      public static final String WHITE = "\033[0;37m";   // WHITE


    }
    public interface Screen {
      public final int MAX_WIDTH_NORMAL = 60;
      public final int MAX_HEIGHT_NORMAL = 60;
    }
    public interface Levels {
      public final String[] floorOne = {"G", "G", "G", "G", "G", "G", "E", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", 
                                        "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", 
                                        "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G",};
      public final String[] floorTwo = {};
      public final String[] floorThree = {};
      
    }
    public interface Construction {
      public final String Brick = "█";
    }
      

}
