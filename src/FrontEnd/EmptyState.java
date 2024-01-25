package FrontEnd;

import javax.swing.ImageIcon;

public class EmptyState extends TileState {
    
    public EmptyState(GUI_Tile t) {
        super(t);
    }

    @Override
    public ImageIcon getImage() {
       return null;
    }
}