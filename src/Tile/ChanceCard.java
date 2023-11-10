package Tile;
import Main.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChanceCard {
    //Generate array with 24 int (to simulate the chance cards order).
    private static int[] order = new int[24];
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
    }

    //METHOD YET TO BE DEFINED.
    private static void executeChanceCard(Player p, int x) {

    }

    //Method with player object as attribute. The method returns the element in the array assigned as "nextCard". 
    public static int landOn(Player p) {
        int temporary = order[nextCard];
        nextCard++;
        executeChanceCard(p, temporary);

        //if-else-chain for further development. 
        //GIVEN CONDITION NOT APPLICABLE
        if (temporary == 0) {

        } else {

        }

        return temporary; 
    }

}
