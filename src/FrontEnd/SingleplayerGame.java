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
    protected boolean makeMove(int x, int y) {
        boolean ended = super.makeMove(x, y);
        if (!ended) {
            Coordinates c = difficulty.makeComputerMove(TicTacToe.getInstance());
            ended = super.makeMove(c.getX(), c.getY());
        }
        return ended;
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
