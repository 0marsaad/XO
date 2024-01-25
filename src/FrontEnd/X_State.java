package FrontEnd;

import javax.swing.ImageIcon;

public class X_State extends TileState {
    private static final ImageIcon image = Images.X;

    public X_State(GUI_Tile t) {
        super(t);
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }
    
}
