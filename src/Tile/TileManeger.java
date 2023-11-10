package Tile;

public class TileManeger {
    public static Icon[] icons = {};
    public static Tile[] tiles = new Tile[24];

    static {
        new NoActionTile(0, "Start", icon[0]);
        new PropertyTile(1, "Brugerbar", icon[1], 1, 1);
        new PropertyTile(2, "Pizzahus", icon[2], 1, 2);
        new Chance(3, icon[3]);
        new PropertyTile(4, "Slikbutikken", icon[4], 1, 1);
        new PropertyTile(5, "Iskiosken", icon[5], 1, 1);
        new JailTile(6, "Fængsel", icon[6]);
        new PropertyTile(7, "Museet", icon[7], 2, 4);
        new PropertyTile(8, "Biblioteket", icon[8], 2, 4);
        new Chance(9, "Chance", icon[9]);
        new PropertyTile(10, "Skatepark", icon[10], 2, 6);
        new PropertyTile(11, "Swimmingpool", icon[11], 2, 6);
        new NoActionTile(12, "Gratis parkering", icon[12]);
        new PropertyTile(13, "Spillehallen", icon[13], 3, 8);
        new PropertyTile(14, "Biografen", icon[14], 3, 8);
        new Chance(15, icon[15]);
        new PropertyTile(16, "Legetøjsbutikken", icon[16], 3, 10);
        new PropertyTile(17, "Dyrehandlen", icon[17], 3, 10);
        new JailTile(18, "Gå i fængsel", icon[18]);
        new PropertyTile(19, "Bowlinghallen", icon[19], 4, 12);
        new PropertyTile(20, "Zoologisk have", icon[20], 4, 12);
        new Chance(21, "Chance", icon[21]);
        new PropertyTile(22, "Vandlandet", icon[22], 4, 14);
        new PropertyTile(23, "Strandpromenaden", icon[23], 5, 22);
    }
}
