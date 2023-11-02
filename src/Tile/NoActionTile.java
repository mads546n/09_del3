package Tile;

import Main.Player;

public class NoActionTile extends Tile{

    public NoActionTile(int location, String name) {
        super(location, name);
    }

    @Override
    public Player getOwendBy() {
        return null;
    }

    @Override
    public void action(Player p, Tile[] tiles) {}
    
}
