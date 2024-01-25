package BackEnd;

//this class is a singleton class that represents the O player

public class O_Player extends Player {
    private static O_Player oPlayer;

    private O_Player() {
        tileState = TileStates.O;
    }
    //implements singleton
    public static O_Player getInstance() {
        if (oPlayer == null) {
            oPlayer = new O_Player();
        }
        return oPlayer;
    }


}
