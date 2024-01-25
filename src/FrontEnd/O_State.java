package FrontEnd;

import javax.swing.ImageIcon;

public class O_State extends TileState {
    private static final ImageIcon image = Images.O;

    public O_State(GUI_Tile t) {
        super(t);
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }

}