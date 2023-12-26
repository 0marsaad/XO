import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    
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

    static void frame2() {
        JFrame frame = new JFrame("Game");
        JPanel panel = new JPanel();
        ButtonHandler buttonHandler = new ButtonHandler();
        panel.setLayout(null);
        JButton[][] button = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j] = new JButton();
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
        frame1();

        
    }
}
class ButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setText("X");
    }
}