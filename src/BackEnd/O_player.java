package BackEnd;

//this class is a singleton class that represents the O player

public class O_player extends Player {
    private static O_player oPlayer;

    private O_player() {
        tileState = TileStates.O;
    }
    //implements singleton
    public static O_player getInstance() {
        if (oPlayer == null) {
            oPlayer = new O_player();
        }
        return oPlayer;
    }


}
