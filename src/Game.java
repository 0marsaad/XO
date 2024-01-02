import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public abstract class Game {

    static protected TicTacToe ticTacToe;
    static protected Button[][] button = new Button[3][3];
    static protected ImageIcon x;
    static protected ImageIcon o;

    static class Button extends JButton {
        private int x;
        private int y;

        public Button(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();
        int x = clickedButton.getX();
        int y = clickedButton.getY();

        // Call the MakeMove method or perform any necessary action based on button click
        MakeMove(x, y);
        UpdateBoard();

        if (Game.this instanceof SinglePlayerGame) {
            Coordinates c;
            c = ((SinglePlayerGame) Game.this).getStrategy().makeComputerMove(ticTacToe.getBoard());
            MakeMove(c.getX(), c.getY());
            UpdateBoard();
        }
        }
         
        
    }

    abstract void Start();

    static protected void UpdateBoard() {
        Coordinates[][] board = ticTacToe.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getTurn() == TileState.X) {
                    button[i][j].setIcon(x);

                } else if (board[i][j].getTurn() == TileState.O) {
                    button[i][j].setIcon(o);
                }
            }
        }

        if (ticTacToe.getGameState() == GameState.x_WINS) {
            JOptionPane.showMessageDialog(null, "X wins");
            System.exit(0);
        } else if (ticTacToe.getGameState() == GameState.O_WINS) {
            JOptionPane.showMessageDialog(null, "O wins");
            System.exit(0);
        } else if (ticTacToe.getGameState() == GameState.DRAW) {
            JOptionPane.showMessageDialog(null, "Draw");
            System.exit(0);

        }
    }
    

    static protected void MakeMove(int x, int y) {
        ticTacToe.Move(x, y);
    }


}
