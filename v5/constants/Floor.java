package constants;

import classes.Monster;
import classes.Ogre;
import mapentities.Location;

public enum Floor {
    ONE("Floor1.txt", new Object[][] {
        {new Location( 4,  4), Tile.MONSTER, new Monster[] {new Ogre()}},
        {new Location(15,  4), Tile.MONSTER, new Monster[] {new Ogre()}},
        {new Location(18, 55), Tile.MONSTER, new Monster[] {new Ogre()}},
        {new Location( 4, 46), Tile.MONSTER, new Monster[] {new Ogre()}},
        {new Location( 8, 47), Tile.MONSTER, new Monster[] {new Ogre()}},
        {new Location(17, 41), Tile.SHOP,    null}
    }),
    TWO("Floor2.txt", new Object[][] {
        {new Location( 4,  8), Tile.MONSTER, new Monster[] {new Ogre()}},
        {new Location( 4, 42), Tile.MONSTER, new Monster[] {new Ogre()}}, // supposed to be miniboss
        {new Location(17, 42), Tile.MONSTER, new Monster[] {new Ogre()}},
        {new Location(15, 23), Tile.MONSTER, new Monster[] {new Ogre()}},
        {new Location(10, 10), Tile.MONSTER, new Monster[] {new Ogre()}}
    }),
    THREE("Floor3.txt", new Object[][] {
        {new Location(14, 37), Tile.MONSTER, new Monster[] {new Ogre()}},
        {new Location( 5, 37), Tile.MONSTER, new Monster[] {new Ogre()}},
        {new Location( 9, 49), Tile.MONSTER, new Monster[] {new Ogre()}}  // supposed to be boss
    });

    private String filename;
    private Object[][] entities;

    private Floor(String filename, Object[][] entities) {
        this.filename = filename;
        this.entities = entities;
    }

    public String getFilename() {
        return this.filename;
    }

    public Object[][] getEntities() {
        return entities;
    }
}
