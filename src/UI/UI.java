package UI;

import Main.GameRunner;
import Main.Player;
import Tile.TileManeger;

public class UI {

    private static final String[] text = {"Welcome to monopoly. You can play with 2 to 4 players, how many players are playing?", "Player 1 what charektor do you wanna be?", "Player 2 what charektor do you wanna be?", "Player 3 what charektor do you wanna be?", "Player 4 what charektor do you wanna be?", "oh oh that diddnt work", "Do you want to run the game in Advanced Mode?", "Now running the game in Advanced Mode", "Now running the game in Regular Mode","You have passed start and get 2M","You now own this Tile","You gatta pay rent", "You use your get out of jail free card", "Do you wanna pay 1M to get out of jail?", "You wnet to jail"};
    private static final String[] chanceCard = {"C1: This card applys to the Racecar if you are not the Racecar you will get a new change card, if the Racecar isnt in the game the card will aply to you: On youre next turn you will move to the closest unsold tile and buy it, if all tiles are sold you will move to the closest tile and buy it from the owner", "C2: Move to START", "C3: Move op to 5 tiles, how many tiles do you wanna move?", "C4: You can move to tile 11 or 12, witch would you like to move to?", "C5: You can move one tile or you can take another chancecard, do you take the card?", "C6: This card applys to the Boat if you are not the Boat you will get a new change card, if the Boat isnt in the game the card will aply to you: On youre next turn you will move to the closest unsold tile and buy it, if all tiles are sold you will move to the closest tile and buy it from the owner", "C7: You ate to much candy, you gatta pay 2M", "C8: You can move to tile 11, 12, 20 or 21, witch would you like to move to?", "C9: You can move to tile 5 or 6, witch would you like to move to?", "C10: You get a get out of jail free card you can use for later", "C11: You move to the beach", "C12: This card applys to the Cat if you are not the Cat you will get a new change card, if the Cat isnt in the game the card will aply to you: On youre next turn you will move to the closest unsold tile and buy it, if all tiles are sold you will move to the closest tile and buy it from the owner", "C13: This card applys to the Dog if you are not the Dog you will get a new change card, if the Dog isnt in the game the card will aply to you: On youre next turn you will move to the closest unsold tile and buy it, if all tiles are sold you will move to the closest tile and buy it from the owner", "C14: its your birthday you get 1M from each player", "C15: You can move to tile 8, 9, 23 or 24, witch would you like to move to?", "C16: you have done all your homework, you get 2M", "C17: You can move to tile 14 or 15, witch would you like to move to?", "C18: Move to the skatepark if no one owns it you get it for free", "C19: You can move to tile 5, 6, 14 or 15, witch would you like to move to?", "C20: You can move to tile 2, 3, 17 or 18, witch would you like to move to?", "You recived a chance card last raound, that means you can now move to any propety tile that isnt already owned, if all propertys are owend you can move to any propety and buy it from the owner. What tile would you like to move to?"};

    public static void print(int x){
        System.out.println(text[x]);
    }

    public static void printL(){
        if(!GameRunner.advancedMode){
            System.out.println("You cant pay and you lose");
        }else{
            System.out.println("You dont have money to pay!! Do you wanna sell some propety to make up the money?");
        }
    }

    public static void print(int x, int loc){
        System.out.println("You landed on "+TileManeger.tiles[loc].getName());
    }

    public static void owe(int x){
        System.out.println("You owe "+x+"M, write the the number of the tile you would like to sell");
    }

    public static void print(Player p){
        String name = p.getName();
        System.out.println(name+" Your turn to roll, write 'roll'");
    }

    public static void printDieRoll(int i){
        System.out.println("You rolled a " + i);
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
