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
            order[i] = i+1;
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
    public static void landOn(Player p) {
        int temporary = order[nextCard];
        nextCard++;

        if(nextCard == 20){
            shuffle();
        }

        //if-else-chain for further development. 
        //GIVEN CONDITION NOT APPLICABLE
        if (temporary == 0) {

            UI.printChance(0);

            loop:
            for(int i = 0; i < GameRunner.players.length+1; i++){

                if(i < GameRunner.players.length){
                    p.setChance(0);
                    break loop;
                }

                if(GameRunner.players[i].getName().equals("Racecar")){
                    GameRunner.players[i].setChance(0);
                    landOn(p);
                }
            }
        } else if (temporary == 1) {

            UI.printChance(1);
            p.moveToStart();
            
        } else if (temporary == 2) {

            UI.printChance(2);
            p.roll(5);

        } else if (temporary == 3) {

            UI.printChance(8);
            String input;
            int temp = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("10")){
                        temp = 10;
                    }else if(input.equals("11")){
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

            UI.printChance(4);

            if(GameRunner.scanner.hasNextLine()){
                String input = GameRunner.scanner.nextLine();
                if(input.equals("yes")){
                    landOn(p);
                }else{
                    p.roll(1);
                }
            }

        } else if (temporary == 5) {

            UI.printChance(5);

            loop:
            for(int i = 0; i < GameRunner.players.length+1; i++){

                if(i < GameRunner.players.length){
                    p.setChance(0);
                    break loop;
                }

                if(GameRunner.players[i].getName().equals("Boat")){
                    GameRunner.players[i].setChance(0);
                    landOn(p);
                }

            }

        } else if (temporary == 6) {

            UI.printChance(6);
            
            if(!p.check(2)){
                p.deposit(-p.getWallet());
                p.lose();
            }

        } else if (temporary == 7) {

            UI.printChance(7);
            String input;
            int temp = 0;
            int temp2 = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("10")){
                        temp = 10;
                        temp2 = 2;
                    }else if(input.equals("11")){
                        temp = 11;
                        temp2 = 2;
                    }else if(input.equals("19")){
                        temp = 19;
                        temp2 = 4;
                    }else if(input.equals("20")){
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

            UI.printChance(8);
            String input;
            int temp = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("4")){
                        temp = 4;
                    }else if(input.equals("5")){
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

            UI.printChance(9);
            p.getsJailCard();

        } else if (temporary == 10) {

            UI.printChance(10);
            int temp = 13 - p.getLocation();
            if(temp < 0){
                temp = temp + 24;
            }
            p.roll(temp);

        } else if (temporary == 11) {

            UI.printChance(0);

            loop:
            for(int i = 0; i < GameRunner.players.length+1; i++){

                if(i < GameRunner.players.length){
                    p.setChance(0);
                    break loop;
                }

                if(GameRunner.players[i].getName().equals("Cat")){
                    GameRunner.players[i].setChance(0);
                    landOn(p);
                }
            }

        } else if (temporary == 12) {

            UI.printChance(12);

            loop:
            for(int i = 0; i < GameRunner.players.length+1; i++){

                if(i < GameRunner.players.length){
                    p.setChance(0);
                    break loop;
                }

                if(GameRunner.players[i].getName().equals("Dog")){
                    GameRunner.players[i].setChance(0);
                    landOn(p);
                }
            }

        } else if (temporary == 13) {

            UI.printChance(13);
            int temp = GameRunner.players.length-1;

            for(int i = 0; i < GameRunner.players.length; i++){
                if(GameRunner.players[i] != p){
                    if(GameRunner.players[i].check(1)){
                        p.lose();
                        temp--;
                    }
                }
            }
            p.deposit(temp);

        } else if (temporary == 14) {

            UI.printChance(14);
            String input;
            int temp = 0;
            int temp2 = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("7")){
                        temp = 7;
                        temp2 = 3;
                    }else if(input.equals("8")){
                        temp = 8;
                        temp2 = 3;
                    }else if(input.equals("22")){
                        temp = 22;
                        temp2 = 5;
                    }else if(input.equals("23")){
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

            UI.printChance(15);
            p.deposit(2);

        } else if (temporary == 16) {

            UI.printChance(16);
            String input;
            int temp = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("13")){
                        temp = 13;
                    }else if(input.equals("14")){
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

            UI.printChance(17);
            int roll = 10 - p.getLocation();
            if(roll < 0){
                roll = roll + 24;
            }
            if(TileManeger.tiles[10].getOwendBy() == TileManeger.canBuy){
                p.deposit(2);
            }
            p.roll(roll);

        } else if (temporary == 18) {

            UI.printChance(18);
            String input;
            int temp = 0;
            int temp2 = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("4")){
                        temp = 4;
                        temp2 = 1;
                    }else if(input.equals("5")){
                        temp = 5;
                        temp2 = 1;
                    }else if(input.equals("13")){
                        temp = 13;
                        temp2 = 3;
                    }else if(input.equals("14")){
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

            UI.printChance(19);
            String input;
            int temp = 0;
            int temp2 = 0;
            loop:
            while(true){
                if(GameRunner.scanner.hasNextLine()){
                    input = GameRunner.scanner.nextLine();
                    if(input.equals("1")){
                        temp = 1;
                        temp2 = 1;
                    }else if(input.equals("2")){
                        temp = 2;
                        temp2 = 1;
                    }else if(input.equals("16")){
                        temp = 16;
                        temp2 = 3;
                    }else if(input.equals("17")){
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
    }
}
