package AI;

import BackEnd.Coordinates;
import BackEnd.TicTacToe;
import BackEnd.TileStates;

// both attacking and defensive strategies are implemented in this class

public class Hard implements Strategy {

    @Override
    public Coordinates makeComputerMove(TicTacToe game) {
        int x;
        int y;
        // check if there are any rows with two O's
        for (int i = 0; i < 3; i++) {
            if (game.getBoard()[i][0].getTurn() == game.getBoard()[i][1].getTurn()
                    && game.getBoard()[i][0].getTurn() == TileStates.O
                    && game.getBoard()[i][2].getTurn() == TileStates.EMPTY) {
                x = i;
                y = 2;
                Coordinates move = new Coordinates(x, y);
                return move;
            } else if (game.getBoard()[i][1].getTurn() == game.getBoard()[i][2].getTurn()
                    && game.getBoard()[i][1].getTurn() == TileStates.O
                    && game.getBoard()[i][0].getTurn() == TileStates.EMPTY) {
                x = i;
                y = 0;
                Coordinates move = new Coordinates(x, y);
                return move;
            } else if (game.getBoard()[i][0].getTurn() == game.getBoard()[i][2].getTurn()
                    && game.getBoard()[i][0].getTurn() == TileStates.O
                    && game.getBoard()[i][1].getTurn() == TileStates.EMPTY) {
                x = i;
                y = 1;
                Coordinates move = new Coordinates(x, y);
                return move;
            }
        }

        // check if there are any columns with two O's
        for (int i = 0; i < 3; i++) {
            if (game.getBoard()[0][i].getTurn() == game.getBoard()[1][i].getTurn()
                    && game.getBoard()[0][i].getTurn() == TileStates.O
                    && game.getBoard()[2][i].getTurn() == TileStates.EMPTY) {
                x = 2;
                y = i;
                Coordinates move = new Coordinates(x, y);
                return move;
            } else if (game.getBoard()[1][i].getTurn() == game.getBoard()[2][i].getTurn()
                    && game.getBoard()[1][i].getTurn() == TileStates.O
                    && game.getBoard()[0][i].getTurn() == TileStates.EMPTY) {

                x = 0;
                y = i;
                Coordinates move = new Coordinates(x, y);
                return move;
            } else if (game.getBoard()[0][i].getTurn() == game.getBoard()[2][i].getTurn()
                    && game.getBoard()[0][i].getTurn() == TileStates.O
                    && game.getBoard()[1][i].getTurn() == TileStates.EMPTY) {
                x = 1;
                y = i;
                Coordinates move = new Coordinates(x, y);
                return move;
            }

        }
        
        // check if there are any diagonals with two O's
        if (game.getBoard()[0][0].getTurn() == game.getBoard()[1][1].getTurn() && game.getBoard()[0][0].getTurn() == TileStates.O && game.getBoard()[2][2].getTurn() == TileStates.EMPTY) {
            x = 2;
            y = 2;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (game.getBoard()[1][1].getTurn() == game.getBoard()[2][2].getTurn() && game.getBoard()[1][1].getTurn() == TileStates.O && game.getBoard()[0][0].getTurn() == TileStates.EMPTY) {
            x = 0;
            y = 0;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (game.getBoard()[0][0].getTurn() == game.getBoard()[2][2].getTurn() && game.getBoard()[0][0].getTurn() == TileStates.O && game.getBoard()[1][1].getTurn() == TileStates.EMPTY) {
            x = 1;
            y = 1;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (game.getBoard()[0][2].getTurn() == game.getBoard()[1][1].getTurn() && game.getBoard()[0][2].getTurn() == TileStates.O && game.getBoard()[2][0].getTurn() == TileStates.EMPTY) {
            x = 2;
            y = 0;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (game.getBoard()[1][1].getTurn() == game.getBoard()[2][0].getTurn() && game.getBoard()[1][1].getTurn() == TileStates.O && game.getBoard()[0][2].getTurn() == TileStates.EMPTY) {
            x = 0;
            y = 2;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (game.getBoard()[0][2].getTurn() == game.getBoard()[2][0].getTurn()
                && game.getBoard()[0][2].getTurn() == TileStates.O
                && game.getBoard()[1][1].getTurn() == TileStates.EMPTY) {
            x = 1;
            y = 1;
        }

        // check if there are any rows with two X's
        for (int i = 0; i < 3; i++) {
            if (game.getBoard()[i][0].getTurn() == game.getBoard()[i][1].getTurn()
                    && game.getBoard()[i][0].getTurn() == TileStates.X
                    && game.getBoard()[i][2].getTurn() == TileStates.EMPTY) {
                x = i;
                y = 2;
                Coordinates move = new Coordinates(x, y);
                return move;
            } else if (game.getBoard()[i][1].getTurn() == game.getBoard()[i][2].getTurn()
                    && game.getBoard()[i][1].getTurn() == TileStates.X
                    && game.getBoard()[i][0].getTurn() == TileStates.EMPTY) {
                x = i;
                y = 0;
                Coordinates move = new Coordinates(x, y);
                return move;
            } else if (game.getBoard()[i][0].getTurn() == game.getBoard()[i][2].getTurn()
                    && game.getBoard()[i][0].getTurn() == TileStates.X
                    && game.getBoard()[i][1].getTurn() == TileStates.EMPTY) {
                x = i;
                y = 1;
                Coordinates move = new Coordinates(x, y);
                return move;
            }
        }

        // check if there are any columns with two X's

        for (int i = 0; i < 3; i++) {
            if (game.getBoard()[0][i].getTurn() == game.getBoard()[1][i].getTurn()
                    && game.getBoard()[0][i].getTurn() == TileStates.X
                    && game.getBoard()[2][i].getTurn() == TileStates.EMPTY) {
                x = 2;
                y = i;
                Coordinates move = new Coordinates(x, y);
                return move;
            } else if (game.getBoard()[1][i].getTurn() == game.getBoard()[2][i].getTurn()
                    && game.getBoard()[1][i].getTurn() == TileStates.X
                    && game.getBoard()[0][i].getTurn() == TileStates.EMPTY) {

                x = 0;
                y = i;
                Coordinates move = new Coordinates(x, y);
                return move;
            } else if (game.getBoard()[0][i].getTurn() == game.getBoard()[2][i].getTurn()
                    && game.getBoard()[0][i].getTurn() == TileStates.X
                    && game.getBoard()[1][i].getTurn() == TileStates.EMPTY) {
                x = 1;
                y = i;
                Coordinates move = new Coordinates(x, y);
                return move;
            }
        }

        // check if there are any diagonals with two X's

        if (game.getBoard()[0][0].getTurn() == game.getBoard()[1][1].getTurn()
                && game.getBoard()[0][0].getTurn() == TileStates.X
                && game.getBoard()[2][2].getTurn() == TileStates.EMPTY) {
            x = 2;
            y = 2;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (game.getBoard()[1][1].getTurn() == game.getBoard()[2][2].getTurn()
                && game.getBoard()[1][1].getTurn() == TileStates.X
                && game.getBoard()[0][0].getTurn() == TileStates.EMPTY) {
            x = 0;
            y = 0;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (game.getBoard()[0][0].getTurn() == game.getBoard()[2][2].getTurn()
                && game.getBoard()[0][0].getTurn() == TileStates.X
                && game.getBoard()[1][1].getTurn() == TileStates.EMPTY) {
            x = 1;
            y = 1;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (game.getBoard()[0][2].getTurn() == game.getBoard()[1][1].getTurn()
                && game.getBoard()[0][2].getTurn() == TileStates.X
                && game.getBoard()[2][0].getTurn() == TileStates.EMPTY) {
            x = 2;
            y = 0;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (game.getBoard()[1][1].getTurn() == game.getBoard()[2][0].getTurn()
                && game.getBoard()[1][1].getTurn() == TileStates.X
                && game.getBoard()[0][2].getTurn() == TileStates.EMPTY) {
            x = 0;
            y = 2;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (game.getBoard()[0][2].getTurn() == game.getBoard()[2][0].getTurn()
                && game.getBoard()[0][2].getTurn() == TileStates.X
                && game.getBoard()[1][1].getTurn() == TileStates.EMPTY) {
            x = 1;
            y = 1;
        
        } else {
            do {
                x = (int) (Math.random() * 3);
                y = (int) (Math.random() * 3);
            } while (game.getBoard()[x][y].getTurn() != TileStates.EMPTY);
        }
        return new Coordinates(x, y);
    }

    
   
   

}
