public class Easy implements strategy {


    @Override
    public Coordinates makeComputerMove(Coordinates[][] board) {
        int x, y;
        do {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        } while (board[x][y].getTurn() != TileState.EMPTY);
        
        Coordinates move = new Coordinates(x, y);
        return move;
    }
    
    

}
