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
        //goToJail() method needs to be added in Player
        //p.goToJail
    }

    @Override
    public void doubleRent(){}
    
}
