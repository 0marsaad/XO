package AI;

import BackEnd.Coordinates;
import BackEnd.TicTacToe;
import BackEnd.TileStates;

//plays randomly

public class Easy implements Strategy {


    @Override
    public Coordinates makeComputerMove(TicTacToe game) {
        int x, y;
        do {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        } while (game.getBoard()[x][y].getTurn() != TileStates.EMPTY);
        
        Coordinates move = new Coordinates(x, y);
        return move;
    }
    
    

}
