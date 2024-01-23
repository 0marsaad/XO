
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class MouseMoveMaker implements MouseListener {
    private final GUI_Tile tile;
    private static final Border validHighlight = BorderFactory.createLineBorder(Color.green), invalidHighlight = BorderFactory.createLineBorder(Color.red);;
    private final TicTacToe ticTacToe;
    
    public MouseMoveMaker(GUI_Tile t) {
        tile = t;
        ticTacToe = TicTacToe.getInstance();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (tile.getState() == TileState.EMPTY)
            tile.move();
        tile.updateState(); // This is intentionally outside the if-statement
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // Do nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (tile.getState() == TileState.EMPTY)
            tile.setBorder(validHighlight);
        else
            tile.setBorder(invalidHighlight);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        tile.setBorder(null);
    }
    
}
