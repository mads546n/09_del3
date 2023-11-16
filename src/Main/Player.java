package Main;

import java.util.Scanner;
import Tile.TileManeger;
import UI.UI;

public class Player {

    Die die = new Die(6);
    
    private char symbol;
    private int wallet;
    private String name;
    private int location;
    private int chanceOnNextTurn;
    private int hasOutOfJailCard;

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
        chanceOnNextTurn = 100;
    }

    public void roll(){
        if(chanceOnNextTurn == 100){
            int roll = die.rollDie();
            roll(roll);
        }else if(chanceOnNextTurn == 0){
            TileManeger.icons[location].moveFrom(symbol);
            int temp = location;
            for(int i = 0; i < 23; i++){
                if(TileManeger.tiles[temp].getOwendBy() == TileManeger.canBuy){
                    if(temp < location){
                        wallet = wallet + 2;
                        UI.print(9);
                    }
                    location = temp;
                    TileManeger.icons[location].moveTo(symbol);
                    TileManeger.tiles[location].action(this);
                    UI.print(11, location);
                    UI.printPlayer(this);
                    chanceOnNextTurn = 100;
                }
                temp++;
                if(temp == 24){
                    temp = 0;
                }
            }
            if(chanceOnNextTurn == 0){
                for(int i = 1; i < 3; i++){
                    temp = location + i;
                    if(temp == 24){
                        temp = 0;
                    }
                    if(TileManeger.tiles[temp].getOwendBy() != null){
                        location = temp;
                        TileManeger.icons[location].moveTo(symbol);
                        TileManeger.tiles[location].buyFromPlayer(this);
                    }
                }
                chanceOnNextTurn = 100;
            }
        }
    }

    public void roll(int roll){
        TileManeger.icons[location].moveFrom(symbol);
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

    public void getsJailCard(){
        hasOutOfJailCard++;
    }

    public void moveToStart(){
        location = 0;
        wallet = wallet + 2;
        UI.print(9);
    }

    public int getLocation(){
        return location;
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

    public void setChance(int x){
        chanceOnNextTurn = x;
    }

    public void lose() {
        UI.printL();
        GameRunner.gameOver = true;
    }
    
}