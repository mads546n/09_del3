package Tile;
import Main.GameRunner;
import Main.Player;
import UI.UI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChanceCard {
    //Generate array with 24 int (to simulate the chance cards order).
    private static int[] order = new int[20];
    int length = order.length;

    //Create a static integer that tracks down the next card in the deck.
    private static int nextCard;

    //Method to randomly sort the the array "order" and to distinguish array-elements and make sure the same elements don't appear more than once. 
    public static void shuffle() {

        for(int i = 0; i < order.length; i++) {
            order[i] = i;
        }
        List<Integer> intList = new ArrayList<>();
        for (int value : order) {
            intList.add(value);
        }

        Collections.shuffle(intList);

        for (int i = 0; i < order.length; i++) {
            order[i] = intList.get(i); 
        }
        
        nextCard = 0;
    }


    //Method with player object as attribute. The method returns the element in the array assigned as "nextCard". 
    public static boolean landOn(Player p) {
        int temporary = order[nextCard];
        nextCard++;
        boolean r = false;

        if(nextCard == 20){
            shuffle();
        }

        if (temporary == 0) {

            p.chanceMsg(0);

            loop:
            for(int i = 0; i < GameRunner.players.length+1; i++){

                if(i > GameRunner.players.length){
                    p.setChance(0);
                    break loop;
                }

                if(GameRunner.players[i].getName().equals("Racecar")){
                    GameRunner.players[i].setChance(0);
                    if(GameRunner.players[i] != p){
                        r = true;
                    }
                    break loop;
                }
            }
        } else if (temporary == 1) {

            p.chanceMsg(1);
            p.moveToStart();
            
        } else if (temporary == 2) {

            p.printTurn();
            UI.printChance(2);
            String input;
            int temp = 5;
            loop:
            while(GameRunner.scanner.hasNextLine()){
                input = GameRunner.scanner.nextLine();
                if(input.equals("1")){
                    temp = 1;
                    break loop;
                }else if(input.equals("2")){
                    temp = 2;
                    break loop;
                }else if(input.equals("3")){
                    temp = 3;
                    break loop;
                }else if(input.equals("4")){
                    temp = 4;
                    break loop;
                }else if(input.equals("5")){
                    temp = 5;
                    break loop;
                }
            }
            p.roll(temp);

        } else if (temporary == 3) {

            p.printTurn();
            UI.printChance(3);
            String input;
            int temp = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("11")){
                        temp = 10;
                    }else if(input.equals("12")){
                        temp = 11;
                    }

                    if(temp != 0){
                        int roll = temp - p.getLocation();
                        if(roll < 0){
                            roll = roll + 24;
                        }
                        if(TileManeger.tiles[temp].getOwendBy() == TileManeger.canBuy){
                            p.deposit(2);
                        }
                        p.roll(roll);
                        break loop;
                    }
                }
            }

        } else if (temporary == 4) {

            p.printTurn();
            UI.printChance(4);

            if(GameRunner.scanner.hasNextLine()){
                String input = GameRunner.scanner.nextLine();
                if(input.equals("yes")){
                    r = true;
                }else{
                    p.roll(1);
                }
            }

        } else if (temporary == 5) {

            p.chanceMsg(5);

            loop:
            for(int i = 0; i < GameRunner.players.length+1; i++){

                if(i > GameRunner.players.length){
                    p.setChance(0);
                    break loop;
                }

                if(GameRunner.players[i].getName().equals("Boat")){
                    GameRunner.players[i].setChance(0);
                    if(GameRunner.players[i] != p){
                        r = true;
                    }
                    break loop;
                }
            }

        } else if (temporary == 6) {

            p.chanceMsg(6);
            
            p.check(2, null);

        } else if (temporary == 7) {

            p.printTurn();
            UI.printChance(7);
            String input;
            int temp = 0;
            int temp2 = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("11")){
                        temp = 10;
                        temp2 = 2;
                    }else if(input.equals("12")){
                        temp = 11;
                        temp2 = 2;
                    }else if(input.equals("20")){
                        temp = 19;
                        temp2 = 4;
                    }else if(input.equals("21")){
                        temp = 20;
                        temp2 = 4;
                    }

                    if(temp != 0){
                        int roll = temp - p.getLocation();
                        if(roll < 0){
                            roll = roll + 24;
                        }
                        if(TileManeger.tiles[temp].getOwendBy() == TileManeger.canBuy){
                            p.deposit(temp2);
                        }
                        p.roll(roll);
                        break loop;
                    }
                }
            }

        } else if (temporary == 8) {

            p.printTurn();
            UI.printChance(8);
            String input;
            int temp = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("5")){
                        temp = 4;
                    }else if(input.equals("6")){
                        temp = 5;
                    }

                    if(temp != 0){
                        int roll = temp - p.getLocation();
                        if(roll < 0){
                            roll = roll + 24;
                        }
                        if(TileManeger.tiles[temp].getOwendBy() == TileManeger.canBuy){
                            p.deposit(1);
                        }
                        p.roll(roll);
                        break loop;
                    }
                }
            }

        } else if (temporary == 9) {

            p.chanceMsg(9);
            p.getsJailCard();

        } else if (temporary == 10) {

            p.chanceMsg(10);
            int temp = 13 - p.getLocation();
            if(temp < 0){
                temp = temp + 24;
            }
            p.roll(temp);

        } else if (temporary == 11) {

            p.chanceMsg(11);

            loop:
            for(int i = 0; i < GameRunner.players.length+1; i++){

                if(i > GameRunner.players.length){
                    p.setChance(0);
                    break loop;
                }

                if(GameRunner.players[i].getName().equals("Cat")){
                    GameRunner.players[i].setChance(0);
                    if(GameRunner.players[i] != p){
                        r = true;
                    }
                    break loop;
                }
            }

        } else if (temporary == 12) {

            p.chanceMsg(12);

            loop:
            for(int i = 0; i < GameRunner.players.length+1; i++){

                if(i > GameRunner.players.length){
                    p.setChance(0);
                    break loop;
                }

                if(GameRunner.players[i].getName().equals("Dog")){
                    GameRunner.players[i].setChance(0);
                    if(GameRunner.players[i] != p){
                        r = true;
                    }
                    break loop;
                }
            }

        } else if (temporary == 13) {

            p.chanceMsg(13);
            UI.printChance(13);
            int temp = GameRunner.players.length-1;

            for(int i = 0; i < GameRunner.players.length; i++){
                if(GameRunner.players[i] != p){
                    if(!GameRunner.players[i].check(1, p)){
                        temp--;
                    }
                }
            }
            p.deposit(temp);

        } else if (temporary == 14) {

            p.printTurn();
            UI.printChance(14);
            String input;
            int temp = 0;
            int temp2 = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("8")){
                        temp = 7;
                        temp2 = 3;
                    }else if(input.equals("9")){
                        temp = 8;
                        temp2 = 3;
                    }else if(input.equals("23")){
                        temp = 22;
                        temp2 = 5;
                    }else if(input.equals("24")){
                        temp = 23;
                        temp2 = 5;
                    }

                    if(temp != 0){
                        int roll = temp - p.getLocation();
                        if(roll < 0){
                            roll = roll + 24;
                        }
                        if(TileManeger.tiles[temp].getOwendBy() == TileManeger.canBuy){
                            p.deposit(temp2);
                        }
                        p.roll(roll);
                        break loop;
                    }
                }
            }

        } else if (temporary == 15) {

            p.chanceMsg(15);
            p.deposit(2);

        } else if (temporary == 16) {

            p.printTurn();
            UI.printChance(16);
            String input;
            int temp = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("14")){
                        temp = 13;
                    }else if(input.equals("15")){
                        temp = 14;
                    }

                    if(temp != 0){
                        int roll = temp - p.getLocation();
                        if(roll < 0){
                            roll = roll + 24;
                        }
                        if(TileManeger.tiles[temp].getOwendBy() == TileManeger.canBuy){
                            p.deposit(1);
                        }
                        p.roll(roll);
                        break loop;
                    }
                }
            }

        } else if (temporary == 17) {

            p.chanceMsg(17);
            int roll = 10 - p.getLocation();
            if(roll < 0){
                roll = roll + 24;
            }
            if(TileManeger.tiles[10].getOwendBy() == TileManeger.canBuy){
                p.deposit(2);
            }
            p.roll(roll);

        } else if (temporary == 18) {

            p.printTurn();
            UI.printChance(18);
            String input;
            int temp = 0;
            int temp2 = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("5")){
                        temp = 4;
                        temp2 = 1;
                    }else if(input.equals("6")){
                        temp = 5;
                        temp2 = 1;
                    }else if(input.equals("14")){
                        temp = 13;
                        temp2 = 3;
                    }else if(input.equals("15")){
                        temp = 14;
                        temp2 = 3;
                    }

                    if(temp != 0){
                        int roll = temp - p.getLocation();
                        if(roll < 0){
                            roll = roll + 24;
                        }
                        if(TileManeger.tiles[temp].getOwendBy() == TileManeger.canBuy){
                            p.deposit(temp2);
                        }
                        p.roll(roll);
                        break loop;
                    }
                }
            }

        } else if (temporary == 19) {

            p.printTurn();
            UI.printChance(19);
            String input;
            int temp = 0;
            int temp2 = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("2")){
                        temp = 1;
                        temp2 = 1;
                    }else if(input.equals("3")){
                        temp = 2;
                        temp2 = 1;
                    }else if(input.equals("17")){
                        temp = 16;
                        temp2 = 3;
                    }else if(input.equals("18")){
                        temp = 17;
                        temp2 = 3;
                    }

                    if(temp != 0){
                        int roll = temp - p.getLocation();
                        if(roll < 0){
                            roll = roll + 24;
                        }
                        if(TileManeger.tiles[temp].getOwendBy() == TileManeger.canBuy){
                            p.deposit(temp2);
                        }
                        p.roll(roll);
                        break loop;
                    }
                }
            }
        }
        return r;
    }
}
