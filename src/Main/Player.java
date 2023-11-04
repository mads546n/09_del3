package Main;

public class Player {

    Die die = new Die(6);
    
    private String name;
    private int wallet;

    public Player(String name, int wallet) {
        this.name = name;
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

    public String getName(){
        return name;
    }

    public int getWallet(){
        return wallet;
    }

    public void lose() {

    }
    
}