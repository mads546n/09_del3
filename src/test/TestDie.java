package test;

import Main.Die;

public class TestDie extends Die{

    private int[] list;
    private int nextInt;

    public TestDie(int[] input) {
        super(6);
        list = input;
    }

    @Override
    public int rollDie(){
        int temp = nextInt;
        nextInt++;
        return list[temp];
    }
    
}
