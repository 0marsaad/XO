package FrontEnd;

import BackEnd.GameState;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class Game extends JPanel {
    private GUI_Board board;
    private GameFrame frame;
    private UndoPanel undoPanel;
    private BackendPortal backend;
    
    public Game(GameFrame f) {
        backend = BackendPortal.getInstance();
        board = new GUI_Board(this);
        frame = f;
        undoPanel = new UndoPanel(this);
        this.setPreferredSize(Dimensions.WINDOW_SIZE);
        this.add(board);
        this.add(undoPanel);
    }
    
    public BackendPortal getBackend() {
        return backend;
    }
    public void updateBoard() {
        board.updateIcons();
    }

    public void undoMove() {
        backend.undoMove();
        board.updateIcons();
    }
    public void redoMove() {
        backend.redoMove();
        board.updateIcons();
    }

    public boolean makeMove(int x, int y) {
        boolean ended = backend.makeMove(x, y);
        board.updateIcons();
        GameState st = backend.getGameState();
        if (st != GameState.CONTINUE) {
            String message = null;
            ImageIcon icon = null;
            switch (st) {
                case x_WINS -> {message = "X wins!"; icon = Images.X_MINI;}
                case O_WINS -> {message = "O wins!"; icon = Images.O_MINI;}
                case DRAW -> {message = "Draw!";}
                default -> throw new IllegalArgumentException("Unexpected value: " + st);
            }
            int choice = JOptionPane.showOptionDialog(null, message + " Play again?", message, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, new String[] { "Continue", "Exit" }, "continue");
            if (choice == JOptionPane.YES_OPTION) {
                backend.restartGame();
                board.updateIcons();
                frame.showModes();
            } else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            }
        }
        return ended;
    }
}
