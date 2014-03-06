import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MediaController {
	JRadioButton book = new JRadioButton("Book");
	JRadioButton magazine = new JRadioButton("Book");
	JRadioButton video = new JRadioButton("Book");
	ButtonGroup mediaButtons = new ButtonGroup();
	MediaController(){
		JPanel p1 = new JPanel();
		FlowLayout p1Lay = new FlowLayout(FlowLayout.LEFT);
		p1.setLayout(p1Lay);
		
		book.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				
			}

			public void focusLost(FocusEvent arg0) {
				
			}
		});
		
		mediaButtons.add(book);
		mediaButtons.add(magazine);
		mediaButtons.add(video);
	}
}
