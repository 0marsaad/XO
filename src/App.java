
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class App extends JFrame {

    static TicTacToe ticTacToe;
    static Button[][] button = new Button[3][3];
    static ImageIcon x;
    static ImageIcon o;

    static class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();
        int x = clickedButton.getX();
        int y = clickedButton.getY();

        // Call the MakeMove method or perform any necessary action based on button click
        MakeMove(x, y);
        UpdateBoard();
         
        
    }
}
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
    

    
    
    static void frame1() {
        JFrame frame = new JFrame("JFrame Example");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JButton button = new JButton("Start Game");
        button.setBounds(300, 300, 100, 100);
        panel.add(button);
        button.addActionListener(e -> {
            frame.setVisible(false);
            frame2();
        });
        frame.add(panel);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void MakeMove(int x, int y) {
        ticTacToe.Move(x, y);
    }

    static void UpdateBoard() {
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

    static void frame2() {

  
        JFrame frame = new JFrame("Game");
        JPanel panel = new JPanel();
        ButtonHandler buttonHandler = new ButtonHandler();
        panel.setLayout(null);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j] = new Button(i, j);
                button[i][j].setBounds(200 * i, 200 * j, 200, 200);
                panel.add(button[i][j]);
                button[i][j].addActionListener(buttonHandler);

            }
        }
        
        
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        o = new ImageIcon("rsc/O.png");
        x = new ImageIcon("rsc/x.png");
        o = new ImageIcon(o.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
        x = new ImageIcon(x.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
        frame1();
        ticTacToe = TicTacToe.getInstance();

    }
    
    
}

     