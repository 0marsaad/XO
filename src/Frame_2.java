import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame_2 extends JFrame {
    // create a frame with four buttons one for each strategy
    public Frame_2() {
        JFrame frame = new JFrame("choose strategy");
        JPanel panel = new DifficultyMenu(frame);
        /*JPanel panel = new JPanel();
        panel.setLayout(null);
        JButton button = new JButton("Easy");
        button.setBounds(250, 50, 200, 100);
        panel.add(button);
        button.addActionListener(e -> {
            frame.setVisible(false);
            SinglePlayerGame.getInstance(new Easy()).Start();

        });
        JButton button2 = new JButton("Medium");
        button2.setBounds(250, 250, 200, 100);
        panel.add(button2);
        button2.addActionListener(e -> {
            frame.setVisible(false);
            SinglePlayerGame.getInstance(new Medium()).Start();
        });

        JButton button3 = new JButton("Hard");
        button3.setBounds(250, 450, 200, 100);
        panel.add(button3);
        button3.addActionListener(e -> {
            frame.setVisible(false);
            SinglePlayerGame.getInstance(new Hard()).Start();
        });

        JButton button4 = new JButton("Impossible");
        button4.setBounds(250, 650, 200, 100);
        panel.add(button4);
        button4.addActionListener(e -> {
            frame.setVisible(false);
            SinglePlayerGame.getInstance(new Impossible()).Start();
        });*/


        frame.add(panel);
        //frame.setSize(700, 800);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        
    }

}
