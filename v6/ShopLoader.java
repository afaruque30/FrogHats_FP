
import constants.*;

public enum ShopLoader {
  RING(new String[] {
      BColor.BLACK.toString() + FColor.RED.toString() + "    ___   ",
      BColor.BLACK.toString() + FColor.RED.toString() + "   / \\ \\  ",
      BColor.BLACK.toString() + FColor.RED.toString() + " / /  | | ",
      BColor.BLACK.toString() + FColor.RED.toString() + " | | / /  ",
      BColor.BLACK.toString() + FColor.RED.toString() + "  \\_/_/   ",
      BColor.BLACK.toString() + FColor.RED.toString() + "          "
  }),
  RELIC(new String[] {
      BColor.BLACK.toString() + FColor.PURPLE.toString() + "   ____   ",
      BColor.BLACK.toString() + FColor.PURPLE.toString() + "  |~~~~|  ",
      BColor.BLACK.toString() + FColor.PURPLE.toString() + "  |~~~~|  ",
      BColor.BLACK.toString() + FColor.PURPLE.toString() + "  \\_  _/  ",
      BColor.BLACK.toString() + FColor.PURPLE.toString() + "    ||    ",
      BColor.BLACK.toString() + FColor.PURPLE.toString() + "   /__\\   "
  }),
  GEM(new String[] {
      BColor.BLACK.toString() + FColor.GREEN.toString() + "  ______  ",
      BColor.BLACK.toString() + FColor.GREEN.toString() + " /  __  \\ ",
      BColor.BLACK.toString() + FColor.GREEN.toString() + " | /  \\ | ",
      BColor.BLACK.toString() + FColor.GREEN.toString() + " | \\__/ | ",
      BColor.BLACK.toString() + FColor.GREEN.toString() + " \\______/ ",
      BColor.BLACK.toString() + FColor.GREEN.toString() + "          "
  }),
  HEART(new String[] {
      BColor.BLACK.toString() + FColor.BLUE.toString() + "   _  _   ",
      BColor.BLACK.toString() + FColor.BLUE.toString() + "  / \\/ \\  ",
      BColor.BLACK.toString() + FColor.BLUE.toString() + "  \\    /  ",
      BColor.BLACK.toString() + FColor.BLUE.toString() + "   \\  /   ",
      BColor.BLACK.toString() + FColor.BLUE.toString() + "    \\/    ",
      BColor.BLACK.toString() + FColor.BLUE.toString() + "          "
  }),
  RABBIT(new String[] {
      BColor.BLACK.toString() + FColor.YELLOW.toString() + "     __   ",
      BColor.BLACK.toString() + FColor.YELLOW.toString() + "    |  |  ",
      BColor.BLACK.toString() + FColor.YELLOW.toString() + "    |  |  ",
      BColor.BLACK.toString() + FColor.YELLOW.toString() + "   /  /   ",
      BColor.BLACK.toString() + FColor.YELLOW.toString() + "  \\\\\\/    ",
      BColor.BLACK.toString() + FColor.YELLOW.toString() + "          "
  }),
  UN(new String[] {
      BColor.BLACK.toString() + FColor.WHITE.toString() + "   ????   ",
      BColor.BLACK.toString() + FColor.WHITE.toString() + "  ?    ?  ",
      BColor.BLACK.toString() + FColor.WHITE.toString() + "     ??   ",
      BColor.BLACK.toString() + FColor.WHITE.toString() + "    ?     ",
      BColor.BLACK.toString() + FColor.WHITE.toString() + "          ",
      BColor.BLACK.toString() + FColor.WHITE.toString() + "    ?     "
  });

  public final String[] image;

  private ShopLoader(String[] image) {
    this.image = image;
  }

}
