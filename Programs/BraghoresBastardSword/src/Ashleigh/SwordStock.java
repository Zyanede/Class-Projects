package Ashleigh;

import javax.swing.JButton;

public class SwordStock {

	// the class to make the number of each sword you have in your stock
	// there most likely is a better way to do this, including using a pattern
	// or something
	// but for now this works pretty good

	// make these three arrays, the slot, the button and the stock number
	static JButton[] stockButtons = new JButton[20];
	static Slot[] slots = new Slot[20];
	static int[] stock = new int[20];

	public static void createButtons() {

		// Makes all the slots
		// on creation, each one is invisible and disabled, and the stock is
		// started at 0
		for (int i = 0; i < 20; i++) {

			slots[i] = new Slot(i);
			stockButtons[i] = slots[i].makeButton();
			GUIActivity.itemsStock.add(stockButtons[i]);
			stockButtons[i].setVisible(false);
			stockButtons[i].setEnabled(false);

			stock[i] = 0;
		}

	}

	// adds another sword based on the constant from Rob's Constants
	// adds another stock every time
	// the setvisible and setEnabled are used to make it appear once the stock
	// is above 0
	public static void addSword(int constant) {

		stock[constant]++;
		slots[constant].UpdateStock();
		GUIActivity.itemsBuy.revalidate();
		GUIActivity.itemsStock.revalidate();
		GUIActivity.itemsBuy.repaint();
		GUIActivity.itemsStock.repaint();

		stockButtons[constant].setVisible(true);
		stockButtons[constant].setEnabled(true);

	}

	// this part removes one sword from the stock
	public static void removeSword(int constant) {

		stock[constant]--;
		slots[constant].UpdateStock();

		GUIActivity.itemsBuy.revalidate();
		GUIActivity.itemsStock.revalidate();
		GUIActivity.itemsBuy.repaint();
		GUIActivity.itemsStock.repaint();
		// if the stock becomes zero, it makes it invisible.
		// the newSword= = null makes sure you cant keep placing swords once
		// they run out
		if (stock[constant] == 0) {
			stockButtons[constant].setVisible(false);
			stockButtons[constant].setEnabled(false);
			GUIActivity.newSword = null;
			Slot.changing = true;
		}
	}

}
