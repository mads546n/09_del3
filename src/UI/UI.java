package UI;

import Main.GameRunner;
import Main.Player;
import Tile.TileManeger;

public class UI {

    private static final String[] text = {"Welcome to Monopoly! You can play as 2 up to 4 players. How many players are playing?", "Player 1 what character do you wish to play as? The available characters are as following: Dog, Cat, Racecar and Boat", "Player 2 what character do you wish to play as?", "Player 3 what chararacter do you wish to play as?", "Player 4 what chararacter do you wanna play as?", "Oh oh that didn't work!", "Do you want to run the game in Advanced Mode?", "Now running the game in Advanced Mode", "Now running the game in Regular Mode","You have passed the Start-tile and receive 2M!","You now own this tile","You must pay rent", "You used your Get-out-of-jail-free-card", "You have payed 1M to get out of jail", "You went to jail", "The game has ended in a tie. Now the value of your properties will be counted and added to your final balance!"};
    private static final String[] chanceCard = {"C1: This card applies only to the Racecar. If you are not the Racecar, you will receive a new Chance Card, if the Racecar isn't in the ongoing game then the Chance Card will apply to you: On your next turn, you will move to the closest available tile and buy it. If no tiles are available you will move to the closest tile and buy it off the owner", "C2: Move to START", "C3: Move up to 5 tiles, how many tiles do you wanna move?", "C4: You can move to tile 11 or 12, which would you like to move to?", "C5: You can either move a single tile forward or take another Chance Card, do you pull another card?", "C6: This card applies to the Boat. If you are not the Boat then you will get to pull a new Chance Card, if the Boat isn't in the game then the card will aply to you: On your next turn, you will move to the closest available tile and buy it. If no tiles are available you will move to the closest tile and buy it off the owner", "C7: You have eaten too much candy, you must now pay 2M", "C8: You can move to tile 11, 12, 20 or 21, which would you like to move to?", "C9: You can move to tile 5 or 6, which would you like to move to?", "C10: You get a Get-out-of-jail-free-card, that you can use for later", "C11: You move to the Beach", "C12: This card applies to the Cat. If you are not the Cat, then you will get a new Chance Card. If the Cat isn't in the game then the card will apply to you: On your next turn you will move to the available tile and buy it. If no tiles are available, you will move to the closest tile and buy it off the owner", "C13: This card applies to the Dog. If you are not the Dog you will receive a new Chance Card. If the Dog isn't in the game the card will apply to you: On your next turn you will move to the closest available tile and buy it. If no tiles are available then you will move to the closest tile and buy it off the owner", "C14: it's your birthday! You collect 1M from each player", "C15: You can move to tile 8, 9, 23 or 24. Which would you like to move to?", "C16: You have finished all of your homework! You receive 2M", "C17: You can move to tile 14 or 15. Which would you like to move to?", "C18: Move to the Skatepark. If the tile is available you'll acquire it for free!", "C19: You can move to tile 5, 6, 14 or 15. Which would you like to move to?", "C20: You can move to tile 2, 3, 17 or 18. Which would you like to move to?", "You received a Chance Card last round, that means you can now move to any property tile that isn't already owned. If all properties are unavailable, you can move to any property and buy it off the owner. What tile would you like to move to?"};

    public static void print(int x){
        System.out.println(text[x]);
    }

    public static void printL(Player t, Player p){
        if(!GameRunner.advancedMode){
            System.out.println(t.getName()+" You can't pay your rent and you lose!");
        }else{
            String b = "The Bank";
            if(p != null){
                b = p.getName();
            }
            System.out.println(t.getName()+" You don't have money to pay! You owe money to "+b+". Do you want to sell a propety to make the money?");
        }
    }

    public static void print(int x, int loc){
        System.out.println("You landed on "+TileManeger.tiles[loc].getName());
    }

    public static void owe(int x){
        System.out.println("You owe "+x+"M, write the the number of the tile that you would like to sell");
    }

    public static void print(Player p){
        String name = p.getName();
        System.out.println(name+" It's your turn to roll, write 'roll'");
    }

    public static void printDieRoll(int i){
        System.out.println("You rolled a " + i);
    }

    public static void printWinner(int w){
        System.out.println();
        for(int i = 0; i < GameRunner.players.length; i++){
            printPlayer(GameRunner.players[i]);
            System.out.println();
        }
        System.out.println("And the winner is....... "+GameRunner.players[w].getName()+" with a balance of "+GameRunner.players[w].getWallet()+"M");
    }

    public static void printWinner(int[] w){
        System.out.println();
        for(int i = 0; i < GameRunner.players.length; i++){
            printPlayer(GameRunner.players[i]);
            System.out.println();
        }
        System.out.println("We have a tie! A "+(w[1]+1)+"-way tie!!");
    }

    public static void printPlayer(Player p){
        System.out.println(p.getName() +" has a wallet of "+p.getWallet());
        for(int i = 0; i < 24; i++){
            if(TileManeger.tiles[i].getOwendBy() == p){
                System.out.println(p.getName() + " owns " + TileManeger.tiles[i].getName());
            }
        }
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
                }else if(j%2 == 0){
                    bord[i][j] = "|";
                }else if(i%5 == 0){
                    bord[i][j] = "--------";
                }else{
                    if(i == 1 || (j == 13 && i%5 == 1)){
                        bord[i][j] = TileManeger.icons[temp1].getLine(0);
                        bord[i+1][j] = TileManeger.icons[temp1].getLine(1);
                        bord[i+2][j] = TileManeger.icons[temp1].getLine(2);
                        bord[i+3][j] = TileManeger.icons[temp1].getLine(3);
                        temp1++;
                    }else if(i == 31 || (j == 1 && i%5 == 1)){
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
