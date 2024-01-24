package FrontEnd;

import BackEnd.Coordinates;
import BackEnd.GameState;
import BackEnd.TicTacToe;
import BackEnd.strategy;

public class SingleplayerGame extends Game {
    private strategy difficulty;
    
    public SingleplayerGame(GameFrame f, strategy s) {
        super(f);
        this.difficulty = s;
    }
    
    @Override
    protected void makeMove(int x, int y) {
        super.makeMove(x, y);
        if (TicTacToe.getInstance().getGameState() == GameState.CONTINUE) {
            Coordinates c = difficulty.makeComputerMove(TicTacToe.getInstance());
            super.makeMove(c.getX(), c.getY());
        }
    }
    
    @Override
    protected void undoMove() {
        super.undoMove();   // This makes it so it undoes/redoes both player and computer moves.
        super.undoMove();
    }
    @Override
    protected void redoMove() {
        super.redoMove();
        super.redoMove();
    }
}
