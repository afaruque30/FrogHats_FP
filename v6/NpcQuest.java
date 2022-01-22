import classes.Protagonist;

public class NpcQuest {
    public static void killQuest(Protagonist protag) {
        if (protag.getKills() < 5) {
            System.out.println("Hmmm...the door is locked...");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else if (protag.items[3] == 0 && protag.visits[0] < 2) {
            System.out.println("Phew, thank you for killing the mobs here.\n I lost one of my heavenly maps. Find it and you shall be rewarded");
            protag.visits[0]++;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else if (protag.items[3] == 0) {
            System.out.println("I hear that if you if you say piglet 3 times to the farmer\n he'll give u something nice. Anyways go find my map");
            
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } 
            
    }
        
}

