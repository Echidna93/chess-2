/**
 * <p> MenuBar class holds the menu bar holds the top navigation bar for settings &c as needed
 * 
 * @author Alexander Jack
 */

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JPanel;

public class MenuBar extends JMenuBar {
    public MenuBar(JPanel board, JPanel sidePanel){
        JMenu settings = new JMenu("Settings");
        JMenu logs = new JMenu("Logs");
        add(settings);
        add(logs);
        logs.addMenuListener(new MenuListener(){
			@Override
			public void menuSelected(MenuEvent e) {
				sidePanel.setVisible(true);
				board.setVisible(false);
				board.revalidate();
				sidePanel.revalidate();
			}
			@Override
			public void menuDeselected(MenuEvent e) {
				sidePanel.setVisible(false);
				board.setVisible(true);
				board.revalidate();
			}
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub				
			}
        });
	}
}