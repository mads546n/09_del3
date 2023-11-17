package Tile;

import Main.Player;

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
    }

    @Override
    public void doubleRent(){}

    @Override
    public void buyFromPlayer(Player p){}
    
}
