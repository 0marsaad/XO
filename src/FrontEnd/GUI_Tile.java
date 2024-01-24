package FrontEnd;

import BackEnd.TileState;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class GUI_Tile extends JLabel {
    private final int x;
    private final int y;
    private Game game;
    private static final Border defaultBorder = BorderFactory.createLineBorder(Color.black, 3);
    
    public GUI_Tile(Game g, int x, int y) {
        game = g;
        this.x = x;
        this.y = y;
        this.setBorder(defaultBorder);
        addMouseListener(new MouseMoveMaker(this));
    }
    
    public void restoreBorder() {
        this.setBorder(defaultBorder);
    }
    
    public int getXCoordinates() {
        return x;
    }
    public int getYCoordinates() {
        return y;
    }
    
    public TileState getState() {
        return game.getBackend().getStateOf(this);
    }
    
    protected void move() {
        game.makeMove(x, y);
    }
    
    public void updateState() {
        switch (getState()) {
            case X -> this.setIcon(Images.X);
            case O -> this.setIcon(Images.O);
            default -> this.setIcon(null);
        }
    }
    
    public void setState(TileState t) {
        game.getBackend().setTileStateOf(this, t);
        updateState();
    }
}
