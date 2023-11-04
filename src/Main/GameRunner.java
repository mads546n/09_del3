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
        for(int i = 0; i < nrOfPlayers; i++){
            UI.print(i+1);
            if(scanner.hasNextLine()){
                players[i] = new Player(scanner.nextLine(), startValue);
            }
        }
        scanner.close();
    }
    
}
