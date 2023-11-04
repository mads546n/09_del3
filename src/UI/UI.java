package UI;

import Main.Player;

public class UI {

    private static String[] text = {"Welcome to monopoly. You can play with 2 to 4 players, how many players are playing?", "Write the name of player 1", "Write the name of player 2", "Write the name of player 3", "Write the name of player 4"};

    public static void print(int x){
        System.out.println(text[x]);
    }

    public static void printPlayer(Player p){
        System.out.println(p.getName() +" has a wallet of "+p.getWallet());
    }
    
}
