package Tile;

import Main.Player;

public abstract class Tile {

    private int location;

    private String name;

        public Tile(int location, String name){
        this.location = location;
        this.name = name;
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
