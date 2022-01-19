package classes;
public enum ShopLoader {
  RING ("   R      "),
  RELIC("   RE     "),
  GEM  ("    G      "),
  HEART("    H    "),
  RABBIT("   RA    "),
  UN(" U" ),
  SOLD(" S");

  public final String image;

  private ShopLoader(String image) {
    this.image = image;
  }




}
