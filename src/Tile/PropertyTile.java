package Tile;

import Main.Player;
import UI.UI;

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
        icon.priceUpdate(rent);
    }

    @Override
    public void action(Player p) {

        if(!owend){
            if(p.check(price)){
                owend = true;
                owendBy = p;
                icon.newOwner(p.getSymbol());
                if(TileManeger.tiles[partnerLocation].getOwendBy() == p){
                    doubleRent();
                    TileManeger.tiles[partnerLocation].doubleRent();
                }else{
                    rent = price;
                }
                UI.printBord();
                UI.print(10);
            }else{
                int temp = p.getWallet();
                p.deposit(-temp);
                p.lose();
            }
        }else if(p != owendBy){
            if(p.check(rent)){
                owendBy.deposit(rent);
                UI.printBord();
                UI.print(11);
            }else{
                int temp = p.getWallet();
                p.deposit(-temp);
                owendBy.deposit(temp);
                p.lose();
            }
        }else{
            UI.printBord();
        }
    }

    @Override
    public Player getOwendBy() {
        return owendBy;
    }
    
}
