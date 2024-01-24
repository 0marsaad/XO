package FrontEnd;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ModeMenu extends JPanel {
    private final JButton single, multi;
    private final JLabel tooltips;
    private GameFrame frame;
    
    public ModeMenu(GameFrame frame) {
        this.frame = frame;
        this.setPreferredSize(Dimensions.WINDOW_SIZE);
        JPanel buttons = new JPanel();
        single = new JButton("Singleplayer");
        single.setPreferredSize(Dimensions.BUTTON_SIZE_WIDE);
        single.setAlignmentX(CENTER_ALIGNMENT);
        single.addActionListener(e -> {
            frame.showDifficulties();});
        multi = new JButton("Local Multiplayer");
        multi.setPreferredSize(Dimensions.BUTTON_SIZE_WIDE);
        multi.setAlignmentX(CENTER_ALIGNMENT);
        multi.addActionListener(e -> {
            frame.startGame(new MultiplayerGame(frame));});
        tooltips = new JLabel();
        tooltips.setPreferredSize(new java.awt.Dimension(600, 200));
        single.addMouseListener(new DifficultyTooltips(tooltips, "Play by yourself against a CPU-controlled opponent"));
        multi.addMouseListener(new DifficultyTooltips(tooltips, "Play against a person sitting next to you"));
        buttons.add(single);
        buttons.add(multi);
        this.add(buttons);
        this.add(tooltips);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
}
