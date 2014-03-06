
import java.awt.BorderLayout;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class frame extends JFrame{
	public static final int WIDTH = 700;
	public static final int HEIGHT = 300;
	public static final String NAME = "Algorithm Speed Analysis - Ashleigh Amrine -Algorithms Assignment 1";
	public static final JPanel displayPanel = new algo_panel();
	
	
	public frame(){
		setTitle(NAME);
		setMinimumSize(new Dimension(WIDTH, HEIGHT ));
		setMaximumSize(new Dimension(WIDTH , HEIGHT));
		setPreferredSize(new Dimension(WIDTH , HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(displayPanel);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		
			
	}
}
