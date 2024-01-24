package AI;

import BackEnd.Coordinates;
import BackEnd.TicTacToe;

public interface Strategy {
    Coordinates makeComputerMove(TicTacToe game);
}
