package Ashleigh;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel {

	private Image bg;
	private Image logo;
	private Image table;
	static private Image customer;
	private Image border_mid;
	private Image border_large;

	public Board() {
		ImageIcon ii_bg = new ImageIcon("res/Game_bg.png");
		ImageIcon ii_logo = new ImageIcon("res/logo.png");
		ImageIcon ii_table = new ImageIcon("res/table.png");
		ImageIcon ii_customer = new ImageIcon("res/cust4.png");
		ImageIcon ii_border_mid = new ImageIcon("res/border_mid.png");
		ImageIcon ii_border_large = new ImageIcon("res/border_large.png");

		bg = ii_bg.getImage();
		logo = ii_logo.getImage();
		table = ii_table.getImage();
		customer = ii_customer.getImage();
		border_mid = ii_border_mid.getImage();
		border_large = ii_border_large.getImage();

	}

	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		g.drawImage(border_large, 12, 180, null);
		g.drawImage(border_mid, 12, 7, null);
		g.drawImage(logo, 58, 25, null);
	//	g.drawImage(sign, 340, 160, null);
		g.drawImage(table, 500, 120, null);
		g.drawImage(table, 500, 170, null);
		g.drawImage(table, 500, 220, null);
		g.drawImage(table, 500, 270, null);
		g.drawImage(table, 500, 320, null);
		g.drawImage(table, 550, 70, null);
		g.drawImage(table, 600, 70, null);
		g.drawImage(table, 650, 70, null);
		g.drawImage(table, 875, 370, null);
		g.drawImage(table, 875, 120, null);
		g.drawImage(table, 875, 170, null);
		g.drawImage(table, 875, 220, null);
		g.drawImage(table, 875, 270, null);
		g.drawImage(table, 875, 320, null);
		g.drawImage(table, 670, 270, null);
		g.drawImage(table, 720, 270, null);
		g.drawImage(table, 670, 320, null);
		g.drawImage(table, 670, 220, null);
		g.drawImage(table, 720, 220, null);
		g.drawImage(table, 720, 320, null);
		if(Node.allNodes != null)
		{
			for(int i = 0; i<Node.allNodes.length; i++)
			{
				Node node = Node.allNodes[i];
				if(node.occupied && GUIActivity.isOpen)
				{
					g.drawImage(customer, node.getX(), node.getY(), null);
				}
			}
		}
	}
}
