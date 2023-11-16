package Tile;

import Main.Player;
import UI.UI;

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
        UI.printBord();
        ChanceCard.landOn(p);
    }

    @Override
    public void buyFromPlayer(Player p){}

    @Override
    public void doubleRent(){}
    
}