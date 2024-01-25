package FrontEnd;


import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class GUI_Tile extends JLabel {
    private TileState state;
    private final int x;
    private final int y;
    private Game game;
    private static final Border defaultBorder = BorderFactory.createLineBorder(Color.black, 3);
    
    public GUI_Tile(Game g, int x, int y) {
        game = g;
        this.x = x;
        this.y = y;
        this.state = new EmptyState(this);
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
        return state;
    }
    
    protected void move() {
        game.makeMove(x, y);
    }
    
    public void updateState() {
        this.setIcon(state.getImage());
    }

    
    public void setState(TileState t) {
        if (t != null && !(t.equals(state))) {   // Idempotency. Do nothing if already in that state.
            state = t;
            //game.getBackend().setTileStatesOf(this, t);
            updateState();
        }
    }
}
