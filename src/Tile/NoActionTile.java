package Tile;

import Main.Player;
import UI.UI;

public class NoActionTile extends Tile{

    public NoActionTile(int location, String name, Icon icon) {
        super(location, name, icon);
    }

    @Override
    public Player getOwendBy() {
        return null;
    }

    @Override
    public void action(Player p){
        UI.printBord();
    }

    @Override
    public void doubleRent(){}

    @Override
    public void buyFromPlayer(Player p){}
    
}
