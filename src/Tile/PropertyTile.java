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
        owendBy = TileManeger.canBuy;
    }

    @Override
    public void doubleRent(){
        if(owendBy == TileManeger.tiles[partnerLocation].getOwendBy()){
            rent = price*2;
            icon.priceUpdate(rent);
        }else{
            rent = price;
        }
    }

    @Override
    public void action(Player p) {

        if(!owend){
            if(p.check(price)){
                owend = true;
                owendBy = p;
                icon.newOwner(p.getSymbol());
                doubleRent();
                TileManeger.tiles[partnerLocation].doubleRent();
                p.buyTile();
            }else{
                int temp = p.getWallet();
                p.deposit(-temp);
                p.lose();
            }
        }else if(p != owendBy){
            if(p.check(rent)){
                owendBy.deposit(rent);
                p.payedRent();
            }else{
                int temp = p.getWallet();
                p.deposit(-temp);
                owendBy.deposit(temp);
                p.lose();
            }
        }
    }

    @Override
    public void buyFromPlayer(Player p){

        if(p.check(price)){
            owendBy.deposit(price);
            owendBy = p;
            icon.newOwner(p.getSymbol());
            doubleRent();
            TileManeger.tiles[partnerLocation].doubleRent();
            p.buyTile();
        }else{
            int temp = p.getWallet();
            p.deposit(-temp);
            owendBy.deposit(temp);
            p.lose();
        }

    }

    @Override
    public Player getOwendBy() {
        return owendBy;
    }
    
}
