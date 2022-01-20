package shop;
import constants.*;
public enum ShopLoader {
  RING (  new String[] {
         BColor.WHITE + "" + FColor.RED + 
         "          ",
         "    ██    ",
         "   █  █   ",
         "   █  █   ",
         "    ██    ",
         "          "
  }),
  RELIC(new String[] {
    "          ",
    "    ██    ",
    "   █  █   ",
    "   █  █   ",
    "    ██    ",
    "          "
}),
  GEM  (new String[] {
    "          ",
    "    ██    ",
    "   █  █   ",
    "   █  █   ",
    "    ██    ",
    "          "
}),
  HEART(new String[] {
    "          ",
    "    ██    ",
    "   █  █   ",
    "   █  █   ",
    "    ██    ",
    "          "
}),
  RABBIT(new String[] {
    "          ",
    "    ██    ",
    "   █  █   ",
    "   █  █   ",
    "    ██    ",
    "          "
}),
  UN(new String[] {
    "          ",
    "    ██    ",
    "   █  █   ",
    "   █  █   ",
    "    ██    ",
    "          "
});

  public final String[] image;

  private ShopLoader(String[] image) {
    this.image = image;
  }




}
