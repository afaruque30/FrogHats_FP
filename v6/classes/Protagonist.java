package classes;
//coins, will add more features in next update



public class Protagonist extends Character{

  //power, defense, attackrating, health, speed, and special hehe!
  public int killCount = 0;

  // artifact, lost map, key, book, ??? from sage
  public int[] items = {0, 0, 0, 0, 0};

  //killQuest, appleQuest, elena, hut
  public int[] visits = {0, 0, 0, 0};

  //appleQuest
  public int apples = 0;

  public int[] artifacts = new int[6];
  public Protagonist() {
    super();
  }
  public Protagonist(String name) {
    super(name);
  }
  public Protagonist(int health, int strength, double attackRating, int defense, String name, int level) {
    super(health, strength, attackRating, defense, name, level);
  }

  public void update(int num) {
    if (num == 0) {
      this.strength += artifacts[0];
    } else if (num == 1) {
      this.defense += artifacts[1];
    } else if (num == 2) {
      this.attackRating += (double) (artifacts[2]);

    } else if (num == 3) {
      this.maxHealth += artifacts[3];
    } else if (num == 4) {
      this.speed += artifacts[4];
    } else if (num == 5) {

    }

    this.health = maxHealth;



  }
  public void kill() {
    this.killCount++;
  }
  public int getKills() {
    return this.killCount;
  }
  public void foundApple() {
    this.apples++;
  }

  public void artifactChange(int index) {
    artifacts[index] = Shop.boost[index];
   
  }




}
