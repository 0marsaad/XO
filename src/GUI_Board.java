
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class GUI_Board extends JPanel {
    private GUI_Tile[][] tiles;
    private Game game;
    
    public GUI_Board(Game g){
        game = g;
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(3,3));
        tiles = new GUI_Tile[3][3];
        Coordinates[][] coor = TicTacToe.getInstance().getBoard();
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++) {
                tiles[i][j] = new GUI_Tile(game, coor[i][j]);
                tiles[i][j].setPreferredSize(Dimensions.TILE_SIZE);
                this.add(tiles[i][j]);
            }
    }
    
    public void updateIcons() {
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                tiles[i][j].updateState();
    }
}
