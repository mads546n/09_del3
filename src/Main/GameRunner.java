package Main;

import UI.UI;
import java.util.Scanner;

import Tile.ChanceCard;
import Tile.TileManeger;

public class GameRunner {

    static int nrOfPlayers = 2;
    public static Player[] players;
    static int startValue = 20;
    public static boolean advancedMode;
    static int turn = 0;
    static boolean gameOver;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        scanner.useLocale(java.util.Locale.ENGLISH);

        setUpGame();

        String input;

        UI.print(players[turn]);

        loop:
        while(scanner.hasNextLine()){
            input = scanner.nextLine();
            if(input.equals("roll")){
                players[turn].roll();
                if(gameOver){
                    break loop;
                }else{
                    players[turn].printTurn();
                }
                nextTurn();
                UI.print(players[turn]);
            }
        }
        scanner.close();
        showWinner();
    }

    private static int[] findWinner(){
        int w = 0;
        int tie = 0;
        for(int i = 0; i < nrOfPlayers; i++){
            if(players[i].getWallet() > players[w].getWallet()){
                w = i;
            }
        }

        for(int i = 0; i < nrOfPlayers; i++){
            if(i != w){
                if(players[i].getWallet() == players[w].getWallet()){
                    tie++;
                }
            }
        }
        int[] r = {w,tie};
        return r;
    }

    private static void showWinner(){
        int[] w = findWinner();

        if(w[1] > 0){
            UI.print(15);
            for(int i = 0; i < 24; i++){
                if(TileManeger.tiles[i].getOwendBy() != null && TileManeger.tiles[i].getOwendBy() != TileManeger.canBuy){
                    TileManeger.tiles[i].buyFromPlayer(null);                    
                    TileManeger.tiles[i].getOwendBy().deposit(TileManeger.tiles[i].getPrice());
                }
            }
            w = findWinner();
        }

        if(w[1] > 0){
            UI.printWinner(w);
        }else{
            UI.printWinner(w[0]);
        }
    }

    private static void setUpGame(){
        //select number of playeres
        ChanceCard.shuffle();
        UI.print(0);
        boolean found = false;

        while(!found){
            if(scanner.hasNextInt()){
                int temp = scanner.nextInt();
                if(temp <= 4 && temp >= 2){
                    nrOfPlayers = temp;
                    found = true;
                }
            }
        }

        if(nrOfPlayers == 4){
            startValue = 16;
        }else if(nrOfPlayers == 3){
            startValue = 18;
        }else if(nrOfPlayers == 2){
            startValue = 20;
        }

        scanner.nextLine();

        //select names
        players = new Player[nrOfPlayers];
        boolean[] taken = new boolean[4];
        for(int i = 0; i < nrOfPlayers; i++){
            UI.print(i+1);
            loop1:
            while(scanner.hasNextLine()){
                String input = scanner.nextLine();
                if(input.equals("cat") && !taken[0]){
                    players[i] = new Player('C', startValue);
                    taken[0] = true;
                    break loop1;
                }else if(input.equals("dog") && !taken[1]){
                    players[i] = new Player('D', startValue);
                    taken[1] = true;
                    break loop1;
                }else if(input.equals("boat") && !taken[2]){
                    players[i] = new Player('B', startValue);
                    taken[2] = true;
                    break loop1;
                }else if(input.equals("racecar") && !taken[3]){
                    players[i] = new Player('R', startValue);
                    taken[3] = true;
                    break loop1;
                }else{
                    UI.print(5);
                }
            }
        }

        for(int i = 0; i < nrOfPlayers; i++){
            TileManeger.icons[0].moveTo(players[i].getSymbol());
        }

        UI.print(6);
        if(scanner.nextLine().equals("yes")) {
            advancedMode = true;
            UI.print(7);  
        } else {
            UI.print(8);
        }
    }

    public static void nextTurn(){
        turn++;
        if(turn == nrOfPlayers){
            turn = 0;
        }
    }
    
}
