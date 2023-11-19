package Tile;

import Main.Player;

public class JailTile extends Tile{

    public JailTile(int location, Icon icon) {
        super(location, "Jail", icon);
    }

    @Override
    public Player getOwendBy() {
        return null;
    }

    @Override
    public void action(Player p) {
        p.goToJail();
    }

    @Override
    public void buyFromPlayer(Player p){}

    @Override
    public void doubleRent(){}
    
}
