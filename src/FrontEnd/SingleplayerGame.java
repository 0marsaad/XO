package FrontEnd;

import AI.Strategy;

public class SingleplayerGame extends Game {
    private Strategy difficulty;
    
    public SingleplayerGame(GameFrame f, Strategy s) {
        super(f);
        this.difficulty = s;
    }
    
    @Override
    public boolean makeMove(int x, int y) {
        boolean ended = super.makeMove(x, y);
        if (!ended) {
            ended = super.getBackend().makeCPUMove(difficulty);
            super.updateBoard();
        }
        return ended;
    }
    
    @Override
    public void undoMove() {
        super.undoMove();   // This makes it so it undoes/redoes both player and computer moves.
        super.undoMove();
    }
    @Override
    public void redoMove() {
        super.redoMove();
        super.redoMove();
    }
}
