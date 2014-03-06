import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class algo_panel extends JPanel {
	JLabel arrayDisplay, sortedArrayDisplay, bubbleLabel, insertionLabel,
			selectionLabel, quickLabel, bubbletimer, insertiontimer,
			selectiontimer, quicktimer, arraysizelbl;
	JTextField arraysize;
	ImageIcon bubble;
	JScrollPane arrayscroll, arrayscroll2;
	long startTime, endTime, duration;

	JButton generate, sort;

	public algo_panel() {
		setLayout(null);
		setBounds(0, 0, frame.WIDTH, frame.HEIGHT);
		arrayDisplay = new JLabel("Please generate your next array");
		arrayDisplay.setSize(600, 15);
		arrayDisplay.setLocation(10, 10);
		arrayscroll = new JScrollPane(arrayDisplay,
				JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		arrayscroll.setSize(674, 40);
		arrayscroll.setLocation(10, 10);
		add(arrayscroll);
		
		sortedArrayDisplay = new JLabel("");
		sortedArrayDisplay.setSize(600, 15);
		sortedArrayDisplay.setLocation(10, 40);
		arrayscroll2 = new JScrollPane(sortedArrayDisplay,
				JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		arrayscroll2.setSize(674, 40);
		arrayscroll2.setLocation(10, 54);
		add(arrayscroll2);

		bubbleLabel = new JLabel(
				"<html><font color='blue'>Bubble Sort</font></html>");
		bubbleLabel.setSize(80, 20);
		bubbleLabel.setLocation(10, frame.HEIGHT - 90);
		add(bubbleLabel);
		insertionLabel = new JLabel(
				"<html><font color='purple'>Insertion Sort</font></html>");
		insertionLabel.setSize(80, 20);
		insertionLabel.setLocation(130, frame.HEIGHT - 90);
		add(insertionLabel);
		selectionLabel = new JLabel(
				"<html><font color='green'>Selection Sort</font></html>");
		selectionLabel.setSize(80, 20);
		selectionLabel.setLocation(250, frame.HEIGHT - 90);
		add(selectionLabel);
		quickLabel = new JLabel(
				"<html><font color='red'>Quick Sort</font></html>");
		quickLabel.setSize(80, 20);
		quickLabel.setLocation(370, frame.HEIGHT - 90);
		add(quickLabel);

		bubbletimer = new JLabel("-----");
		bubbletimer.setSize(90, 20);
		bubbletimer.setLocation(10, frame.HEIGHT - 70);
		add(bubbletimer);
		insertiontimer = new JLabel("-----");
		insertiontimer.setSize(90, 20);
		insertiontimer.setLocation(130, frame.HEIGHT - 70);
		add(insertiontimer);
		selectiontimer = new JLabel("-----");
		selectiontimer.setSize(90, 20);
		selectiontimer.setLocation(250, frame.HEIGHT - 70);
		add(selectiontimer);
		quicktimer = new JLabel("-----");
		quicktimer.setSize(90, 20);
		quicktimer.setLocation(370, frame.HEIGHT - 70);
		add(quicktimer);

		arraysizelbl = new JLabel("Array length:");
		arraysizelbl.setSize(160, 25);
		arraysizelbl.setLocation(frame.WIDTH - 180, frame.HEIGHT - 175);
		arraysizelbl.setHorizontalAlignment(JLabel.RIGHT);
		add(arraysizelbl);

		arraysize = new JTextField("10");
		arraysize.setSize(160, 25);
		arraysize.setLocation(frame.WIDTH - 180, frame.HEIGHT - 145);
		arraysize.setHorizontalAlignment(JLabel.RIGHT);
		add(arraysize);

		generate = new JButton("Generate Array");
		generate.setSize(160, 30);
		generate.setLocation(frame.WIDTH - 180, frame.HEIGHT - 115);
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bubbletimer.setText("-----");
					insertiontimer.setText("-----");
					selectiontimer.setText("-----");
					quicktimer.setText("-----");
					sortedArrayDisplay.setText("");
					array.ARRAYSIZE = Integer.parseInt(arraysize.getText());
					array.genArray();
					String output = "";
					for (int i = 0; i < array.CURRENTARRAY.length; i++) {
						int str = array.CURRENTARRAY[i];
						if (i == array.CURRENTARRAY.length - 1) {
							output = output + str;
						} else {
							output = output + (str + ", ");
						}
					}
					arrayDisplay.setText("{" + output + "}");
				} catch (Exception e1) {
					arrayDisplay
							.setText("<html><font color=red>Error. You broke it.");
					sortedArrayDisplay.setText("");
				}

			}
		});
		add(generate);

		sort = new JButton("Sort Array");
		sort.setSize(160, 30);
		sort.setLocation(frame.WIDTH - 180, frame.HEIGHT - 75);
		sort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// tester bubble sort to initialize times & duration
					startTime = System.nanoTime();
					sorts.bubbleSort(array.CURRENTARRAY);
					endTime = System.nanoTime();
					duration = endTime - startTime;
					
					startTime = System.nanoTime();
					sorts.bubbleSort(array.CURRENTARRAY);
					endTime = System.nanoTime();
					duration = endTime - startTime;
					bubbletimer.setText(duration / 1000 + " ms");

					startTime = System.nanoTime();
					sorts.insertionSort(array.CURRENTARRAY1);
					endTime = System.nanoTime();
					duration = endTime - startTime;
					insertiontimer.setText(duration / 1000 + " ms");

					startTime = System.nanoTime();
					sorts.selectionSort(array.CURRENTARRAY2);
					endTime = System.nanoTime();
					duration = endTime - startTime;
					selectiontimer.setText(duration / 1000 + " ms");

					startTime = System.nanoTime();
					sorts.quickSort(array.CURRENTARRAY3);
					endTime = System.nanoTime();
					duration = endTime - startTime;
					quicktimer.setText(duration / 1000 + " ms");

					String output = "";
					int[] displayArray = sorts
							.insertionSort(array.CURRENTARRAY);
					for (int i = 0; i < displayArray.length; i++) {
						int str = displayArray[i];
						if (i == displayArray.length - 1) {
							output = output + str;
						} else {
							output = output + (str + ", ");
						}
					}
					sortedArrayDisplay.setForeground(new Color(110, 110, 110));
					sortedArrayDisplay.setText("{" + output + "}");

				} catch (Exception e2) {

				}
			}
		});
		add(sort);

		setFocusable(true);
		setVisible(true);
	}
}
