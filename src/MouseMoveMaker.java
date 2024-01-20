
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class MouseMoveMaker implements MouseListener {
    private final GUI_Tile tile;
    private final Border highlight;
    private TicTacToe ticTacToe;
    
    public MouseMoveMaker(GUI_Tile t) {
        tile = t;
        highlight = BorderFactory.createLineBorder(Color.green);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        ticTacToe.Move(0, 0);
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
        tile.setBorder(highlight);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        tile.setBorder(null);
    }
    
}
