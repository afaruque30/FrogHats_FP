import classes.Protagonist;
import input.InputThing;

public class NpcQuest implements InputThing{
    public static void killQuest(Protagonist protag) {
        if (protag.getKills() < 1) {
            System.out.println("Hmmm...the door is locked...");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else if (protag.getKills() >= 1 && protag.visits[0] < 2 && protag.items[1] != 1) {
            System.out.println("Johnny: Phew, thank you for killing the mobs here.\nI lost one of my heavenly maps. Find it and you shall be rewarded");
            protag.visits[0]++;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else if (protag.getKills() >= 1  && protag.items[1] != 1) {
            System.out.println("Johnny: I hear that if you if you say piglet 3 times to the guard\nhe'll give u something nice. Anyways go find my map");
            
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else if (protag.items[1] == 1 && protag.visits[0] <= 2) {
            System.out.println("Johnny: Thank you soooo MUCH! I can finally dig up that treasure chest!\nAnyways, take this weird artifact...\nI hear that if you if you say piglet 3 times to the guard");
            protag.items[0] = 1;
            protag.visits[0]++;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else {
            System.out.println("Johnny: Have you tried the guard?");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
            
    }
    /**
     * Here describes the quest for apples, go find 4 apples so you can receive the lost map
     * @param protag
     */
    public static void appleQuest(Protagonist protag) {
        if (protag.apples != 4 && protag.visits[1] < 2) {
            System.out.println("Sammy: Howdy there, I happen to need some apples. If you find all of them I'll give you a reward");
            protag.visits[1]++;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else if (protag.apples != 4) {
            System.out.println("Sammy: Partner, stop bothering me until you find the apples please!");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else {
            System.out.println("Sammy: Cowbunga! Thank you so much, take this random map I found!");
            protag.items[1] = 1;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
    public static void artifactQuest(Protagonist protag) {
        if (protag.items[0] == 0 && protag.visits[2] < 2) {
            protag.visits[2]++;
            System.out.println("Elena: Sigh, I need an ancient artifact to finish this goggolbob potion. Can you find me one?");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else if(protag.items[0] == 0) {
            System.out.println("Elena: Wimples, Scarlats, Possumstinks, and poppgraps. Just need the artifact...");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else if (protag.visits[2] <= 2) {
            System.out.println("Elena: Here take this key I found, wonder where it goes.");
            protag.items[2] = 1;
            protag.visits[2]++;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else {
            System.out.println("Elena: Kablam! Wiggle-opum sizzle!");
            protag.items[2] = 1;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
    public static boolean guardInteraction(Protagonist protag) {
        System.out.println("Guard Winnow: Whats the password?");
        InputThing input = new InputThing() {
            @Override
            public String receiveInput() {
                // TODO Auto-generated method stub
                return InputThing.super.receiveInput();
            }
        };
        var in = input.receiveInput();
        if (in.equals("piglet")) {
            System.out.println("Guard Winnow: Nice to meet you sir, take this lost art book! I can finally leave!");
            protag.items[3] = 1;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
            return true;
        } else {
            System.out.println("Guard Winnow: INCORRECT");
        }
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        return false;
    }
       
    public static void hutMan(Protagonist protag) {
        if (protag.items[3] == 0 && protag.visits[3] < 2) {
            protag.visits[3]++;
            System.out.println("Dufus the Sage: I lost my sage wisdom book somewhere, young lad help an old man out");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else if(protag.items[3] == 0) {
            System.out.println("Dufus the Sage: I lost my sage wisdom book somewhere...");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else if (protag.visits[3] <= 2) {
            protag.visits[3]++;
            System.out.println("Dufus the Sage: Why thank you, take this special ???, find the other half for good luck");
            protag.items[4] = 1;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        } else {
            System.out.println("Dufus the Sage: I'm studying, please be quiet!");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
}

