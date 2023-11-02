package Tile;

import Main.Player;

public class Chance extends Tile{

    public Chance(int location, String name) {
        super(location, name);
    }

    @Override
    public Player getOwendBy() {
        return null;
    }

    @Override
    public void action(Player p, Tile[] tiles) {
        //landOnChance() method needs to be added in Player
        //p.landOnChance();
    }
    
}