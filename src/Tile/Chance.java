package Tile;

import Main.Player;

public class Chance extends Tile{

    public Chance(int location, Icon icon) {
        super(location, "Chance Tile", icon);
    }

    @Override
    public Player getOwendBy() {
        return null;
    }

    @Override
    public void action(Player p) {
        icon.moveTo(p.getSymbol());
        //landOnChance() method needs to be added in Player
        //p.landOnChance();
    }

    @Override
    public void doubleRent(){}
    
}