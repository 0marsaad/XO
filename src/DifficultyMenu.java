
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DifficultyMenu extends JPanel {
    private final JButton easy;
    private final JButton medium;
    private final JButton hard;
    private final JButton impossible;
    private final JLabel info;
    
    public DifficultyMenu(JFrame f) {
        this.setPreferredSize(Dimensions.WINDOW_SIZE);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JPanel buttons = new JPanel();
        // Create buttons
        easy = new JButton("Easy");
        medium = new JButton("Medium");
        hard = new JButton("Hard");
        impossible = new JButton("Impossible");
        info = new JLabel();
        easy.addActionListener(e -> {
            f.setVisible(false);
            SinglePlayerGame.getInstance(new Easy()).Start();});
        easy.addMouseListener(new DifficultyTooltips(info, "CPU has no idea what it's doing. Can you even lose?"));
        easy.setPreferredSize(Dimensions.BUTTON_SIZE);
        medium.addActionListener(e -> {
            f.setVisible(false);
            SinglePlayerGame.getInstance(new Medium()).Start();});
        medium.addMouseListener(new DifficultyTooltips(info, "CPU at least knows how to stop you from winning. Try to outsmart it."));
        medium.setPreferredSize(Dimensions.BUTTON_SIZE);
        hard.addActionListener(e -> {
            f.setVisible(false);
            SinglePlayerGame.getInstance(new Hard()).Start();});
        hard.addMouseListener(new DifficultyTooltips(info, "CPU is smart and understands the strategy. Show it who's boss!"));
        hard.setPreferredSize(Dimensions.BUTTON_SIZE);
        impossible.addActionListener(e -> {
            f.setVisible(false);
            SinglePlayerGame.getInstance(new Impossible()).Start();});
        impossible.addMouseListener(new DifficultyTooltips(info, "\"You? Beating ME? I'd like to see you try!\"" ));
        impossible.setPreferredSize(Dimensions.BUTTON_SIZE);
        
        buttons.add(easy);
        buttons.add(medium);
        buttons.add(hard);
        buttons.add(impossible);
        this.add(buttons);
        this.add(info);
        buttons.setAlignmentX(CENTER_ALIGNMENT);
        info.setAlignmentX(CENTER_ALIGNMENT);
        info.setPreferredSize(new java.awt.Dimension(600, 200));
    }
}
