public class Map implements InputThing {
    private String[] map = {};
    private String currentBlock = "";
    private int posBlock = 0;

    private boolean normalInteaction = true;
    //should this be void or string
    public Map() {
        
    }

    public static void clear() {
        System.out.flush();
        System.out.println("\033[H\033[2J");
        
    }
    public void load(String[] map, TestingCharacter c) {
        this.map = new String[map.length];
        for (int i = 0; i < map.length; i++) {
            
            switch (map[i]) { //checks what map[i] is and acts accordingly
                case " ":
                    this.map[i] = Constants.Colors.GREEN + Constants.Construction.Brick;
                    break;
                case "B":
                    this.map[i] = Constants.Colors.BLACK + Constants.Construction.Brick;
                    break;
                case "Y":
                    this.map[i] = Constants.Colors.YELLOW + Constants.Construction.Brick;
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
    public void replaceOld(String type) {
        switch (type) {
            case Constants.Colors.YELLOW:
                map[posBlock] = Constants.Colors.YELLOW + Constants.Construction.Brick;
                break;
        }
    }
    public void interact(TestingCharacter character) {
        
        while (normalInteaction) {
            var move = receiveInput();
            switch (move) {
                case "w":
                    moveUp(character);
                    replaceOld(currentBlock);
                    update();
                    break;
                case "s":
                    moveDown(character);
                    replaceOld(currentBlock);
                    update();
                    break;
                case "a":
                    moveLeft(character);
                    replaceOld(currentBlock);
                    update();
                    break;
                case "d":
                    moveRight(character);
                    replaceOld(currentBlock);
                    update();
                    break;
                case "i":
                    moveUp(character);
                    moveUp(character);
                    update();
                    break;
                case "k":
                    moveDown(character);
                    moveDown(character);
                    update();
                    break;
                case "j":
                    moveLeft(character);
                    moveLeft(character);
                    update();
                    break;
                case "l":
                    moveRight(character);
                    moveRight(character);
                    update();
                    break;
                default:
                    update();
                    break;
            }
        }
    }
    public void moveRight(TestingCharacter character) {
        if (!((character.getPos() + 1) % (Constants.Screen.MAX_WIDTH_NORMAL) == 0)) {
            right(character);
        }
        
    }
    public void moveLeft(TestingCharacter character) {
        if (!((character.getPos()) % Constants.Screen.MAX_WIDTH_NORMAL == 0)) {
            left(character);
        }
        
    }
    public void moveUp(TestingCharacter character) {
        if (!((character.getPos()) < Constants.Screen.MAX_WIDTH_NORMAL)) {
            up(character);
        }
        
    }
    public void moveDown(TestingCharacter character) {
        down(character);
    }

    //Boundaries !
    private void right(TestingCharacter character) {

        String temp = this.map[character.getPos() + 1];
        posBlock = character.getPos() + 1;
        currentBlock = temp;

        this.map[character.getPos() + 1] = this.map[character.getPos()];
        this.map[character.getPos()] = temp;
        character.setPos(character.getPos() + 1);
    }
    private void left(TestingCharacter character) {
        String temp = this.map[character.getPos() - 1];
        this.map[character.getPos() - 1] = this.map[character.getPos()];
        this.map[character.getPos()] = temp;
        character.setPos(character.getPos() - 1);
    }
    private void up(TestingCharacter character) {
        String temp = this.map[character.getPos() - Constants.Screen.MAX_WIDTH_NORMAL];
        this.map[character.getPos() - Constants.Screen.MAX_WIDTH_NORMAL] = this.map[character.getPos()];
        this.map[character.getPos()] = temp;
        character.setPos(character.getPos() - Constants.Screen.MAX_WIDTH_NORMAL);
    }
    private void down(TestingCharacter character) {
        String temp = this.map[character.getPos() + Constants.Screen.MAX_WIDTH_NORMAL];
        this.map[character.getPos() + Constants.Screen.MAX_WIDTH_NORMAL] = this.map[character.getPos()];
        this.map[character.getPos()] = temp;
        character.setPos(character.getPos() + Constants.Screen.MAX_WIDTH_NORMAL);
    }
    
}
