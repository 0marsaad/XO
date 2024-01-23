
import javax.swing.JLabel;

public class GUI_Tile extends JLabel {
    private final Coordinates coordinates;
    private Game game;
    
    public GUI_Tile(Game g, Coordinates c) {
        game =g;
        coordinates = c;
        addMouseListener(new MouseMoveMaker(this));
    }
    
    public int getXCoordinates() {
        return coordinates.getX();
    }
    public int getYCoordinates() {
        return coordinates.getY();
    }
    
    public TileState getState() {
        return coordinates.getTurn();
    }
    
    protected void move() {
        game.makeMove(coordinates.getX(), coordinates.getY());
    }
    
    public void updateState() {
        switch (coordinates.getTurn()) {
            case X -> this.setIcon(Images.X);
            case O -> this.setIcon(Images.O);
            default -> this.setIcon(null);
        }
    }
    
    public void setState(TileState t) {
        coordinates.setTileState(t);
        switch (t) {
            case X -> this.setIcon(Images.X);
            case O -> this.setIcon(Images.O);
            default -> this.setIcon(null);
        }
    }
}
