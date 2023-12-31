package Tile;

import Main.Player;

public class TileManeger {
    
    public static final Player canBuy = new Player('x', -1000);

    public static Icon[] icons = {
        new Icon("START", 2),
        new Icon("BURGER", 1),
        new Icon("PIZZA", 1),
        new Icon("CHANCE", 0),
        new Icon("CANDY.", 1),
        new Icon("ICECREAM", 1),
        new Icon("VISIT", 0),
        new Icon("MUSEUM", 2),
        new Icon("LIBRARY.", 2),
        new Icon("CHANCE", 0),
        new Icon("SKATE", 2),
        new Icon("SWIMMING", 2),
        new Icon("PARKING", 0),
        new Icon("ARCADE", 3),
        new Icon("CINEMA", 3),
        new Icon("CHANCE", 0),
        new Icon("TOYSTORE", 3),
        new Icon("PET SHOP", 3),
        new Icon("JAIL", 0),
        new Icon("BOWLING", 4),
        new Icon("ZOO", 4),
        new Icon("CHANCE", 0),
        new Icon("WATERPK:", 5),
        new Icon("BEACH", 5), 
    };

    public static Tile[] tiles = {
        new NoActionTile(0, "Start", icons[0]),
        new PropertyTile(1, "Burgerbar", icons[1], 1, 2),
        new PropertyTile(2, "Pizzahus", icons[2], 1, 1),
        new Chance(3, icons[3]),
        new PropertyTile(4, "Candy Store", icons[4], 1, 5),
        new PropertyTile(5, "Ice cream Store", icons[5], 1, 4),
        new NoActionTile(6, "Visiting Jail", icons[6]),
        new PropertyTile(7, "Museum", icons[7], 2, 8),
        new PropertyTile(8, "Library", icons[8], 2, 7),
        new Chance(9, icons[9]),
        new PropertyTile(10, "Skatepark", icons[10], 2, 11),
        new PropertyTile(11, "Swimmingpool", icons[11], 2, 10),
        new NoActionTile(12, "Free parking", icons[12]),
        new PropertyTile(13, "Arcase", icons[13], 3, 14),
        new PropertyTile(14, "Cinema", icons[14], 3, 13),
        new Chance(15, icons[15]),
        new PropertyTile(16, "Toy Store", icons[16], 3, 17),
        new PropertyTile(17, "Pet Shop", icons[17], 3, 16),
        new JailTile(18, icons[18]),
        new PropertyTile(19, "Bowlinghall", icons[19], 4, 20),
        new PropertyTile(20, "Zoo", icons[20], 4, 19),
        new Chance(2, icons[21]),
        new PropertyTile(22, "Water Park", icons[22], 5, 23),
        new PropertyTile(23, "The Beach Promenade", icons[23], 5, 22)};
}
