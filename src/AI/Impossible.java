package AI;

import BackEnd.Coordinates;
import BackEnd.TicTacToe;
import BackEnd.TileStates;

// this class is to check all the possible outcomes of yhe game and make the best move possible

public class Impossible implements Strategy{

    @Override
    public Coordinates makeComputerMove(TicTacToe game) {
        Coordinates[][] board = game.getBoard();
        int bestScore = -100;
        int best_x = 0;
        int best_y = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j].getTurn() == TileStates.EMPTY){
                    board[i][j].setTileState(TileStates.O);
                    int score = checkAllStates(board,  false);
                    board[i][j].setTileState(TileStates.EMPTY);
                    if(score > bestScore){
                        bestScore = score;
                        best_x = i;
                        best_y = j;
                    }
                }
            }
        }
        return new Coordinates(best_x, best_y);
    }

    public int checkAllStates(Coordinates[][] board, boolean Winning_for_computer) {
        TileStates computer = TileStates.O;
        TileStates player = TileStates.X;

        if (checkWin(board, computer)) {
            return 1;
        } else if (checkWin(board, player)) {
            return -1;
        } else if (checkTie(board)) {
            return 0;
        }

        if (Winning_for_computer) {
            int bestScore = -10;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].getTurn() == TileStates.EMPTY) {
                        board[i][j].setTileState(TileStates.O);
                        int score = checkAllStates(board, false);
                        board[i][j].setTileState(TileStates.EMPTY);
                        if (score > bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = 10;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].getTurn() == TileStates.EMPTY) {
                        board[i][j].setTileState(TileStates.X);
                        int score = checkAllStates(board, true);
                        board[i][j].setTileState(TileStates.EMPTY);
                        if (score < bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }

    }
    
    public Boolean checkTie(Coordinates[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getTurn() == TileStates.EMPTY || board[i][1].getTurn() == TileStates.EMPTY
                    || board[i][2].getTurn() == TileStates.EMPTY) {
                return false;
            }
        }
        return true;
    }
    
    Boolean checkWin(Coordinates[][] board, TileStates player) {
        if (board[0][0].getTurn() == board[1][1].getTurn() && board[1][1].getTurn() == board[2][2].getTurn()
                && board[0][0].getTurn() != TileStates.EMPTY) {
            if (board[0][0].getTurn() == player) {
                return true;
            } else {
                return false;
            }
        }
            
        if(board[2][0].getTurn() == board[1][1].getTurn() && board[1][1].getTurn() == board[0][2].getTurn()
                && board[2][0].getTurn() != TileStates.EMPTY) {
            if (board[2][0].getTurn() == player) {
                return true;
            } else {
                return false;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getTurn() == board[i][1].getTurn() && board[i][1].getTurn() == board[i][2].getTurn()
                    && board[i][0].getTurn() != TileStates.EMPTY) {
                if (board[i][0].getTurn() == player) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i].getTurn() == board[1][i].getTurn() && board[1][i].getTurn() == board[2][i].getTurn()
                    && board[0][i].getTurn() != TileStates.EMPTY) {
                if (board[0][i].getTurn() == player) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;

        
    }
        

}
