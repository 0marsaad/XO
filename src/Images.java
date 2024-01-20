
import javax.swing.ImageIcon;

public final class Images {
    public static final ImageIcon X = new ImageIcon(new ImageIcon("rsc/X.png").getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
    public static final ImageIcon O = new ImageIcon(new ImageIcon("rsc/O.png").getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
    
    
    private Images() {
        // Do not instantiate
    }
}
