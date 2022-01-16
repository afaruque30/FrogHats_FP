public class Menu implements Input{
    public enum LEVEL {
        MENU,
        SETTINGS,
        INSTRUCTIONS,
    }
    //Settings
    private boolean sound;
    private String display;
    private LEVEL level;

    public Menu() {
        sound = true;
        level = LEVEL.MENU;
    }

    public void loadMenu() {
        display = "\t\t\t 1." + Constants.MenuDialogue.MENU_OPTION_ONE;
        display += "\n\n\t\t       2." + Constants.MenuDialogue.MENU_OPTION_TWO;
        display += "\n\n\t\t     3." + Constants.MenuDialogue.MENU_OPTION_THREE;

    }

    //utilizes ternary operator
    public void loadSettings() {
        display = Constants.MenuDialogue.SETTINGS_ONE;
        display += (sound) ? " ON." : " OFF.";
    }

    public void loadInstructions() {
        display = Constants.MenuDialogue.INSTRUCTIONS;
    }

    public void update() {
        Map.clear();
        System.out.println(display);
    }

    public void load() {
        switch (level) {
            case MENU: 
                loadMenu();
                update();
                break;
            case SETTINGS:
                loadSettings();
                update();
                break;
            case INSTRUCTIONS:
                loadInstructions();
                update();
                break;
                
        }
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.loadMenu();
        menu.update();
    }
}
