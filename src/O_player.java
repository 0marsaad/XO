public class O_player extends Player {
    private static O_player oPlayer;

    private O_player() {
        tileState = TileState.O;
    }

    public static O_player getInstance() {
        if (oPlayer == null) {
            oPlayer = new O_player();
        }
        return oPlayer;
    }


}
