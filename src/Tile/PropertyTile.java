package Tile;

import Main.Player;

public class PropertyTile extends Tile{

    private int price;

    private int rent;

    private int partnerLocation;

    private boolean owend;

    private Player owendBy;

    public PropertyTile(int location, String name, Icon icon, int price, int partnerLocation){
        super(location, name, icon);
        this.price = price;
        this.partnerLocation = partnerLocation;
        owend = false;
    }

    @Override
    public void doubleRent(){
        rent = price*2;
    }

    @Override
    public void action(Player p) {

        icon.moveTo(p.getSymbol());

        if(!owend){
            if(p.check(price)){
                owend = true;
                owendBy = p;
                if(TileManeger.tiles[partnerLocation].getOwendBy() == p){
                    doubleRent();
                    TileManeger.tiles[partnerLocation].doubleRent();
                }else{
                    rent = price;
                }
            }else{
                p.lose();
            }
        }else if(p != owendBy){
            if(p.check(rent)){
                owendBy.deposit(rent);
            }else{
                p.lose();
            }
        }
    }

    @Override
    public Player getOwendBy() {
        return owendBy;
    }
    
}
