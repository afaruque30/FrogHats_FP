public class Map {

    public 

    public void load(String[] map) {
        String test = "";
        for (int i = 0; i < map.length; i++) {
            test += map[i];
            if (i % Constants.Screen.maxWidthNormal == 0) {
                test += "\n";
            }
        }
        System.out.println(test);
    }
}
