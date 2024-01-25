package FrontEnd;

import javax.swing.ImageIcon;

public class X_state extends TileState {
    private static final ImageIcon image = Images.X;

    public X_state(GUI_Tile t) {
        super(t);
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }
    
}
