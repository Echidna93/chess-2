import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class SidePanel extends JPanel{
    public SidePanel(){
        setLayout(new GridLayout(0,8));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.BLUE);
        setOpaque(false);
        setVisible(false);
    }   
}