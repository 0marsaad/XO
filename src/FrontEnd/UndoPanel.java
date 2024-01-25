package FrontEnd;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class UndoPanel extends JPanel {
    private final JButton undo, redo;
    
    public UndoPanel (Game g) {
        setPreferredSize(new java.awt.Dimension(600, 60));
        setLayout(new BorderLayout());
        undo = new JButton("Undo");
        undo.setPreferredSize(Dimensions.BUTTON_SIZE_WIDE);
        undo.setAlignmentX(LEFT_ALIGNMENT);
        undo.addActionListener(e -> {g.undoMove();});
        redo = new JButton ("Redo");
        redo.setPreferredSize(Dimensions.BUTTON_SIZE_WIDE);
        redo.setAlignmentX(RIGHT_ALIGNMENT);
        redo.addActionListener(e -> {g.redoMove();});
        add(undo, BorderLayout.WEST);
        add(redo, BorderLayout.EAST);
    }
}
