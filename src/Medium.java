public class Medium implements strategy  {

    @Override
    public Coordinates makeComputerMove(Coordinates[][] board) {
        int x;
        int y;

        // check if there are any rows with two O's
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getTurn() == board[i][1].getTurn() && board[i][0].getTurn() == TileState.X && board[i][2].getTurn() == TileState.EMPTY){
            x = i;
                y = 2;
                Coordinates move = new Coordinates(x, y);
                return move;
            } else if (board[i][1].getTurn() == board[i][2].getTurn() && board[i][1].getTurn() == TileState.X && board[i][0].getTurn() == TileState.EMPTY) {
                x = i;
                y = 0;
                Coordinates move = new Coordinates(x, y);
                return move;
            } else if (board[i][0].getTurn() == board[i][2].getTurn() && board[i][0].getTurn() == TileState.X && board[i][1].getTurn() == TileState.EMPTY) {
                x = i;
                y = 1;
                Coordinates move = new Coordinates(x, y);
                return move;
            }
        }
        
        // check if there are any columns with two X's
        for (int i = 0; i < 3; i++) {
            if (board[0][i].getTurn() == board[1][i].getTurn() && board[0][i].getTurn() == TileState.X && board[2][i].getTurn() == TileState.EMPTY) {
                x = 2;
                y = i;
                Coordinates move = new Coordinates(x, y);
                return move;
            } else if (board[1][i].getTurn() == board[2][i].getTurn()&& board[1][i].getTurn() == TileState.X && board[0][i].getTurn() == TileState.EMPTY) {

                x = 0;
                y = i;
                Coordinates move = new Coordinates(x, y);
                return move;
            } else if (board[0][i].getTurn() == board[2][i].getTurn() && board[0][i].getTurn() == TileState.X && board[1][i].getTurn() == TileState.EMPTY) {
                x = 1;
                y = i;
                Coordinates move = new Coordinates(x, y);
                return move;
            }
        }
        
        // check if there are any diagonals with two X's
        if (board[0][0].getTurn() == board[1][1].getTurn() && board[0][0].getTurn() == TileState.X && board[2][2].getTurn() == TileState.EMPTY) {
            x = 2;
            y = 2;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (board[1][1].getTurn() == board[2][2].getTurn() && board[1][1].getTurn() == TileState.X && board[0][0].getTurn() == TileState.EMPTY) {
            x = 0;
            y = 0;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (board[0][0].getTurn() == board[2][2].getTurn() && board[0][0].getTurn() == TileState.X && board[1][1].getTurn() == TileState.EMPTY) {
            x = 1;
            y = 1;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (board[0][2].getTurn() == board[1][1].getTurn() && board[0][2].getTurn() == TileState.X && board[2][0].getTurn() == TileState.EMPTY) {
            x = 2;
            y = 0;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (board[1][1].getTurn() == board[2][0].getTurn() && board[1][1].getTurn() == TileState.X && board[0][2].getTurn() == TileState.EMPTY) {
            x = 0;
            y = 2;
            Coordinates move = new Coordinates(x, y);
            return move;
        } else if (board[0][2].getTurn() == board[2][0].getTurn() && board[0][2].getTurn() == TileState.X && board[1][1].getTurn() == TileState.EMPTY) {
            x = 1;
            y = 1;
            Coordinates move = new Coordinates(x, y);
            return move;
        }

        // plays randomly
        do {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        } while (board[x][y].getTurn() != TileState.EMPTY);

        return new Coordinates(x, y);

    }

}
