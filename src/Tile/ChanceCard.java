package Tile;
import Main.Player;

//import java.util.Arrays;
import java.util.Random;

public class ChanceCard {
    //Generate array with 24 int (to simulate the chance cards order).
    private static int[] order = new int[24];
    int length = order.length;

    //Create a static integer that tracks down the next card in the deck.
    private static int nextCard;

    //Method to randomly sort the the array "order".
    public static void shuffle(String[] args) { 
        int[] array = order; 
        
        Random rand = new Random(); 

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temporary = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temporary; 
        }
    }

    //Method to distinguish array-elements and make sure the same elements don't appear more than once. 
    public static int findDoubles(int A[], int length) { 
        for (int i = 0; i < length; i++) {
            int count = 0; 
            for (int j = 0; j < length; j++) {
                if (A[i] == A[j]) {
                    count++;
                }
            }
            if (count == 0) {
                return A[i];
            }
        }
        return -1; 
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
