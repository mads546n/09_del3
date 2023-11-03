package Main;

import java.util.Random;

public class Die {

    private int sides;

    public Die(int input) {
        this.sides = input;

    }

    public int rollDie(){
        Random rand = new Random();
        int n = rand.nextInt(sides);
        return n+1;

    }
    
}

