package FrontEnd;

import BackEnd.Coordinates;
import BackEnd.TicTacToe;
import BackEnd.TicTacToe.MementoTicTacToe;
import BackEnd.TileStates;
import BackEnd.GameState;

import java.util.Stack;

import AI.*;
// implements facade pattern
public class BackendPortal {
    private TicTacToe backendGame;
    private static BackendPortal instance;
    private Stack<MementoTicTacToe> undoStack, redoStack;
    
    private BackendPortal() {
        backendGame = TicTacToe.getInstance();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }
// implements singleton pattern 
    public static BackendPortal getInstance() {
        if (instance == null)
            instance = new BackendPortal();
        return instance;
    }

    public GameState getGameState() {
        return backendGame.getGameState();
    }
    public TileStates getStateOf(GUI_Tile t) {
        return (backendGame.getBoard())[t.getXCoordinates()][t.getYCoordinates()].getTurn();
    }
    protected void setTileStatesOf(GUI_Tile t, TileStates s) {
        (backendGame.getBoard())[t.getXCoordinates()][t.getYCoordinates()].setTileState(s);
    }

    public void restartGame() {
        backendGame.restartGame();
    }

    private void reevaluateStates(Game g) {
        Coordinates[][] board = backendGame.getBoard();
            for (int i=0; i<board.length; i++)
                for (int j=0; j<board[0].length; j++) {
                    GUI_Tile t = g.getTileAt(i, j);
                    switch (board[i][j].getTurn()) {
                        case X -> {t.setState(new X_State(t));}
                        case O -> {t.setState(new O_State(t));}
                        case EMPTY -> {t.setState(new EmptyState(t));}
                        default -> {
                            throw new IllegalArgumentException("Unexpected value for \"TileStates\"");}
                    }
                }
    }

    protected void undoMove(Game g) {
        if (!undoStack.isEmpty()) {
            redoStack.push(TicTacToe.getInstance().saveMemento());
            TicTacToe.getInstance().restoreFromMemento(undoStack.pop());
            reevaluateStates(g);
        }
    }
    protected void redoMove(Game g) {
        if (!redoStack.empty()) {
            undoStack.push(TicTacToe.getInstance().saveMemento());
            TicTacToe.getInstance().restoreFromMemento(redoStack.pop());
            reevaluateStates(g);
        }
    }

    protected boolean makeMove(GUI_Tile t) {
        int x = t.getXCoordinates();
        int y = t.getYCoordinates();
        MementoTicTacToe mem = TicTacToe.getInstance().saveMemento();
        boolean b = TicTacToe.getInstance().Move(x, y);
        switch((backendGame.getBoard())[x][y].getTurn()) {
            case X -> {t.setState(new X_State(t));}
            case O -> {t.setState(new O_State(t));}
            case EMPTY -> {t.setState(new EmptyState(t));}
            default -> {
                throw new IllegalArgumentException("Unexpected value for \"TileStates\"");}
        }
        if (b == true) {
            undoStack.push(mem);
            redoStack.clear();
        }   // Returns whether or not GAME HAS ENDED
        return getGameState() != GameState.CONTINUE;
    }

    protected boolean makeCPUMove(Strategy s, Game g) {
        Coordinates c = s.makeComputerMove(backendGame);
        GUI_Tile t = g.getTileAt(c.getX(), c.getY());
        return makeMove(t);
    }
}
