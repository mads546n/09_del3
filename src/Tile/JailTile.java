package Tile;

import Main.Player;

public class JailTile extends Tile{

    public JailTile(int location, String icon) {
        super(location, "Jail", icon);
    }

    @Override
    public Player getOwendBy() {
        return null;
    }

    @Override
    public void action(Player p, Tile[] tiles) {
        //goToJail() method needs to be added in Player
        //p.goToJail
    }
    
}
