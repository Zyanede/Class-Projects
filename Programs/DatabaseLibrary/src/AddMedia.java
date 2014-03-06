import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;


public class AddMedia extends JFrame {
	
	AddBook media = new AddBook();
	JRadioButton book = new JRadioButton("Book");
	JRadioButton magazine = new JRadioButton("Magazine");
	JRadioButton video = new JRadioButton("Video");
	ButtonGroup mediaButtons = new ButtonGroup();
	public AddMedia(){
		BorderLayout lay = new BorderLayout();
		setLayout(lay);
		JPanel p1 = new JPanel();
		FlowLayout p1Lay = new FlowLayout(FlowLayout.LEFT);
		p1.setLayout(p1Lay);
		setSize(700,150);
		book.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				media.initiateBook();
			}
			public void focusLost(FocusEvent arg0) {	
			}
		});
		magazine.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				media.initiateMagazine();
			}
			public void focusLost(FocusEvent arg0) {	
			}
		});
		video.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				media.initiateVideo();
			}
			public void focusLost(FocusEvent arg0) {	
			}
		});
		mediaButtons.add(book);
		mediaButtons.add(magazine);
		mediaButtons.add(video);
		p1.add(book);
		p1.add(magazine);
		p1.add(video);
		
		setTitle("Add Media");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
		add(p1, BorderLayout.NORTH);
		add(media, BorderLayout.WEST);
	}
}
