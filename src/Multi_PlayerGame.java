import javax.swing.JFrame;
import javax.swing.JPanel;


public class Multi_PlayerGame extends Game {
    static private Multi_PlayerGame game;



//implementing singleton
private Multi_PlayerGame() {
    super();

}

static public Multi_PlayerGame getInstance() {
    if (game == null) {
        game = new Multi_PlayerGame();
    }
    return game;
}
@Override
//start the game
void Start() {

  
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




}
