import java.lang.System.Logger.Level;
import mapentities.*;
import input.InputThing;


public class Menu implements InputThing {
    public enum LEVEL {
        MENU,
        SETTINGS,
        INSTRUCTIONS,
    }
    //Settings
    private boolean sound;
    private boolean startGame;
    private String display;
    private LEVEL level;
    private String input;

    public Menu() {
        sound = true;
        startGame = false;
        level = LEVEL.MENU;
        input = "";
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
        TileMap.clearScreen();
        System.out.println(display);
    }

    public void load(Thread thread) {
        while(!startGame) {
            switch (level) {
                case MENU: 
                    loadMenu();
                    update();
                    input = receiveInput();
                    
                    if (input.equals("1")) {startGame = true;}
                    if (input.equals("2")) level = LEVEL.SETTINGS;
                    if (input.equals("3")) level = LEVEL.INSTRUCTIONS;
                    break;
                case SETTINGS:
                    loadSettings();
                    update();
                    input = receiveInput();
                    if (input.equals("b")) level = LEVEL.MENU;
                    if (input.equals("music")) {
                        thread.interrupt();
                    }
                    break;
                case INSTRUCTIONS:
                    loadInstructions();
                    update();
                    input = receiveInput();
                    if (input.equals("b")) level = LEVEL.MENU;
                    break;
                    
            }
    
        }
        
    }
}
