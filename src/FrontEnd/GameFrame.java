package FrontEnd;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
    private JPanel modes;
    private JPanel diffs;
    private Game game;
    private static GameFrame instance;
    
    private GameFrame() {
        modes = new ModeMenu(this);
        diffs = new DifficultyMenu(this);
        this.setPreferredSize(Dimensions.WINDOW_SIZE);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.getContentPane().add(modes);
        this.getContentPane().add(diffs);
        this.getContentPane().setPreferredSize(Dimensions.WINDOW_SIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        diffs.setVisible(false);
        modes.setVisible(true);
        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
     // Implements Singleton pattern
    public static GameFrame getInstance() {
        if (instance == null)
            instance = new GameFrame();
        return instance;
    }
    
    protected void showDifficulties() {
        this.setVisible(true);
        modes.setVisible(false);
        diffs.setVisible(true);
        if (game != null)
            game.setVisible(false);
        
    }
    protected void showModes() {
        this.setVisible(true);
        diffs.setVisible(false);
        modes.setVisible(true);
        if (game != null)
            game.setVisible(false);
    }
    
    public void startGame(Game g) {
        if (game != null)
            this.getContentPane().remove(game);
        game = g;
        this.getContentPane().add(game);
        modes.setVisible(false);
        diffs.setVisible(false);
        game.setVisible(true);
    }
    protected Game currentGame() {
        return game;
    }
    protected void makeMove(int x, int y) {
        game.makeMove(x, y);
    }
    
    public static void main(String[] args) { 
        GameFrame.getInstance();
    }
}
