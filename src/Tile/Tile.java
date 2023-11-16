package Tile;

import Main.Player;

public abstract class Tile {

    private int location;

    public Icon icon;

    private String name;

    public Tile(int location, String name, Icon icon){
        this.location = location;
        this.name = name;
        this.icon = icon;
    }

    public abstract void buyFromPlayer(Player p);

    public int getLocation(){
        return location;
    }

    public String getName(){
        return name;
    }

    public void moveFrom(Player p){
        icon.moveFrom(p.getSymbol());
    }

    public abstract Player getOwendBy();

    public abstract void doubleRent();

    public abstract void action(Player p);

}
