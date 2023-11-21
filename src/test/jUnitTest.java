package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;
import org.junit.*;
import Main.*;
import Tile.*;

public class jUnitTest {

    @Test
    public void testDie(){
        Die d = new Die(6);
        for(int i = 0; i < 100; i++){
            int x = d.rollDie();
            assertTrue(x < 7 && x > 0);
        }
    }

    @Test
    public void testShuffle(){

        int[] beforeShuffle = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};

        for(int i = 0; i < 100; i++){
            ChanceCard.setOrder(beforeShuffle);
            ChanceCard.shuffle();
            int[] afterShuffle = ChanceCard.getOrder();
            boolean passed = false;
            for(int j = 0; j < 20; j++){
                if(beforeShuffle[j] != afterShuffle[j]){
                    passed = true;
                }
            }
            assertTrue(passed);
        }

    }

    public void setupGameOne(){ 
        GameRunner.players[0] = new Player('D', 16);
        GameRunner.players[1] = new Player('C', 16);
        GameRunner.players[2] = new Player('R', 16);
        GameRunner.players[3] = new Player('B', 16);
        int[] testDieList = {1,2,3,4,5,6,1,2,3,4,5,6};
        TestDie testDie = new TestDie(testDieList);
        GameRunner.players[0].setDie(testDie);
        GameRunner.players[1].setDie(testDie);
        GameRunner.players[2].setDie(testDie);
        GameRunner.players[3].setDie(testDie);
        GameRunner.advancedMode = true;
        int[] chanceOder = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        ChanceCard.setOrder(chanceOder);
        File file = new File("GameOneInputs");
        try {
            GameRunner.scanner = new Scanner(file);
            GameRunner.scanner.useLocale(java.util.Locale.ENGLISH);
        } catch (Exception e) {
            System.out.println("STOP: file GameOneInputs dont exist");
        }
    }
}
