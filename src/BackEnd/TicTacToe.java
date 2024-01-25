package BackEnd;

public class TicTacToe {
    static private Coordinates[][] board = new Coordinates[3][3];
    private GameState gameState;
    static private TicTacToe ticTacToe;
    static private Player currentPlayer;
    private Player xPlayer = X_Player.getInstance();
    private Player oPlayer = O_player.getInstance();

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
    
    public void restartGame() {
        for (int i=0; i<board.length; i++)
            for (int j=0; j<board[0].length; j++) {
                board[i][j].setTileState(TileStates.EMPTY);
            }
        gameState = GameState.CONTINUE;
        currentPlayer = xPlayer;
    }

    // this method is used to update the state of the game
    protected void UpdateGameState() {

        if (board[0][0].getTurn() == board[1][1].getTurn() && board[1][1].getTurn() == board[2][2].getTurn()
                && board[0][0].getTurn() != TileStates.EMPTY) {
            if (board[0][0].getTurn() == TileStates.X) {
                gameState = GameState.x_WINS;
                return;
            } else if (board[0][0].getTurn() == TileStates.O) {
                gameState = GameState.O_WINS;
                return;
            }
        }
            
        if(board[2][0].getTurn() == board[1][1].getTurn() && board[1][1].getTurn() == board[0][2].getTurn()
                && board[2][0].getTurn() != TileStates.EMPTY) {
            if (board[2][0].getTurn() == TileStates.X) {
                gameState = GameState.x_WINS;
                return;
            } else if (board[2][0].getTurn() == TileStates.O) {
                gameState = GameState.O_WINS;
                return;
            }
        }


        if (board[0][2].getTurn() == board[1][1].getTurn() && board[1][1].getTurn() == board[2][0].getTurn()) {
            if (board[0][2].getTurn() == TileStates.X) {
                gameState = GameState.x_WINS;
                return;
            } else if (board[0][2].getTurn() == TileStates.O) {
                gameState = GameState.O_WINS;
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0].getTurn() == board[i][1].getTurn() && board[i][1].getTurn() == board[i][2].getTurn()
                    && board[i][0].getTurn() != TileStates.EMPTY) {
                if (board[i][0].getTurn() == TileStates.X) {
                    gameState = GameState.x_WINS;
                    return;
                } else if (board[i][0].getTurn() == TileStates.O) {
                    gameState = GameState.O_WINS;
                    return;
                }
            }

            if (board[0][i].getTurn() == board[1][i].getTurn() && board[1][i].getTurn() == board[2][i].getTurn()
                    && board[0][i].getTurn() != TileStates.EMPTY) {
                if (board[0][i].getTurn() == TileStates.X) {
                    gameState = GameState.x_WINS;
                    return;
                } else if (board[0][i].getTurn() == TileStates.O) {
                    gameState = GameState.O_WINS;
                    return;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getTurn() == TileStates.EMPTY) {
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
    public boolean Move(int x, int y) {
        if (gameState == GameState.CONTINUE) {
            if (board[x][y].getTurn() != TileStates.EMPTY) {
                return false;
            }
            board[x][y].setTileState(currentPlayer.getTileState());
            UpdateGameState();
            return true;
        }   // Returns move VALIDITY
        return false;

    }
    
    public class MementoTicTacToe {
        private final Coordinates[][] memBoard;
    
        private MementoTicTacToe(Coordinates[][] b) {
            memBoard = new Coordinates[3][3];
            for (int i=0; i<3; i++)
                for (int j=0; j<3; j++) {
                    memBoard[i][j] = new Coordinates(b[i][j].getX(), b[i][j].getY());
                    memBoard[i][j].setTileState(b[i][j].getTurn());
                }
        }
        private Coordinates[][] getBoard() {
            return memBoard;
        }
    }
    public MementoTicTacToe saveMemento() {
        return new MementoTicTacToe(board);
    }

    public void restoreFromMemento(MementoTicTacToe m) {
        Coordinates[][] mem = m.getBoard();
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++) {
                board[i][j].setTileState(mem[i][j].getTurn());
            }
        UpdateGameState();
    }

 

}
