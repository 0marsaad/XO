package FrontEnd;

import BackEnd.GameState;
import BackEnd.TicTacToe;
import BackEnd.TicTacToe.MementoTicTacToe;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class Game extends JPanel {
    private GUI_Board board;
    private GameFrame frame;
    private UndoPanel undoPanel;
    private Stack<MementoTicTacToe> undoStack, redoStack;
    
    public Game(GameFrame f) {
        board = new GUI_Board(this);
        frame = f;
        undoPanel = new UndoPanel(this);
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        this.setPreferredSize(Dimensions.WINDOW_SIZE);
        this.add(board);
        this.add(undoPanel);
    }
    
    protected void undoMove() {
        if (!undoStack.isEmpty()) {
            redoStack.push(TicTacToe.getInstance().saveMemento());
            TicTacToe.getInstance().restoreFromMemento(undoStack.pop());
            board.updateIcons();
        }
    }
    protected void redoMove() {
        if (!redoStack.empty()) {
            undoStack.push(TicTacToe.getInstance().saveMemento());
            TicTacToe.getInstance().restoreFromMemento(redoStack.pop());
            board.updateIcons();
        }
    }
    protected void makeMove(int x, int y) {
        MementoTicTacToe mem = TicTacToe.getInstance().saveMemento();
        boolean b = TicTacToe.getInstance().Move(x, y);
        if (b == true) {
            undoStack.push(mem);
            redoStack.clear();
        }
        board.updateIcons();
        GameState st = TicTacToe.getInstance().getGameState();
        if (st != GameState.CONTINUE) {
            String message = null;
            ImageIcon icon = null;
            switch (st) {
                case x_WINS -> {message = "X wins!"; icon = Images.X_MINI;}
                case O_WINS -> {message = "O wins!"; icon = Images.O_MINI;}
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
