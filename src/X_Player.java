public class X_Player extends Player {
    private static X_Player xPlayer;
    
    private X_Player() {
        tileState = TileState.X;
    }

    public static X_Player getInstance() {
        if (xPlayer == null) {
            xPlayer = new X_Player();
        }
        return xPlayer;
    }

   

}
