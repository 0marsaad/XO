package FrontEnd;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class DifficultyTooltips implements MouseListener{
    private final JLabel label;
    private final String text;
    
    public DifficultyTooltips(JLabel label, String text) {
        this.label = label;
        this.text = text;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setText(text);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setText(null);
    }
    
}
