package Main;

public class Player {

    Die die = new Die(6);
    
    private char symbol;
    private int wallet;

    public Player(char symbol, int wallet) {
        this.symbol = symbol;
        this.wallet = wallet;
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

    public void lose() {

    }
    
}