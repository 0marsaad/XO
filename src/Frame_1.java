import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame_1 extends JFrame {
    // create a frame with two buttons one for single player and one for multi-player
    public Frame_1() {
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
            Multi_PlayerGame.getInstance().Start();
        });
        // create a button for multi-player
        JButton button2 = new JButton("Single-Player Game");
        button2.setBounds(250, 400, 200, 100);
        panel.add(button2);
        // when the user clicks on the button the frame will be invisible and the game will start
        button2.addActionListener(e -> {
            frame.setVisible(false);
            new Frame_2();

        });

        frame.add(panel);
        // set the frame size and location and close operation and visibility
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}
