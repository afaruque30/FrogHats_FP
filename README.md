# Final Project - Frog Hats
#### Kevin Cheng, Abdullah Faruque, Jason Zhou

## Project Description
The main goal of the project to transform YoRPG into an actual game, playable in the terminal with
much more content. New content includes:
* More classes, with another tier of specialization (Protagonist -> Tank -> Fortress)
* A shop to buy goods that make you stronger
* More combat options
* Different unique levels to fight through to unlock the boss fight
* Sound effects
* A visual, interactive map
All in the terminal, so there technically aren't any graphics necessary. To start the game, copmpile and then run
```java Driver```. The resolution should be 100x55. Please play with your sound on!

### The Map and Navigation
The game map is made of a grid of "tiles", or spaces in the terminal. The terminal contains many
equally spaced "tiles" where a letter can take up, so by changing the background color of some of
these tiles, a visual game map can be created. The character represents a blue O on top of the map
screen. By typing the letters w, a, s, and d and pressing enter into the terminal, you can move the 
character up, left, down, and right on the game map. The game can't take multiple character inputs
at once, so "dd" won't move the character to the right twice.

### Combat
You fight an enemy by moving to the same space as an enemy in the game. When you start fighting it,
you can choose which move to do, which aren't just limited to damaging the enemy. Some moves may
also heal you or alter your stats. These depend on the class you choose when you decide to
specialize in when you progress in the game. When you specialize in a class, your stats change to
benefit you based on what class you chose. You also gain different attack types with different
effects, also based on the class. 

### Map Features
On the map, there are icons to represent monsters, entrances to dungeons with different levels, and
one for a shop. Move into the same tile as the icon to "enter" a new scene with the new map or
dialogue, with directions and controls to decide what to do in each situation. In the shop, there
are different artifacts that are tailored to affect different stats. You can check what each item
does by typing ```info``` in game. There are seven different items you can buy, unlocked after
killing two monsters.


### Quests
Apple Unleashed v6 update presents quests! These quests are fun, and give hidden items and perks

KillQuest: This quest is given by the NPC on stage 1 the farthest to the right. It is unlocked by killing all 
           the mobs in stage one. He asks you for a map, which is rewarded in AppleQuest, and gives you an artifact 
           for ArtifactQuest, as well as a passcode for the HutMan quest

AppleQuest: Scattered around the map on levels 1 and 2 are 4 apples. Give this so Sammy on stage2 for a map required in KillQuest

ArtifactQuest: This quest is given by Elena on stage 1. You need an artifact which is given by Johnny in KillQuest. 
               Elena rewards you with a key, required to advance to stage 3. 

Guard Quest: You must type in the correct password given by Johnny in KillQuest (piglet), he will give a book and leave.

HutMan Quest: Dufus requires his book, given to you by Guard. He gives a ??? piece required to complete the ??? given by shop 
              to survive the boss fight.



### Player Classes

Subclasses:
(Specials unlocked at level 5)


Archer:
  Base:
    - 5 Defense
    - 75 HP
    - 40 strength
    - 1 attack attackRating
    - 50 Speed
  Sniper: (attack once every 2 turns)
    - 10 Defense
    - 75 HP
    - 100 Strength
    - Speed +20
    - 1 attack Rating
    Special:
      -Head shot: 30% to instakill, 1% for bosses
  Gunner:
    - 10 defense
    - 100 HP
    - Speed -20
    - 1 attack rating
    - 60 strength
    Special:
      - RRRRRRRRRRRRRRRRRRM: 90% to shoot three bullets do normal damage 10% to jam for 3 turns


Swordsman:
  Paladin:
    - 150 HP
    - 20 Defense
    - Speed += 5
    - 1.5 Attack Rating 
    - 50 strength
    Special: 
    - Holy Strike: 30% chance to ignore armor!
  Barbarian:
    - 125 HP
    - 10 Defense
    - 1.4 Attack Rating 
    - 70 strength
    - Speed += 10
    Special:
      - Bloodlurst: For every 5% of HP lost, deal 2% more damage

Tank:
  - 20 defense
  - 20 strength
  - 0.3 attack rating
  - 200 health
  - 20 speed
  Special: Sheild O' Life: Heal 20 HP (cannot exceed current health)
  Tonk:
    - 30 defense
    - 25 strength
    - 0.4 attack rating
    - 300 health
    - 15 speed
    - Special: Taunt: Next two attacks, monster can 50% chance of missing (cooldown 4 turns) <-- not implemented
  Fortress:
    - 50 defense
    - 5 strength
    - 0.3 attack rating 
    - 500 health 
    - 5 speed 
    - Special: Shield Rain: Does 20 true damage

Wizard:
    - 65 health
    - 5 defense
    - 1.5 attack rating 
    - 100 strength
    - 15 speed
    Special: Vortex Summoning
    - Deal an extra 15 true damage

    Arcane Wizard: 
    - 60 health 
    - 6 defense 
    - 1.7 attack rating 
    - 110 strength
    - 10 speed 
    Special: N/A

    Necromancer: 
    - 70 health 
    - 10 defense 
    - 1.4 attack rating 
    - 50 strength 
    - 15 speed 
    Special: Undead: Summon an undead (up to two). Undeads have health and attack scaled to wizard lvl

<<<<<<< HEAD
#### Questing

=======
### Questing
Throughout the map, there are certain tiles that are entities on the map that aren't enemies. These
are quest givers, who ask you to do something for some sort of reward. 
>>>>>>> 740f72a7dd18a4090cc5773559877bc2edf2f106
