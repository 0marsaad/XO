
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class Game extends JPanel {
    private GUI_Board board;
    private GameFrame frame;
    
    public Game(GameFrame f) {
        board = new GUI_Board(this);
        frame = f;
        this.setPreferredSize(Dimensions.WINDOW_SIZE);
        this.add(board);
    }
    
    protected void makeMove(int x, int y) {
        TicTacToe.getInstance().Move(x, y);
        board.updateIcons();
        GameState st = TicTacToe.getInstance().getGameState();
        if (st != GameState.CONTINUE) {
            String message = null;
            ImageIcon icon = null;
            switch (st) {
                case x_WINS -> {message = "X wins!"; icon = Images.X;}
                case O_WINS -> {message = "O wins!"; icon = Images.O;}
                case DRAW -> {message = "Draw!";}
            }
            int choice = JOptionPane.showOptionDialog(null, message + " Play again?", message, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, new String[] { "Continue", "Exit" }, "continue");
            if (choice == JOptionPane.YES_OPTION) {
                TicTacToe.getInstance().restartGame();
                board.updateIcons();
                frame.showModes();
            } else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            }
        }
    }
}
