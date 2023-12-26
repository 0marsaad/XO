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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTileState(TileState State) {
        if (this.State == TileState.EMPTY) {
            this.State = State;
        } else {
            throw new IllegalArgumentException("This tile is already taken");
        }
    }

    public TileState getTurn() {
        return State;
    }



}
