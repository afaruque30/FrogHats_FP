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
All in the terminal, so there technically aren't any graphics necessary.

### The Map and Navigation
The game map is made of a grid of "tiles", or spaces in the terminal. The terminal contains many
equally spaced "tiles" where a letter can take up, so by changing the background color of some of
these tiles, a visual game map can be created.
The character represents a blue O on top of the map screen. By typing the letters w, a, s, and d
and pressing enter into the terminal, you can move the character up, left, down, and right on the
game map. The game can't take multiple character inputs at once, so "dd" won't move the character
to the right twice.

### Combat
You fight an enemy by moving to the same space as an enemy in the game. When you start fighting it,
you can choose which move to do, which aren't just limited to damaging the enemy. Some moves may
also heal you or alter your stats.
