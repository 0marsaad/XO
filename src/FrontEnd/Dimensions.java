package FrontEnd;

import java.awt.Dimension;

public final class Dimensions {
    // The purpose of this class is containing all element dimensions, so they're easy to find and edit if necessary
    public static final Dimension WINDOW_SIZE = new Dimension(600, 700);
    public static final Dimension TILE_SIZE = new Dimension(200, 200);
    public static final Dimension BUTTON_SIZE = new Dimension(120, 60);
    public static final Dimension BUTTON_SIZE_WIDE = new Dimension(220, 60);
    public static final Dimension BOARD_SIZE = new Dimension(600, 600);
    
    private Dimensions() {
        // Do not instantiate
    }
}
