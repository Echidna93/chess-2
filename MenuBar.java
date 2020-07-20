/**
 * <p> MenuBar class holds the menu bar holds the top navigation bar for settings &c as needed
 * 
 * @author Alexander Jack
 */

import javax.swing.JMenu;
import javax.swing.JMenuBar;
public class MenuBar extends JMenuBar{
    public MenuBar(){
        JMenu settings = new JMenu("Settings");
        JMenu logs = new JMenu("Logs");
        add(settings);
        add(logs);
    }    
}