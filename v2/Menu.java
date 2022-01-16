public class Menu implements Input{
    
    //Settings
    private boolean sound;
    private String display;

    public Menu() {
        sound = true;
    }

    public void loadMenu() {
        display = "\t\t\t 1." + Constants.MenuDialogue.MENU_OPTION_ONE;
        display += "\n\t\t       2." + Constants.MenuDialogue.MENU_OPTION_TWO;
        display += "\n\t\t     3." + Constants.MenuDialogue.MENU_OPTION_THREE;

    }

    public void update() {
        System.out.println(display);
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.loadMenu();
        menu.update();
    }
}
