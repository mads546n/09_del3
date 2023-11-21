package Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void testCheckInNormal(){
        GameRunner.advancedMode = false;
        GameRunner.players = new Player[4];
        GameRunner.players[0] = new Player('D', 16);
        GameRunner.players[0].check(20, null);

        assertEquals(0, GameRunner.players[0].getWallet());
    }

    @Test
    public void testCheckInAdvance(){
        GameRunner.advancedMode = true;
        GameRunner.players = new Player[4];
        GameRunner.players[0] = new Player('D', 16);
        GameRunner.players[1] = new Player('C', 16);
        File file = new File("No.txt");
        try {
            GameRunner.scanner = new Scanner(file);
            GameRunner.scanner.useLocale(java.util.Locale.ENGLISH);
        } catch (Exception e) {
            System.out.println("STOP: file No dont exist");
        }
        
        GameRunner.players[0].check(20, GameRunner.players[1]);

        assertEquals(0, GameRunner.players[0].getWallet());
        assertEquals(36, GameRunner.players[1].getWallet());
    }

    @Test
    public void ChanceTest1(){
        GameRunner.players = new Player[4];
        GameRunner.players[0] = new Player('D', 16);
        GameRunner.players[1] = new Player('C', 16);
        GameRunner.players[2] = new Player('R', 16);
        GameRunner.players[3] = new Player('B', 16);
        int[] chanceOder = {0,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        ChanceCard.setOrder(chanceOder);
        ChanceCard.landOn(GameRunner.players[0]);
        assertFalse(GameRunner.players[0].getChanceOnNext());
        assertFalse(GameRunner.players[1].getChanceOnNext());
        assertTrue(GameRunner.players[2].getChanceOnNext());
        assertFalse(GameRunner.players[3].getChanceOnNext());
    }

    @Test
    public void ChanceTest2(){
        GameRunner.players = new Player[4];
        GameRunner.players[0] = new Player('D', 16);
        GameRunner.players[1] = new Player('C', 16);
        GameRunner.players[2] = new Player('R', 16);
        GameRunner.players[3] = new Player('B', 16);
        int[] chanceOder = {0,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        ChanceCard.setOrder(chanceOder);
        ChanceCard.landOn(GameRunner.players[2]);
        assertFalse(GameRunner.players[0].getChanceOnNext());
        assertFalse(GameRunner.players[1].getChanceOnNext());
        assertTrue(GameRunner.players[2].getChanceOnNext());
        assertFalse(GameRunner.players[3].getChanceOnNext());
    }

    @Test
    public void ChanceTest3(){
        GameRunner.players = new Player[3];
        GameRunner.players[0] = new Player('D', 16);
        GameRunner.players[1] = new Player('C', 16);
        GameRunner.players[2] = new Player('B', 16);
        int[] chanceOder = {0,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        ChanceCard.setOrder(chanceOder);
        ChanceCard.landOn(GameRunner.players[1]);
        assertFalse(GameRunner.players[0].getChanceOnNext());
        assertTrue(GameRunner.players[1].getChanceOnNext());
        assertFalse(GameRunner.players[2].getChanceOnNext());
    }

    @Test
    public void testGame(){
        setupGameOne();
        for(int i = 0; i < 64; i++){
            GameRunner.players[i%4].roll();
        }
    }

    public void setupGameOne(){ 
        GameRunner.players = new Player[4];
        GameRunner.players[0] = new Player('D', 16);
        GameRunner.players[1] = new Player('C', 16);
        GameRunner.players[2] = new Player('R', 16);
        GameRunner.players[3] = new Player('B', 16);
        int[] testDieListPl1 = {1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6};
        int[] testDieListPl2 = {1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6};
        int[] testDieListPl3 = {1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6};
        int[] testDieListPl4 = {1,2,3,4,5,6,1,2,3,4,5,6,1,2,3,4,5,6};
        TestDie testDiePl1 = new TestDie(testDieListPl1);
        TestDie testDiePl2 = new TestDie(testDieListPl2);
        TestDie testDiePl3 = new TestDie(testDieListPl3);
        TestDie testDiePl4 = new TestDie(testDieListPl4);
        GameRunner.players[0].setDie(testDiePl1);
        GameRunner.players[1].setDie(testDiePl2);
        GameRunner.players[2].setDie(testDiePl3);
        GameRunner.players[3].setDie(testDiePl4);
        GameRunner.advancedMode = true;
        int[] chanceOder = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        ChanceCard.setOrder(chanceOder);
        File file = new File("GameOneInputs.txt");
        try {
            GameRunner.scanner = new Scanner(file);
            GameRunner.scanner.useLocale(java.util.Locale.ENGLISH);
        } catch (Exception e) {
            System.out.println("STOP: file GameOneInputs dont exist");
        }
    }
}
