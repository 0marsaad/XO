package FrontEnd;

import javax.swing.ImageIcon;
// implements the state pattern
public abstract class TileState {
    private GUI_Tile contextTile;

    public TileState(GUI_Tile t) {
        contextTile = t;
    }

    GUI_Tile getTile() {
        return contextTile;
    }

    public abstract ImageIcon getImage();

}