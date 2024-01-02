
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame {

    static Multi_PlayerGame Multi_game;
    static SinglePlayerGame Single_game;

    static strategy strategy;
    
    // create a frame with two buttons one for single player and one for multi-player
    static void frame1() {
        JFrame frame = new JFrame("tictactoe game by 3amooooor el amoooor");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        // create a button for single player
        JButton button = new JButton("Multi-Player Game");
        button.setBounds(250, 200, 200, 100);
        panel.add(button);
        // when the user clicks on the button the frame will be invisible and the game will start
        button.addActionListener(e -> {
            frame.setVisible(false);
            Multi_game = Multi_PlayerGame.getInstance();
            Multi_game.Start();
        });
        // create a button for multi-player
        JButton button2 = new JButton("Single-Player Game");
        button2.setBounds(250, 400, 200, 100);
        panel.add(button2);
        // when the user clicks on the button the frame will be invisible and the game will start
        button2.addActionListener(e -> {
            frame.setVisible(false);
            frame2();

        });

        frame.add(panel);
        // set the frame size and location and close operation and visibility
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    
    static void frame2() {
        JFrame frame = new JFrame("choose strategy");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JButton button = new JButton("Easy");
        button.setBounds(250, 100, 200, 100);
        panel.add(button);
        button.addActionListener(e -> {
            frame.setVisible(false);
        });
        JButton button2 = new JButton("Medium");
        button2.setBounds(250, 300, 200, 100);
        panel.add(button2);
        button2.addActionListener(e -> {
            frame.setVisible(false);
        });

        JButton button3 = new JButton("Hard");
        button3.setBounds(250, 500, 200, 100);
        panel.add(button3);
        button3.addActionListener(e -> {
            frame.setVisible(false);
        });

        frame.add(panel);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        
    }

  

   

    public static void main(String[] args) throws Exception {
        
        frame1();
       

    }
    
    
}

     