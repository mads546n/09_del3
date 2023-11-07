package Main;

import UI.UI;
import java.util.Scanner;

public class GameRunner {

    static int nrOfPlayers = 2;
    static Player[] players;
    static int startValue = 20;

    public static void main(String[] args){

        setUpGame();

        for(Player p: players){
            UI.printPlayer(p);
        }

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.ENGLISH);
        String input;

        while (scanner.hasNextLine()){

            input = scanner.nextLine();

        }
        scanner.close();
    }

    public static void setUpGame(){
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.ENGLISH);
        //select number of playeres
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
        scanner.close();
    }
    
}
