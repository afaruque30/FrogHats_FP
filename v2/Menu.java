public class Menu implements Input{
    
    //Settings
    private boolean sound;
    

    public Menu() {
        sound = true;
    }

    public void loadMenu() {
        
        System.out.println("\t\t\t 1." + Constants.MenuDialogue.MENU_OPTION_ONE);
        System.out.println("\n\t\t       2." + Constants.MenuDialogue.MENU_OPTION_TWO);
        System.out.println("\n\t\t     3." + Constants.MenuDialogue.MENU_OPTION_THREE);

    }

    public void update() {

    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.loadMenu();
    }
}
