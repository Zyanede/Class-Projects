import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class AddBook extends JPanel {
	String[] dates = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG",
			"SEP", "OCT", "NOV", "DEC" };
	JTextField title = new JTextField(25);
	JLabel lblDate = new JLabel("");
	JTextField author = new JTextField(25);
	JLabel lblAuthor = new JLabel("");
	JTextField dateYr = new JTextField(2);
	JTextField dateDay = new JTextField(2);
	JComboBox dateMonth = new JComboBox(dates);
	JButton submit = new JButton("Submit New Media");
	String date;
	int index = 0;
	String table;
	AddDataConnect conn = new AddDataConnect();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();

	public AddBook() {
		setVisible(false);
		FlowLayout lay1 = new FlowLayout(FlowLayout.LEFT);
		GridLayout lay = new GridLayout(2,2);
		setLayout(lay);
		setSize(700,150);
		p1.add(new JLabel("Title: "));
		p1.add(title);
		p2.add(lblAuthor);
		p2.add(author);
		p3.add(lblDate);
		p3.add(dateDay);
		p3.add(dateMonth);
		p3.add(dateYr);
		p1.setLayout(lay1);
		p1.setLayout(lay1);
		p1.setLayout(lay1);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				date = sqlPrep(dateDay.getText()) + "-"
						+ (String) dateMonth.getSelectedItem() + "-"
						+ sqlPrep(dateYr.getText());

				try {
					conn.addBook(title.getText(), author.getText(), date, table);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add(p1);
		add(p2);
		add(p3);
		add(submit);
	}

	public static String sqlPrep(String old) {
		String update = "";
		if (old.length() == 1) {
			update = "0" + old;
			return update;
		} else {
			return old;
		}

	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void initiateBook() {
		lblAuthor.setText("Author: ");
		lblDate.setText("Publishing Date (Year-Month-Day): ");
		setVisible(true);
		this.index = 1;
		submit.setText("Submit New Book");
		table = "book";
	}

	public void initiateMagazine() {
		lblAuthor.setText("Publisher: ");
		lblDate.setText("Issue Date (Year-Month-Day): ");
		setVisible(true);
		this.index = 2;
		submit.setText("Submit New Magazine");
		table = "magazine";
	}

	public void initiateVideo() {
		lblAuthor.setText("Director: ");
		lblDate.setText("Release Date (Year-Month-Day): ");
		setVisible(true);
		this.index = 3;
		submit.setText("Submit New Video");
		table = "video";
	}
}
