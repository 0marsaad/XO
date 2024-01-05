
//plays randomly

public class Easy implements strategy {


    @Override
    public Coordinates makeComputerMove(TicTacToe game) {
        int x, y;
        do {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        } while (game.getBoard()[x][y].getTurn() != TileState.EMPTY);
        
        Coordinates move = new Coordinates(x, y);
        return move;
    }
    
    

}
