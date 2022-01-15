

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
        clear();
        String test = "";
        for (int i = 0; i < this.map.length; i++) {
            if (i % Constants.Screen.maxWidthNormal == 0) {
                test += "\n";
            }
            test += this.map[i];
            
        }
        System.out.println(test);
    }
    //
    public void right(Character character) {
        String temp = this.map[character.position + 1];
        this.map[character.position + 1] = this.map[character position];
        this.map[character.position] = temp;
    }
    
}
