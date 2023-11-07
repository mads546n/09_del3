package UI;

import Main.Player;

public class UI {

    private static final String[] text = {"Welcome to monopoly. You can play with 2 to 4 players, how many players are playing?", "Player 1 what charektor do you wanna be?", "Player 2 what charektor do you wanna be?", "Player 3 what charektor do you wanna be?", "Player 4 what charektor do you wanna be?", "oh oh that diddnt work"};
    private static final String[] chanceCard = {"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9", "test10", "test11", "test12", "test13", "test14", "test15", "test16", "test17", "test18", "test19", "test20", "test21", "test22", "test23", "test24", };

    public static void print(int x){
        System.out.println(text[x]);
    }

    public static void printPlayer(Player p){
        System.out.println(p.getSymbol() +" has a wallet of "+p.getWallet());
    }
    
    public static void printChance(int x) {
        if (x >= 0 && x < chanceCard.length) {
            System.out.println(chanceCard[x]);
        } else {
            System.out.println("Not a valid card");
        }
    }

}
