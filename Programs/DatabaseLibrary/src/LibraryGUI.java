import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LibraryGUI extends JFrame{
	
	static JPanel jpStore, jpEvents, jpSearch;
	static JPanel jpMedia;
	static JLabel jlStoreTitle, jlEventsTitle, jlSearchTitle;
	static JTextField tfSearch;
	
	public LibraryGUI() {
		
		jpStore = new JPanel();
		add (jpStore);
		jpStore.setSize(320, 150);
		jpStore.setLocation(30, 20);
		jpStore.setBackground(Color.gray);
		jpStore.setVisible(true);
		
		jpEvents = new JPanel();
		add (jpEvents);
		jpEvents.setSize(600,150);
		jpEvents.setLocation(370, 20);
		jpEvents.setBackground(Color.gray);
		jpEvents.setVisible(true);
		
		jpSearch = new JPanel();
		add (jpSearch);
		jpSearch.setSize(320, 350);
		jpSearch.setLocation(30, 190);
		jpSearch.setBackground(Color.gray);
		jpSearch.setVisible(true);
		
		jpMedia = new JPanel();
		add (jpMedia);
		jpMedia.setSize(600, 350);
		jpMedia.setLocation(370, 190);
		jpMedia.setBackground(Color.gray);
		jpMedia.setVisible(true);
		
		tfSearch = new JTextField("Enter Search Team");
		add(tfSearch);
		tfSearch.setSize(150,20);
		tfSearch.setLocation(110, 380);
		tfSearch.setEditable(true);
		tfSearch.setToolTipText("Enter Search Term");
		
		tfSearch.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        tfSearch.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	//do nothing
		    }
		});
		
		jlEventsTitle = new JLabel("Current Events:");
		jpEvents.add (jlEventsTitle);
		jlEventsTitle.setForeground(Color.white);
		
		jlStoreTitle = new JLabel("Store Stock:");
		jpStore.add (jlStoreTitle);
		jlStoreTitle.setForeground(Color.white);
		
		jlSearchTitle = new JLabel("Search Library:");
		jpSearch.add (jlSearchTitle);
		jlSearchTitle.setForeground(Color.white);
		
		// adding board
//		add(new Pane());
		setTitle("Jovanovic Library");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1005, 590);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
	}

}
