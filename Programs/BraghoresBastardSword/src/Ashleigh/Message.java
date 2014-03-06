package Ashleigh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Message {

	static ImageIcon welcomeii, minutes5ii, minutes5oii, offerlunaii,
			offerroyii, offervladenii, offerxenaii, offerzhangii;
	static JLabel welcomejl, minutes5jl, minutes5ojl, offerlunajl, offerroyjl,
			offervladenjl, offerxenajl, offerzhangjl;
	static boolean ready = false;

	public Message() {

		// welcome message
		welcomeii = new ImageIcon("res/welcome.png");
		welcomejl = new JLabel(welcomeii);
		welcomejl.setSize(300, 200);
		GUIActivity.messagejp.add(welcomejl);
		welcomejl.setVisible(true);
		// 5minute warning
		minutes5ii = new ImageIcon("res/minutes5.png");
		minutes5jl = new JLabel(minutes5ii);
		minutes5jl.setSize(300, 200);
		GUIActivity.messagejp.add(minutes5jl);
		minutes5jl.setVisible(false);
		// time is up
		minutes5oii = new ImageIcon("res/minutes5o.png");
		minutes5ojl = new JLabel(minutes5oii);
		minutes5ojl.setSize(300, 200);
		GUIActivity.messagejp.add(minutes5ojl);
		minutes5ojl.setVisible(false);
		// offers
		offerlunaii = new ImageIcon("res/offerluna.png");
		offerlunajl = new JLabel(offerlunaii);
		offerlunajl.setSize(300, 200);
		GUIActivity.messagejp.add(offerlunajl);
		offerlunajl.setVisible(false);
		offerroyii = new ImageIcon("res/offerroy.png");
		offerroyjl = new JLabel(offerroyii);
		offerroyjl.setSize(300, 200);
		GUIActivity.messagejp.add(offerroyjl);
		offerroyjl.setVisible(false);
		offervladenii = new ImageIcon("res/offervladen.png");
		offervladenjl = new JLabel(offervladenii);
		offervladenjl.setSize(300, 200);
		GUIActivity.messagejp.add(offervladenjl);
		offervladenjl.setVisible(false);
		offerxenaii = new ImageIcon("res/offerxena.png");
		offerxenajl = new JLabel(offerxenaii);
		offerxenajl.setSize(300, 200);
		GUIActivity.messagejp.add(offerxenajl);
		offerxenajl.setVisible(false);
		offerzhangii = new ImageIcon("res/offerzhang.png");
		offerzhangjl = new JLabel(offerzhangii);
		offerzhangjl.setSize(300, 200);
		GUIActivity.messagejp.add(offerzhangjl);
		offerzhangjl.setVisible(false);

		// welcome!
		Timer tw = new Timer(5000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				welcomejl.setVisible(false);

				Minutes5();
			}
		});
		tw.setRepeats(false);
		tw.start();

		// 5 minutes over!
		Timer t5o = new Timer(300000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				minutes5ojl.setVisible(true);
				ready = false;

				Timer t = new Timer(5000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						minutes5ojl.setVisible(false);
						ready = true;
					}
				});
				t.setRepeats(false);
				t.start();
			}
		});
		t5o.setRepeats(false);
		t5o.start();
	}

	public static void Minutes5() {

		// welcome!
		minutes5jl.setVisible(true);
		Timer t5 = new Timer(5000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				minutes5jl.setVisible(false);
				ready = true;
			}
		});
		t5.setRepeats(false);
		t5.start();
	}
}
