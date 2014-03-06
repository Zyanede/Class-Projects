package Ashleigh;

import java.awt.event.*;

import javax.swing.*;

import rob.stuff.Sword;

public class Shelves {

	// main button
	JButton shelf = new JButton();
	// used to find if the shelf is Empty
	boolean isEmpty = true;
	// used for finding the Swords qualities
	Sword shelfSword = null;

	int swordConstant;// finding out which sword is being used
	static boolean activeSwords[];
	static int count[];

	public Shelves(int x, int y) {
		// activesword array
		activeSwords = new boolean[20];
		count = new int[20];

		// Making the shelf button invisible
		shelf.setOpaque(false);
		shelf.setContentAreaFilled(false);
		shelf.setBorderPainted(false);

		// set location and size
		shelf.setLocation(x, y);
		shelf.setSize(48, 48);

		// actions events
		shelf.addMouseListener(new MouseAdapter() {

			@Override
			// right click deletes sword
			public void mouseReleased(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					if ((GUIActivity.onStock && !isEmpty)
							&& !GUIActivity.isOpen) {
						// check that user is currently stocking and shelf isnt
						// empty
						shelf.setIcon(null); // delete the sword image from
												// shelf
						shelfSword = null; // delete the sword qualities
						isEmpty = true; // make shelf empty

						SwordStock.addSword(swordConstant);
						count[swordConstant]--;
						if(count[swordConstant] <= 0)
							count[swordConstant] = 0;
						if (count[swordConstant] <= 0)
							activeSwords[swordConstant] = false;
						// adds the deleted sword back to the stock
					}
					if (GUIActivity.isOpen)
						CloseTip();
				}
				// left click places sword on shelf
				if (SwingUtilities.isLeftMouseButton(e)) {
					if (GUIActivity.newSword != null) {
						if ((GUIActivity.onStock && isEmpty)
								&& !GUIActivity.isOpen) {
							// check to that is user is stocking and shelf is
							// empty
							shelfSword = GUIActivity.newSword;
							// get the sword that is to be placed on the shelf
							getItem(shelfSword.getImage());
							// used to get the item picture
							isEmpty = false; // making the shelf not empty

							swordConstant = Slot.selected;
							// getting the sword constant so know which sword
							// was placed

							SwordStock.removeSword(Slot.selected);
							// removes one of the swords that is placed
							// in that method, if the stock goes to zero, it
							// will delete the sword from the stock
							count[swordConstant]++;
							activeSwords[swordConstant] = true;

						}
						if (GUIActivity.isOpen)
							CloseTip();
					}
				}
			}

			// display the qualities
			public void mouseEntered(MouseEvent arg) {
				// first make sure that the shelf has a sword
				if (shelfSword != null) {
					// turn the cost into a string
					Double price = shelfSword.getCost();
					String cost = Double.toString(price);
					// display the cost and qualities
					GUIActivity.hoverStat.setText(shelfSword.getQualities());
					GUIActivity.hoverCost.setText(cost);
					GUIActivity.hoverStock.setText("");
					GUIActivity.hoverPanel.setLocation(
							((int) shelf.getX() + 50),
							((int) shelf.getY()) - 20);
					GUIActivity.hoverPanel.setVisible(true);
				}
			}

			// remove the quality display while it is not hovering over it
			public void mouseExited(MouseEvent arg) {
				GUIActivity.hoverPanel.setVisible(false);
			}
		});
	}

	// get the items
	// this will be changed to adjust to swords
	public void getItem(ImageIcon sword) {

		shelf.setIcon(sword);

	}

	// return the button
	public JButton makeButton() {
		return shelf;
	}

	public void CloseTip() {
		GUIActivity.tipClose.setVisible(true);

		Timer t = new Timer(3000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIActivity.tipClose.setVisible(false);
			}
		});
		t.setRepeats(false);
		t.start();
	}

}
