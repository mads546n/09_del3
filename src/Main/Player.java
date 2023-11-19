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
            chanceOnNextTurn = false;
            UI.printChance(20);
            int input;
            inputloop:
            while(GameRunner.scanner.hasNextInt()){
                int roll = 0;
                input = GameRunner.scanner.nextInt();
                if(TileManeger.tiles[input-1].getOwendBy() == TileManeger.canBuy){
                    roll = (input-1) - location;
                }else{
                    boolean freeSpot = false;
                    loop:
                    for(int i = 0; i < 24; i++){
                        if(TileManeger.tiles[i].getOwendBy() == TileManeger.canBuy){
                            freeSpot = true;
                            break loop;
                        }
                    }
                    if(!freeSpot){
                        if(TileManeger.tiles[input-1].getOwendBy() != null){
                            if(check(TileManeger.tiles[input-1].getPrice(),TileManeger.tiles[input-1].getOwendBy())){
                                TileManeger.tiles[input-1].buyFromPlayer(this);
                                buyTile = true;
                            }
                            roll = (input-1) - location;
                        }
                    }
                }
                if(roll < 0){
                    roll = roll + 24;
                }
                if(roll != 0){
                    roll(roll);
                    break inputloop;
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

    public boolean check(int amount, Player p) {
        if(wallet < amount) {
            return lose(amount, p);
        } else {
            wallet = wallet - amount;
            if(p != null){
                p.deposit(amount);
            }
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

    public boolean lose(int amount, Player p) {
        UI.printBord();
        UI.printL();
        if(!GameRunner.advancedMode){
            p.deposit(wallet);
            wallet = 0;
            GameRunner.gameOver = true;
            return false;
        }else{
            int assets = wallet;
            wallet = 0;
            if(p != null){
                p.deposit(amount);
            }
            String strInput;
            int intInput;
            while(GameRunner.scanner.hasNextLine()){
                strInput = GameRunner.scanner.nextLine();
                loop:
                if(strInput.equals("yes")){
                    UI.owe(amount-assets);
                    while(GameRunner.scanner.hasNextInt()){
                        intInput = GameRunner.scanner.nextInt()-1;
                        if(TileManeger.tiles[intInput].getOwendBy() == this){
                            assets = assets + TileManeger.tiles[intInput].getPrice();
                            TileManeger.tiles[intInput].buyFromPlayer(p);
                            if(assets >= amount){
                                if(p == null){
                                    deposit(assets-amount);
                                }
                                return true;
                            }
                        }else{
                            UI.print(5);
                            UI.owe(amount-assets);
                            UI.printL();
                            break loop;
                        }
                        UI.owe(amount-assets);
                    }
                }else if(strInput.equals("no")){
                    GameRunner.gameOver = true;
                    GameRunner.advancedMode = false;
                    UI.printL();
                    return false;
                }
            }
            GameRunner.gameOver = true;
            GameRunner.advancedMode = false;
            UI.printL();
            return false;
        }
    }
    
}