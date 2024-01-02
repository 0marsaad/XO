import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SinglePlayerGame extends Game {

    static private SinglePlayerGame game;
    private strategy strategy;

    private SinglePlayerGame( strategy strategy) {
        o = new ImageIcon("rsc/O.png");
        x = new ImageIcon("rsc/x.png");
        o = new ImageIcon(o.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
        x = new ImageIcon(x.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
        ticTacToe = TicTacToe.getInstance();
        this.strategy = strategy;
    }

    static SinglePlayerGame getInstance(strategy strategy) {
        if (game == null) {
            game = new SinglePlayerGame(strategy);
        }
        game.strategy = strategy;
        return game;
    }
    
    
    
        
    @Override
    void Start() {
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
    
    public strategy getStrategy() {
        return strategy;
    }


}
