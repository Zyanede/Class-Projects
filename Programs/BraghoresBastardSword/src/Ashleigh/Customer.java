package Ashleigh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Customer {
	// sales taking place value
	static boolean activeSale = false;
	static DecimalFormat df = new DecimalFormat("#.##");
	
	
	
	public Customer() {

		// welcome!
		Timer t = new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// chooses random customer
				int random = (int) (Math.random() * 8);
				// chooses random sword
				int randomSword = (int) (Math.random() * 20);

				if ((!Message.ready && !activeSale)) {
					GUIActivity.accept.setVisible(false);
					GUIActivity.decline.setVisible(false);
				}

				// check if there is currently a sale active, store is open,
				// message box is freed, and if random sword is on shelf
				if ((!activeSale && GUIActivity.isOpen)
						&& (Message.ready && Shelves.activeSwords[randomSword])) {
					// random customer switch
					switch (random) {
					case 1:
						ExecuteSale(Message.offerlunajl, randomSword);
						break;
					case 2:
						ExecuteSale(Message.offerroyjl, randomSword);
						break;
					case 3:
						ExecuteSale(Message.offervladenjl, randomSword);
						break;
					case 4:
						ExecuteSale(Message.offerxenajl, randomSword);
						break;
					case 5:
						ExecuteSale(Message.offerzhangjl, randomSword);
						break;
					}
				}
			}
		});
		t.setRepeats(true);
		t.start();
	}

	public static void ExecuteSale(final JLabel jl, final int randSword) {

		// sets customer to active
		jl.setVisible(true);
		// sets accept and decline buttons active
		GUIActivity.accept.setVisible(true);
		GUIActivity.decline.setVisible(true);
		// sale in progress
		activeSale = true;

		// sword original cost
		double cost = SwordStock.slots[randSword].swordCost;

		// random offer
		final double randOffer = (cost - (cost / 6))
				+ (Math.random() * (cost / 2));
		// setting offer
		GUIActivity.saleSword.setIcon(SwordStock.slots[randSword].swordImage);
		GUIActivity.saleSword.setText("" + df.format(randOffer));
		// displaying offer
		GUIActivity.saleSword.setVisible(true);

		GUIActivity.accept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// point in shelf array
				int i = 0;
				while (activeSale) {
					if (GUIActivity.shelves[i].swordConstant == randSword) {
						// check that user is currently stocking and shelf isnt
						// empty
						GUIActivity.shelves[i].shelf.setIcon(null); // delete
																	// the sword
																	// image
																	// from
						// shelf
						GUIActivity.shelves[i].shelfSword = null; // delete the
																	// sword
																	// qualities
						GUIActivity.shelves[i].isEmpty = true; // make shelf
																// empty
//
//						SwordStock.removeSword(randSword);
						GUIActivity.income.Increase(randOffer);
						GUIActivity.bank.setText(""
								+ df.format(GUIActivity.income.getMoney()));

						jl.setVisible(false);
						GUIActivity.accept.setVisible(false);
						GUIActivity.decline.setVisible(false);
						GUIActivity.saleSword.setVisible(false);
						activeSale = false;

						Shelves.count[randSword]--;

						if (Shelves.count[randSword] <= 0)
							Shelves.activeSwords[randSword] = false;
						// returns from sale
						return;
					}
					i++;
				}
			}

		});
		GUIActivity.decline.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jl.setVisible(false);
				GUIActivity.accept.setVisible(false);
				GUIActivity.decline.setVisible(false);
				GUIActivity.saleSword.setVisible(false);
				activeSale = false;
				// returns from sale
				return;
			}

		});

		// // timer for sale expiring if no action is taken
		// Timer t = new Timer(20000, new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// //check if sale is still active
		// if (activeSale) {
		// jl.setVisible(false);
		// GUIActivity.accept.setVisible(false);
		// GUIActivity.decline.setVisible(false);
		// GUIActivity.saleSword.setVisible(false);
		// activeSale = false;
		// //returns from sale
		// return;
		// }
		// }
		// });
		// t.setRepeats(false);
		// t.start();
	}

}
