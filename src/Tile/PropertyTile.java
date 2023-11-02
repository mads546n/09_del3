package Tile;

import Main.Player;

public class PropertyTile extends Tile{

    private int price;

    private int rent;

    private int partnerLocation;

    private boolean owend;

    private Player owendBy;

    public PropertyTile(int location, String name, int price, int partnerLocation){
        super(location, name);
        this.price = price;
        this.partnerLocation = partnerLocation;
        owend = false;
    }

    public void doubleOwn(Tile[] tiles, Player p){
        if(p == owendBy && p == tiles[partnerLocation].getOwendBy()){
            rent = price*2;
        }
    }

    @Override
    public void action(Player p, Tile[] tiles) {
        if(!owend){
            //have(int) method needs to be added in player
            //if(p.have(price)){
                owend = true;
                owendBy = p;
                if(tiles[partnerLocation].getOwendBy() == p){
                    rent = price*2;
                }else{
                    rent = price;
                }
            //}else{
                //add lose() method in Player
                //p.lose();
            //}
        }else if(p != owendBy){
            //if(p.have(rent)){
                //deposit(int) method needs to be added in Player
                //owendBy.deposit(rent);
            //}else{
                //p.lose
            //}
        }
    }

    @Override
    public Player getOwendBy() {
        return owendBy;
    }
    
}
