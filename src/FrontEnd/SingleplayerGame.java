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
        return makeMove(super.getTileAt(x, y));
    }
    @Override
    public boolean makeMove(GUI_Tile t) {
        boolean ended = super.makeMove(t);
        if (!ended) {
            ended = super.getBackend().makeCPUMove(difficulty, this);
            super.updateBoard();
        }
        return ended;
    }
    
    @Override
    public void undoMove() {
        super.undoMove();   // Do the action twice.
        super.undoMove();   // This makes it so it undoes/redoes both player and computer moves.
    }
    @Override
    public void redoMove() {
        super.redoMove();
        super.redoMove();
    }
}
