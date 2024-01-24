package BackEnd;

public class Coordinates {
    private int x;
    private int y;
    private TileState State;

    public Coordinates(int x, int y ) {
        this.x = x;
        this.y = y;
        this.State = TileState.EMPTY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setTileState(TileState State) {
        
            this.State = State;
        
    }

    public TileState getTurn() {
        return State;
    }



}
