package AI;

import BackEnd.Coordinates;
import BackEnd.TicTacToe;
// implements the strategy pattern
public interface Strategy {
    Coordinates makeComputerMove(TicTacToe game);
}
