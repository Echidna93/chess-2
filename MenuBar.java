import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar{
    public MenuBar(){
        JMenu settings = new JMenu("Settings");
        add(settings);
    }    
}