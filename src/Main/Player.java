package Main;

import java.util.ArrayList;
import java.util.List;
import Tile.TileManeger;
import UI.UI;

public class Player {

    Die die = new Die(6);
    
    private char symbol;
    private int wallet;
    private String name;
    private int location;
    private boolean chanceOnNextTurn;
    private int hasOutOfJailCard;
    private boolean inJail;
    private boolean passedStart;
    private boolean payedRent;
    private boolean buyTile;
    private List<Integer> msg = new ArrayList<>();
    private int dieroll;

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
        chanceOnNextTurn = false;
    }

    public void printTurn(){

        UI.printBord();

        if(dieroll != 0){
            UI.printDieRoll(dieroll);
            dieroll = 0;
        }

        if(passedStart){
            UI.print(9);
            passedStart = false;
        }
        if(msg.size() != 0){
            for(int i = 0; i < msg.size(); i++){
                UI.printChance(msg.get(i));
            }
            msg = new ArrayList<>();
        }
        if(inJail){
           UI.print(13); 
        }else{
            UI.print(11, location);
        }

        if(payedRent){
            UI.print(11);
            payedRent = false;
        }else if(buyTile){
            UI.print(10);
            buyTile = false;
        }

        UI.printPlayer(this);

    }

    public void roll(){
        if(inJail){
            if(hasOutOfJailCard > 0){
                UI.print(12);
                inJail = false;
                hasOutOfJailCard--;
                int roll = die.rollDie();
                dieroll = roll;
                roll(roll);
            }else if(wallet > 0){
                UI.print(13);
                if(GameRunner.scanner.hasNextLine()){
                    String input = GameRunner.scanner.nextLine();
                    if(input.equals("yes")){
                        wallet--;
                        inJail = false;
                        hasOutOfJailCard--;
                        int roll = die.rollDie();
                        dieroll = roll;
                        roll(roll);
                    }
                }
            }
        }else if(!chanceOnNextTurn){
            int roll = die.rollDie();
            dieroll = roll;
            roll(roll);
        }else if(chanceOnNextTurn){
            TileManeger.icons[location].moveFrom(symbol);
            int temp = location;
            loop:
            for(int i = 0; i < 23; i++){
                if(TileManeger.tiles[temp].getOwendBy() == TileManeger.canBuy){
                    location = temp;
                    chanceOnNextTurn = false;
                    roll(0);
                    break loop;
                }
                temp++;
                if(temp == 24){
                    temp = 0;
                }
            }
            if(chanceOnNextTurn){
                loop:
                for(int i = 1; i < 3; i++){
                    temp = location + i;
                    if(temp == 24){
                        temp = 0;
                    }
                    if(TileManeger.tiles[temp].getOwendBy() != null){
                        location = temp;
                        TileManeger.icons[location].moveTo(symbol);
                        TileManeger.tiles[location].buyFromPlayer(this);
                        chanceOnNextTurn = false;
                        break loop;
                    }
                }
            }
        }
    }

    public void roll(int roll){
        TileManeger.icons[location].moveFrom(symbol);
        location = location + roll;
        if(location > 23){
            location = location - 24;
            wallet = wallet + 2;
            passedStart();
        }
        TileManeger.icons[location].moveTo(symbol);
        TileManeger.tiles[location].action(this);
    }

    public void deposit(int amount) {
        wallet += amount;
    }

    public boolean check(int amount) {
        if(wallet < amount) {
            return false;
        } else {
            wallet = wallet - amount; 
            return true;
        }
    }

    public void getsJailCard(){
        hasOutOfJailCard++;
    }

    public void moveToStart(){
        location = 0;
        wallet = wallet + 2;
        passedStart();
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
        chanceOnNextTurn = true;
    }

    public void goToJail(){
        inJail = true;
    }

    public void passedStart(){
        passedStart = true;
    }

    public void payedRent(){
        payedRent = true;
    }

    public void buyTile(){
        buyTile = true;
    }

    public void chanceMsg(int i){
        msg.add(i);
    }

    public void lose() {
        UI.printL();
        GameRunner.gameOver = true;
    }
    
}