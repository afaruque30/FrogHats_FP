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
All in the terminal, so there technically aren't any graphics necessary. To start the game, 
```java Driver```.

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

### Questing
Throughout the map, there are certain tiles that are entities on the map that aren't enemies. These
are quest givers, who ask you to do something for some sort of reward. 
