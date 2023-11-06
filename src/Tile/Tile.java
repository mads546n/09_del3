package Tile;

import Main.Player;

public abstract class Tile {

    private int location;

    public final String icon;

    private String name;

        public Tile(int location, String name, String icon){
        this.location = location;
        this.name = name;
        this.icon = icon;
    }

    public int getLocation(){
        return location;
    }

    public String getName(){
        return name;
    }

    public abstract Player getOwendBy();

    public abstract void action(Player p, Tile[] tiles);

}
