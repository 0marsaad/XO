
import java.awt.GridLayout;
import javax.swing.JPanel;

public class GUI_Board extends JPanel {
    private GUI_Tile[][] tiles;
    
    public GUI_Board(){
        this.setLayout(new GridLayout(3,3));
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++) {
                tiles[i][j] = new GUI_Tile();
                tiles[i][j].setPreferredSize(Dimensions.TILE_SIZE);
            }
    }
}
