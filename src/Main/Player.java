package Main;

public class Player {
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

    public void lose() {

    }
    
}