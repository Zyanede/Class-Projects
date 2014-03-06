package Ashleigh;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Buy {

	public static int count = 0;

	public Buy() {

		// MOVEMENT REFERENCE
		int delay = 500; // milliseconds
		ActionListener taskPerformer = new ActionListener() {
			int random = 0;

			public void actionPerformed(ActionEvent evt) {
				// we did the task till buy is full
				random = (int) (Math.random() * 100);
				Create((int) (random / 5));
				DestroyTimed();
				count++;
			}
		};
		new Timer(delay, taskPerformer).start();

	}

	public static void Create(int c) {
		Component[] comps = GUIActivity.itemsBuy.getComponents();
		if (comps.length < 20) {
			if ((10 <= c) && (30 > Math.random() * 100)) {
				final Slot slot = new Slot(c);
				GUIActivity.itemsBuy.add(slot.makeButton());
			}
			if (10 > c) {
				final Slot slot = new Slot(c);
				GUIActivity.itemsBuy.add(slot.makeButton());
			}
			setGUI();
		}
	}

	public static void DestroyTimed() {
		// // create stuff
		Timer t = new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Component[] comps = GUIActivity.itemsBuy.getComponents();
				if ((comps.length > 0) && (count == 5)) {
					GUIActivity.itemsBuy.remove(comps[0]);
					setGUI();
					count = 0;
				}
			}
		});
		t.setRepeats(true);
		t.start();

	}

	public static void Destroy() {
		setGUI();
	}

	public static void setGUI() {
		GUIActivity.itemsBuy.revalidate();
		GUIActivity.itemsBuy.repaint();
	}
}