package FrontEnd;

import BackEnd.Coordinates;
import BackEnd.TicTacToe;
import BackEnd.TicTacToe.MementoTicTacToe;
import BackEnd.TileState;
import BackEnd.GameState;

import java.util.Stack;

import AI.*;

public class BackendPortal {
    private TicTacToe backendGame;
    private static BackendPortal instance;
    private Stack<MementoTicTacToe> undoStack, redoStack;
    
    private BackendPortal() {
        backendGame = TicTacToe.getInstance();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public static BackendPortal getInstance() {
        if (instance == null)
            instance = new BackendPortal();
        return instance;
    }

    public GameState getGameState() {
        return backendGame.getGameState();
    }
    public TileState getStateOf(GUI_Tile t) {
        return (backendGame.getBoard())[t.getXCoordinates()][t.getYCoordinates()].getTurn();
    }
    protected void setTileStateOf(GUI_Tile t, TileState s) {
        (backendGame.getBoard())[t.getXCoordinates()][t.getYCoordinates()].setTileState(s);
    }

    public void restartGame() {
        backendGame.restartGame();
    }

    protected void undoMove() {
        if (!undoStack.isEmpty()) {
            redoStack.push(TicTacToe.getInstance().saveMemento());
            TicTacToe.getInstance().restoreFromMemento(undoStack.pop());
        }
    }
    protected void redoMove() {
        if (!redoStack.empty()) {
            undoStack.push(TicTacToe.getInstance().saveMemento());
            TicTacToe.getInstance().restoreFromMemento(redoStack.pop());
        }
    }

    protected boolean makeMove(int x, int y) {
        MementoTicTacToe mem = TicTacToe.getInstance().saveMemento();
        boolean b = TicTacToe.getInstance().Move(x, y);
        if (b == true) {
            undoStack.push(mem);
            redoStack.clear();
        }   // Returns whether or not GAME HAS ENDED
        return getGameState() != GameState.CONTINUE;
    }

    protected boolean makeCPUMove(Strategy s) {
        Coordinates c = s.makeComputerMove(backendGame);
        return makeMove(c.getX(), c.getY());
    }
}
