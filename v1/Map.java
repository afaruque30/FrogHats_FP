

public class Map {

    private String[] map = {};
    //should this be void or string
    public Map() {
        
    }

    public void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    public void load(String[] map, TestingCharacter c) {
        this.map = new String[map.length];
        for (int i = 0; i < map.length; i++) {
            
            switch (map[i]) {
                case "G":
                    this.map[i] = Constants.Colors.GREEN + Constants.Construction.Brick;
                    break;
                case "E":
                    this.map[i] = c.getColor() + Constants.Construction.Brick;
                    c.setPos(i);
                    break;
            }
            
            
        }
    }

    public void update() {
        clear();
        String test = "";
        for (int i = 0; i < this.map.length; i++) {
            if (i % Constants.Screen.MAX_WIDTH_NORMAL == 0) {
                test += "\n";
            }
            test += this.map[i];
            
        }
        System.out.println(test);
    }
    //Boundaries !
    public void right(TestingCharacter character) {
        String temp = this.map[character.getPos() + 1];
        this.map[character.getPos() + 1] = this.map[character.getPos()];
        this.map[character.getPos()] = temp;
        character.setPos(character.getPos() + 1);
    }
    public void left(TestingCharacter character) {
        String temp = this.map[character.getPos() + 1];
        this.map[character.getPos() + 1] = this.map[character.getPos()];
        this.map[character.getPos()] = temp;
        character.setPos(character.getPos() + 1);
    }
    public void up(TestingCharacter character) {
        String temp = this.map[character.getPos() + 1];
        this.map[character.getPos() + 1] = this.map[character.getPos()];
        this.map[character.getPos()] = temp;
        character.setPos(character.getPos() + 1);
    }
    public void down(TestingCharacter character) {
        String temp = this.map[character.getPos() + 1];
        this.map[character.getPos() + 1] = this.map[character.getPos()];
        this.map[character.getPos()] = temp;
        character.setPos(character.getPos() + 1);
    }
    
}
