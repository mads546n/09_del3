package UI;

import Main.Player;
import Tile.TileManeger;

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

    public static void printBord(){
        int temp1 = 0;
        int temp2 = 23;
        String[][] bord = new String[36][15];
        for(int i = 0; i < 36; i++){
            for(int j = 0; j < 15; j++){
                if(i > 5 && i < 30 && j > 2 && j < 11){
                    bord[i][j] = "     ";
                }else if(i > 5 && i < 30 && j > 2 && j < 12){
                    bord[i][j] = "    ";
                }else if(i%5 == 0){
                    bord[i][j] = "-";
                }else if(j%2 == 0){
                    bord[i][j] = "|";
                }else{
                    if(i == 1 || j == 13){
                        bord[i][j] = TileManeger.icons[temp1].getLine(0);
                        bord[i+1][j] = TileManeger.icons[temp1].getLine(1);
                        bord[i+2][j] = TileManeger.icons[temp1].getLine(2);
                        bord[i+3][j] = TileManeger.icons[temp1].getLine(3);
                        temp1++;
                    }else if(i == 31 || j == 1){
                        bord[i][j] = TileManeger.icons[temp2].getLine(0);
                        bord[i+1][j] = TileManeger.icons[temp2].getLine(1);
                        bord[i+2][j] = TileManeger.icons[temp2].getLine(2);
                        bord[i+3][j] = TileManeger.icons[temp2].getLine(3);
                        temp2--;
                    }
                }
            }
        }
        for(int i = 0; i < 36; i++){
            for(int j = 0; j < 15; j++){
                System.out.print(bord[i][j]);
            }
            System.out.println();
        }

    }

}
