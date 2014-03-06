package Ashleigh;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import rob.stuff.*;

public class Slot {

	// slot is the actual button variable
	JButton slot;
	// sword factory for factory related things
	SwordFactory factory = SwordFactory.getInstance();
	// newSword is the sword being used
	Sword newSword;
	int swordConstant;
	// selected is used in Shelves class so the shelves know which sword was
	// selected
	static int selected;
	//sword image
	ImageIcon swordImage;
	//sword cost
	double swordCost;

	static DecimalFormat df = new DecimalFormat("#.##");
	static boolean changing = false;

	public Slot(final int constant) {

		newSword = factory.makeSword(constant);
		swordConstant = constant;
		// Making the slot button invisible
		swordImage = newSword.getImage();
		slot = new JButton(swordImage);
		swordCost = newSword.getCost();

		slot.setForeground(Color.white);
		slot.setOpaque(false);
		slot.setContentAreaFilled(false);
		slot.setBorderPainted(false);

		slot.setMargin(new Insets(2, 2, 2, 2));

		UpdateStock();

		// actions events
		slot.addMouseListener(new MouseAdapter() {

			@Override
			// right click deletes sword
			public void mouseReleased(MouseEvent e) {
				// If buying is true, then the slots are swords you can buy
				// When not true, you are looking at your stock that you can
				// place on the shelves
				if (GUIActivity.buying == false) {
					if (SwingUtilities.isLeftMouseButton(e)) {

						// get the actual sword that needs to replaced
						GUIActivity.newSword = newSword;
						// the selected variable equals constant, again to be
						// used in shelves
						selected = constant;
					}
				}

				// When the buying is true, you are looking at slots that you
				// can buy
				// this allows you to buy the swords and places them in the
				// stock
				else if (GUIActivity.buying) {

					// make sure you have enought money to buy the sword
					if (GUIActivity.income.getMoney() >= newSword.getCost()) {

						// adds the sword to the stock
						SwordStock.addSword(constant);
						// takes away the sword's price from your bank
						GUIActivity.income.Spend(newSword.getCost());
						GUIActivity.bank.setText(""
								+ df.format(GUIActivity.income.getMoney()));
						// once it is bought, remove it from the buying options
						GUIActivity.itemsBuy.remove(slot);
						// lowers count in buy

						GUIActivity.hoverPanel.setVisible(false);

						Buy.Destroy();
					} else 
						CloseTip();
				}
			}

			// hovering over the sword will display the qualities
			public void mouseEntered(MouseEvent arg) {
				// convert the getCost into a string
				Double price = newSword.getCost();
				String cost = Double.toString(price);
				// make the hoverPanel display the qualities and cost
				GUIActivity.hoverStat.setText(newSword.getQualities());
				GUIActivity.hoverCost.setText(cost);
				GUIActivity.hoverStock.setText("Stock: "
						+ SwordStock.stock[constant]);
				// Setting the size and making it visible
				GUIActivity.hoverPanel.setLocation(((int) slot.getX()) + 100,
						((int) slot.getY()) + 250);
				GUIActivity.hoverPanel.setVisible(true);
			}

			// one mouse is no longer on the sword, it will remove the hover
			// panel
			public void mouseExited(MouseEvent arg) {
				GUIActivity.hoverPanel.setVisible(false);
			}
		});

		if (changing == true) {
			UpdateStock();
			changing = false;
		}
	}

	// return the button
	public JButton makeButton() {
		return slot;
	}

	public void UpdateStock() {
		slot.setText("x" + SwordStock.stock[swordConstant]);
		slot.setVerticalTextPosition(SwingConstants.BOTTOM);
		slot.setHorizontalTextPosition(SwingConstants.RIGHT);

		GUIActivity.itemsBuy.revalidate();
		GUIActivity.itemsStock.revalidate();
		GUIActivity.itemsBuy.repaint();
		GUIActivity.itemsStock.repaint();
	}

	public void CloseTip() {
		GUIActivity.tipFunds.setVisible(true);

		Timer t = new Timer(3000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIActivity.tipFunds.setVisible(false);
			}
		});
		t.setRepeats(false);
		t.start();
	}
}
