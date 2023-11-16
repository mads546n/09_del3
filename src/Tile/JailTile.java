package Tile;

import Main.Player;
import UI.UI;

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
        UI.printBord();
        //goToJail() method needs to be added in Player
        //p.goToJail
    }

    @Override
    public void doubleRent(){}
    
}
