public class TicTacToe {
    static protected Coordinates[][] board = new Coordinates[3][3];
    protected GameState gameState;
    static protected TicTacToe ticTacToe;
    static protected Player currentPlayer;
    protected Player xPlayer = X_Player.getInstance();
    protected Player oPlayer = O_player.getInstance();

    //this class is a singleton class that represents the TicTacToe game
private TicTacToe() {
    // initialize the Backend board

    gameState = GameState.CONTINUE;
    currentPlayer = xPlayer;
}

public Player getCurrentPlayer() {
    return currentPlayer;
}
    
    public GameState getGameState() {
        return gameState;
    }

    public static TicTacToe getInstance() {
        if (ticTacToe == null) {
            ticTacToe = new TicTacToe();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[1].length; j++) {
                    board[i][j] = new Coordinates(i, j);
                }
    }
        }
        return ticTacToe;
    }

    public Coordinates[][] getBoard() {
        return board;
    }

    // this method is used to update the state of the game
    protected void UpdateGameState() {

        if (board[0][0].getTurn() == board[1][1].getTurn() && board[1][1].getTurn() == board[2][2].getTurn()
                && board[0][0].getTurn() != TileState.EMPTY) {
            if (board[0][0].getTurn() == TileState.X) {
                gameState = GameState.x_WINS;
                return;
            } else if (board[0][0].getTurn() == TileState.O) {
                gameState = GameState.O_WINS;
                return;
            }
        }
            
        if(board[2][0].getTurn() == board[1][1].getTurn() && board[1][1].getTurn() == board[0][2].getTurn()
                && board[2][0].getTurn() != TileState.EMPTY) {
            if (board[2][0].getTurn() == TileState.X) {
                gameState = GameState.x_WINS;
                return;
            } else if (board[2][0].getTurn() == TileState.O) {
                gameState = GameState.O_WINS;
                return;
            }
        }


        if (board[0][2].getTurn() == board[1][1].getTurn() && board[1][1].getTurn() == board[2][0].getTurn()) {
            if (board[0][2].getTurn() == TileState.X) {
                gameState = GameState.x_WINS;
                return;
            } else if (board[0][2].getTurn() == TileState.O) {
                gameState = GameState.O_WINS;
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0].getTurn() == board[i][1].getTurn() && board[i][1].getTurn() == board[i][2].getTurn()
                    && board[i][0].getTurn() != TileState.EMPTY) {
                if (board[i][0].getTurn() == TileState.X) {
                    gameState = GameState.x_WINS;
                    return;
                } else if (board[i][0].getTurn() == TileState.O) {
                    gameState = GameState.O_WINS;
                    return;
                }
            }

            if (board[0][i].getTurn() == board[1][i].getTurn() && board[1][i].getTurn() == board[2][i].getTurn()
                    && board[0][i].getTurn() != TileState.EMPTY) {
                if (board[0][i].getTurn() == TileState.X) {
                    gameState = GameState.x_WINS;
                    return;
                } else if (board[0][i].getTurn() == TileState.O) {
                    gameState = GameState.O_WINS;
                    return;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getTurn() == TileState.EMPTY) {
                    gameState = GameState.CONTINUE;

                    if(currentPlayer instanceof X_Player) {
                        currentPlayer = oPlayer;
                    } else {
                        currentPlayer = xPlayer;
                     }
                    return;
                }
            }
        }
        
        gameState = GameState.DRAW;
        
    }
    //make a move
    public void Move(int x, int y) {
        if (gameState == GameState.CONTINUE) {
            if (board[x][y].getTurn() != TileState.EMPTY) {
                throw new IllegalArgumentException("tile is already occupied");
            }
            board[x][y].setTileState(currentPlayer.getTileState());
            UpdateGameState();
        } else {
            throw new IllegalArgumentException("Game is over");
        }
    }

}
