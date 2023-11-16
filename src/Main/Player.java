package Main;

import Tile.TileManeger;
import UI.UI;

public class Player {

    Die die = new Die(6);
    
    private char symbol;
    private int wallet;
    private String name;
    private int location;

    public Player(char symbol, int wallet) {
        this.symbol = symbol;
        this.wallet = wallet;
        if(symbol == 'C'){
           this.name = "Cat"; 
        }else if(symbol == 'B'){
            this.name = "Boat";
        }else if(symbol == 'R'){
            this.name = "Racecar";
        }else if(symbol == 'D'){
            this.name = "Dog";
        }
        location = 0;
    }

    public void roll(){
        TileManeger.icons[location].moveFrom(symbol);
        int roll = die.rollDie();
        location = location + roll;
        if(location > 23){
            location = location - 24;
            wallet = wallet + 2;
            UI.print(9);
        }
        TileManeger.icons[location].moveTo(symbol);
        TileManeger.tiles[location].action(this);
        UI.print(11, location);
        UI.printPlayer(this);
    }

    public void deposit(int amount) {
        wallet += amount;
    }

    public boolean check(int amount) {
        if(wallet < amount) {
            return false;
        } else {
            wallet -= amount; 
            return true;
        }
    }

    public char getSymbol(){
        return symbol;
    }

    public int getWallet(){
        return wallet;
    }

    public String getName(){
        return name;
    }

    public void lose() {
        UI.printL();
        GameRunner.gameOver = true;
    }
    
}