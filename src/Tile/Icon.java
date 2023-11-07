package Tile;

public class Icon {

    private final String name;
    private int price;
    private char[] standing = {' ',' ',' ',' '};
    private String owner = "        ";
    
    public Icon(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void moveTo(char p){
        if(p == 'B'){
            standing[0] = 'B';
        }else if(p == 'C'){
            standing[1] = 'C';
        }else if(p == 'R'){
            standing[2] = 'R';
        }else if(p == 'D'){
            standing[3] = 'D';
        }
    }

    public void moveFrom(char p){
        if(p == 'B'){
            standing[0] = ' ';
        }else if(p == 'C'){
            standing[1] = ' ';
        }else if(p == 'R'){
            standing[2] = ' ';
        }else if(p == 'D'){
            standing[3] = ' ';
        }
    }

    public void priceUpdate(int x){
        this.price = x;
    }

    public void newOwner(char p){
        if(p == 'B'){
            owner = "  BOAT  ";
        }else if(p == 'C'){
            owner = "  CAT   ";
        }else if(p == 'R'){
            owner = "RACECAR";
        }else if(p == 'D'){
            owner = "  DOG   ";
        }
    }

    public String getLine(int x){

        String nameSpace = "";
        String ownerSpace = "";
        String sPrice = "        ";
        String[] r = new String[4];

        if(name.length() <= 8 && owner.length() <= 8 && price < 100){

            if(price > 0 && price < 10){

                sPrice = "   "+String.valueOf(price)+"M   ";

            }else if(price > 0){

                sPrice = "  "+String.valueOf(price)+"M   ";

            }

            for(int i = name.length(); i < 8; i++){
                nameSpace += " ";
            }

            for(int i = owner.length(); i < 8; i++){
                nameSpace += " ";
            }

            r[0] = name+nameSpace;
            r[1] = sPrice;
            r[2] = standing[0]+" "+standing[1]+" "+standing[2]+" "+standing[3]+" ";
            r[3] = owner+ownerSpace;
            return r[x];
        }else{
            return null;
        }
    }

    
}
