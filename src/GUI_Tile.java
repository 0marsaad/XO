
import javax.swing.JLabel;

public class GUI_Tile extends JLabel {
    private TileState state;
    
    public GUI_Tile() {
        this.state = TileState.EMPTY;
    }
    
    public TileState getState() {
        return state;
    }
    
    public void setState(TileState t) {
        state = t;
        switch (t) {
            case X -> this.setIcon(Images.X);
            case O -> this.setIcon(Images.O);
            default -> this.setIcon(null);
        }
    }
}
