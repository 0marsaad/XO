
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
    private JPanel modes;
    private JPanel diffs;
    private Game game;
    
    public GameFrame() {
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
    
    protected void showDifficulties() {
        this.setVisible(true);
        modes.setVisible(false);
        diffs.setVisible(true);
        
    }
    protected void showModes() {
        this.setVisible(true);
        diffs.setVisible(false);
        modes.setVisible(true);
    }
    
    public void startGame(Game g) {
        this.setVisible(false);
        game = g;
        g.Start();
    }
    protected Game currentGame() {
        return game;
    }
}
