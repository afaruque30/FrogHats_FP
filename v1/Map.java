

public class Map {

    private String[] map = {};
    //should this be void or string
    public Map() {
        
    }

    public void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    public void load(String[] map) {
        this.map = new String[map.length];
        for (int i = 0; i < map.length; i++) {
            this.map[i] = map[i];
        }
    }

    public void update() {
        String test = "";
        for (int i = 0; i < this.map.length; i++) {
            if (i % Constants.Screen.maxWidthNormal == 0) {
                test += "\n";
            }
            test += this.map[i];
            
        }
        System.out.println(test);
    }
    //should take a Character
    public void right() {
        String temp = this.map[6];
        this.map[6] = this.map[5];
        this.map[5] = temp;
    }
    public static void main(String[] args) {
        Map map = new Map();
        String[] leve = {"h", "h", "h", "h", "h", "j", "h", "h"};
        map.load(leve);
        map.clear();
        map.update();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("error");
        }
        map.clear();
        map.right();
        map.update();
    }
}
