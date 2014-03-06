package Ashleigh;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import rob.stuff.Sword;

@SuppressWarnings("serial")
public class GUIActivity extends JFrame {

	// quite a bit of static and final variables
	static JButton buy, stock, open, close, accept, decline;
	static JLabel bank, hoverStat, hoverCost, hoverStock, openSign, closeSign,
			windowOpen, windowClose, closeTipI, fundsTipI, saleSword;
	static JPanel hoverPanel, itemsStock, itemsBuy, tipClose, tipFunds,
			messagejp;
	static ImageIcon selected, closeImg, openImg, windowCloseImg,
			windowOpenImg, closeTipII, fundsTipII, iiBank, acceptii, declineii;
	static Bank income;
	static Sword newSword;
	static SwordStock swords;
	static Shelves[] shelves;
	static int swordTest = 0;
	static boolean onStock, isOpen, buying = false;

	public GUIActivity() {

		// Make the bank, give you a quick 100 to start out with
		income = new Bank();
		income.Increase(100.00);

		// setting the variables
		// isOpen tells if the store is open, in which the game can be played
		isOpen = false;
		// onStock allows you to place and remove items from shelves
		onStock = true;

		// signs
		closeImg = new ImageIcon("res/closed_sign.png");
		openImg = new ImageIcon("res/open_sign.png");
		windowCloseImg = new ImageIcon("res/windowclosed.png");
		windowOpenImg = new ImageIcon("res/windowopen.png");

		//sword in sale
		saleSword = new JLabel();
		add(saleSword);
		saleSword.setOpaque(false);
		saleSword.setLocation(690, 475);
		saleSword.setSize(100,45);
		saleSword.setVisible(false);
		
		// offer buttons
		acceptii = new ImageIcon("res/accept.png");
		accept = new JButton(acceptii);
		add(accept);
		accept.setOpaque(false);
		accept.setLocation(820, 494);
		accept.setSize(60, 20);
		accept.setVisible(false);
		declineii = new ImageIcon("res/decline.png");
		decline = new JButton(declineii);
		add(decline);
		decline.setOpaque(false);
		decline.setLocation(883, 494);
		decline.setSize(60, 20);
		decline.setVisible(false);

		// message panel
		messagejp = new JPanel();
		add(messagejp);
		messagejp.setOpaque(false);
		messagejp.setLocation(650, 320);
		messagejp.setSize(300, 200);
		messagejp.setVisible(true);

		// tip panel close store
		tipClose = new JPanel();
		add(tipClose);
		tipClose.setOpaque(false);
		tipClose.setLocation(265, 0);
		tipClose.setSize(100, 100);
		tipClose.setVisible(false);
		closeTipII = new ImageIcon("res/closeStore.png");
		closeTipI = new JLabel(closeTipII);
		closeTipI.setSize(100, 100);
		tipClose.add(closeTipI);

		// tip panel close store
		tipFunds = new JPanel();
		add(tipFunds);
		tipFunds.setOpaque(false);
		tipFunds.setLocation(30, 0);
		tipFunds.setSize(100, 100);
		tipFunds.setVisible(false);
		fundsTipII = new ImageIcon("res/fundsRequired.png");
		fundsTipI = new JLabel(fundsTipII);
		fundsTipI.setSize(100, 100);
		tipFunds.add(fundsTipI);

		// hover over item panel
		hoverPanel = new JPanel();
		add(hoverPanel);
		hoverPanel.setBackground(Color.decode("#FFFFFF"));
		hoverPanel.setLocation(0, 0);
		hoverPanel.setSize(100, 75);
		hoverPanel.setVisible(false);

		// labels for hover item
		hoverStat = new JLabel("");
		hoverPanel.add(hoverStat);
		hoverCost = new JLabel("");
		hoverPanel.add(hoverCost);
		hoverStock = new JLabel("");
		hoverPanel.add(hoverStock);

		// stock button
		stock = new JButton("Stock");
		add(stock);
		stock.setLocation(30, 161);
		stock.setSize(70, 30);
		stock.setFocusPainted(false);
		stock.setBorder(null);
		stock.setForeground(Color.decode("#FFFFFF"));
		stock.setBackground(Color.decode("#775E4C"));

		// buy button
		buy = new JButton("Buy");
		add(buy);
		buy.setLocation(110, 161);
		buy.setSize(70, 30);
		buy.setFocusPainted(false);
		buy.setBorder(null);
		buy.setForeground(Color.decode("#7D7487"));
		buy.setBackground(Color.decode("#55361F"));

		iiBank = new ImageIcon("res/bank.png");

		// Bank label, showing the money you have
		bank = new JLabel(iiBank);
		add(bank);
		bank.setLocation(0, 70);
		bank.setSize(200, 100);
		bank.setForeground(Color.white);
		bank.setHorizontalTextPosition(SwingConstants.RIGHT);
		bank.setText("" + income.getMoney());

		// open button
		open = new JButton("Open");
		add(open);
		open.setLocation(280, 105);
		open.setSize(70, 30);
		open.setFocusPainted(false);
		open.setBorder(null);
		open.setForeground(Color.decode("#7D7487"));
		open.setBackground(Color.decode("#55361F"));
		open.setVisible(true);

		// close button
		close = new JButton("Close");
		add(close);
		close.setLocation(280, 105);
		close.setSize(70, 30);
		close.setFocusPainted(false);
		close.setBorder(null);
		close.setForeground(Color.decode("#7D7487"));
		close.setBackground(Color.decode("#55361F"));
		close.setVisible(false);

		// open sign
		openSign = new JLabel(openImg);
		add(openSign);
		openSign.setLocation(340, 100);
		openSign.setSize(100, 100);
		openSign.setBorder(null);
		openSign.setVisible(false);

		// close sign
		closeSign = new JLabel(closeImg);
		add(closeSign);
		closeSign.setLocation(340, 100);
		closeSign.setSize(100, 100);
		closeSign.setBorder(null);
		closeSign.setVisible(true);

		// make a JPanel for the itemsStock to be placed
		itemsStock = new JPanel();
		add(itemsStock);
		itemsStock.setBackground(Color.decode("#775E4C"));
		itemsStock.setLocation(30, 205);
		itemsStock.setSize(350, 330);
		itemsStock.setVisible(true);

		// make a JPanel for the itemsBuy to be placed
		itemsBuy = new JPanel();
		add(itemsBuy);
		itemsBuy.setBackground(Color.decode("#775E4C"));
		itemsBuy.setLocation(30, 205);
		itemsBuy.setSize(350, 330);
		itemsBuy.setVisible(false);

		// This makes all the stock buttons
		// they are all invisible and disabled until the stock of the sword is
		// >0
		SwordStock.createButtons();

		windowClose = new JLabel(windowCloseImg);
		add(windowClose);
		windowClose.setLocation(-2, -16);
		windowClose.setSize(1005, 590);
		windowClose.setBorder(null);
		windowClose.setVisible(true);

		windowOpen = new JLabel(windowOpenImg);
		add(windowOpen);
		windowOpen.setLocation(-2, -16);
		windowOpen.setSize(1005, 590);
		windowOpen.setBorder(null);
		windowOpen.setVisible(false);

		shelves = new Shelves[20];
		
		// making the shelves buttons and what not
		final Shelves shelf1 = new Shelves(500, 120);
		add(shelf1.makeButton());
		final Shelves shelf2 = new Shelves(500, 170);
		add(shelf2.makeButton());
		final Shelves shelf3 = new Shelves(500, 220);
		add(shelf3.makeButton());
		final Shelves shelf4 = new Shelves(500, 270);
		add(shelf4.makeButton());
		final Shelves shelf5 = new Shelves(500, 320);
		add(shelf5.makeButton());
		final Shelves shelf6 = new Shelves(550, 70);
		add(shelf6.makeButton());
		final Shelves shelf7 = new Shelves(600, 70);
		add(shelf7.makeButton());
		final Shelves shelf8 = new Shelves(650, 70);
		add(shelf8.makeButton());
		final Shelves shelf9 = new Shelves(875, 370);
		add(shelf9.makeButton());
		final Shelves shelf10 = new Shelves(875, 120);
		add(shelf10.makeButton());
		final Shelves shelf11 = new Shelves(875, 170);
		add(shelf11.makeButton());
		final Shelves shelf12 = new Shelves(875, 220);
		add(shelf12.makeButton());
		final Shelves shelf13 = new Shelves(875, 270);
		add(shelf13.makeButton());
		final Shelves shelf14 = new Shelves(875, 320);
		add(shelf14.makeButton());
		final Shelves shelf15 = new Shelves(670, 270);
		add(shelf15.makeButton());
		final Shelves shelf16 = new Shelves(720, 270);
		add(shelf16.makeButton());
		final Shelves shelf17 = new Shelves(670, 320);
		add(shelf17.makeButton());
		final Shelves shelf18 = new Shelves(670, 220);
		add(shelf18.makeButton());
		final Shelves shelf19 = new Shelves(720, 220);
		add(shelf19.makeButton());
		final Shelves shelf20 = new Shelves(720, 320);
		add(shelf20.makeButton());
		
		shelves[0] = shelf1;
		shelves[1] = shelf2;
		shelves[2] = shelf3;
		shelves[3] = shelf4;
		shelves[4] = shelf5;
		shelves[5] = shelf6;
		shelves[6] = shelf7;
		shelves[7] = shelf8;
		shelves[8] = shelf9;
		shelves[9] = shelf10;
		shelves[10] = shelf11;
		shelves[11] = shelf12;
		shelves[12] = shelf13;
		shelves[13] = shelf14;
		shelves[14] = shelf15;
		shelves[15] = shelf16;
		shelves[16] = shelf17;
		shelves[17] = shelf18;
		shelves[18] = shelf19;
		shelves[19] = shelf20;

		// Make the buttons and stuff do things
		// Make the buttons and stuff do things
		stock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				itemsStock.setVisible(true);
				itemsBuy.setVisible(false);
				// set colors for buttons
				stock.setBackground(Color.decode("#775E4C"));
				stock.setForeground(Color.decode("#FFFFFF"));
				buy.setBackground(Color.decode("#55361F"));
				buy.setForeground(Color.decode("#7D7487"));
				onStock = true;
				buying = false;
			}
		});

		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				itemsStock.setVisible(false);
				itemsBuy.setVisible(true);
				// set colors for buttons
				stock.setBackground(Color.decode("#55361F"));
				stock.setForeground(Color.decode("#7D7487"));
				buy.setBackground(Color.decode("#775E4C"));
				buy.setForeground(Color.decode("#FFFFFF"));
				// changing the variables
				onStock = false;
				newSword = null;
				buying = true;
			}
		});

		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				open.setVisible(false);
				close.setVisible(true);
				closeSign.setVisible(false);
				openSign.setVisible(true);
				windowClose.setVisible(false);
				windowOpen.setVisible(true);
				isOpen = true;
				newSword = null;
			}
		});

		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				close.setVisible(false);
				open.setVisible(true);
				openSign.setVisible(false);
				closeSign.setVisible(true);
				windowOpen.setVisible(false);
				windowClose.setVisible(true);
				isOpen = false;
			}
		});

		new Buy();
		new Message();
		new Customer();
		Node.initializeNodes();
		CustomerDraw.initializeCustomers();
		// adding board
		add(new Board());
		setTitle("Braghore's Bastard Sword -- ALPHA");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1005, 590);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		Timer t = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		t.setRepeats(true);
		t.start();
	}

}
