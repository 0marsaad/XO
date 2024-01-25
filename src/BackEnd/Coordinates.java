package BackEnd;

public class Coordinates {
    private int x;
    private int y;
    private TileStates State;

    public Coordinates(int x, int y ) {
        this.x = x;
        this.y = y;
        this.State = TileStates.EMPTY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setTileState(TileStates State) {
        
            this.State = State;
        
    }

    public TileStates getTurn() {
        return State;
    }



}
