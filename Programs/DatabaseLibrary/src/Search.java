import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

public class Search extends JPanel {
	private static boolean DEBUG = false;
	DatabaseConnect con;
	public static JFrame frame;
	private JPanel jpStore, jpEvents, jpSearch, jpFilter, jpMedia, jpTop,
			jpSearchCtg, jpSearchField, jpSearchOpt, jpSearchB, jpInsert, jpInsertArea, jpDate;
	private ImageIcon bookH, bookU, magH, magU, videoH, videoU, mediaS, authH,
			authU, titleH, titleU, dirU, dirH, pubU, pubH, searchBU, searchBH,
			insertBU, insertBH;
	private JLabel jlBook, jlMag, jlVideo, jltitle, jlauth, jldir, jlpub,
			jlsearchB, jlititle, jldate, jlauthor, jlinsert;
	private JTable table;
	private JTextField filterText, searchText, title, author,
			dateYr;
	private String[] dates = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL",
			"AUG", "SEP", "OCT", "NOV", "DEC" };
	private String[] days = { "01", "02", "03", "04", "05", "06", "07",
			"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	private JComboBox dateMonth = new JComboBox(dates);
	private JComboBox dateDay = new JComboBox(days);
	private TableRowSorter<MyTableModel> sorter;
	private static String currCat, currOpt, date, insertTable;
	private int index = 0;
	private MyTableModel model;

	public Search() {
		super();

		con = new DatabaseConnect();
		System.out.println("Connection : " + con.doConnection());
		try {
			con.printBooksByStock(1);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		currCat = "book";
		currOpt = "title";

		setLayout(new BorderLayout(20, 20));
		setBackground(Color.gray);

		jpTop = new JPanel();
		add(jpTop, BorderLayout.NORTH);
		jpTop.setBackground(Color.gray);
		jpTop.setVisible(true);

		jpStore = new JPanel();
		jpTop.add(jpStore, BorderLayout.EAST);
		jpStore.setBackground(Color.gray);
		jpStore.setVisible(true);

		jpEvents = new JPanel();
		jpTop.add(jpEvents, BorderLayout.WEST);
		jpEvents.setBackground(Color.gray);
		jpEvents.setVisible(true);

		jpSearch = new JPanel();
		add(jpSearch, BorderLayout.WEST);
		jpSearch.setLayout(new BoxLayout(jpSearch, BoxLayout.PAGE_AXIS));
		jpSearch.setBackground(Color.decode("#c1c1c1"));
		jpSearch.setVisible(true);

		jpSearchCtg = new JPanel();
		jpSearch.add(jpSearchCtg);
		jpSearchCtg.setLayout(new BoxLayout(jpSearchCtg, BoxLayout.LINE_AXIS));
		jpSearchCtg.setBackground(Color.gray);
		jpSearchCtg.setVisible(true);

		jpSearchField = new JPanel();
		jpSearch.add(jpSearchField);
		jpSearchField.setLayout(new BoxLayout(jpSearchField,
				BoxLayout.PAGE_AXIS));
		jpSearchField.setBackground(Color.decode("#c1c1c1"));
		jpSearchField
				.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		jpSearchField.setVisible(true);

		jpSearchB = new JPanel();
		jpSearch.add(jpSearchB);
		jpSearchB.setLayout(new BoxLayout(jpSearchB, BoxLayout.LINE_AXIS));
		jpSearchB.setBackground(Color.decode("#c1c1c1"));
		jpSearchB.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		jpSearchB.setVisible(true);

		jpSearchOpt = new JPanel();
		jpSearchB.add(jpSearchOpt);
		jpSearchOpt.setLayout(new BoxLayout(jpSearchOpt, BoxLayout.PAGE_AXIS));
		jpSearchOpt.setBackground(Color.decode("#c1c1c1"));
		jpSearchOpt.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 50));
		jpSearchOpt.setVisible(true);

		jpInsert = new JPanel();
		jpSearch.add(jpInsert);
		jpInsert.setLayout(new BoxLayout(jpInsert, BoxLayout.LINE_AXIS));
		jpInsert.setBackground(Color.decode("#c1c1c1"));
		jpInsert.setBorder(BorderFactory.createEmptyBorder(10, 20, 200, 20));
		jpInsert.setVisible(true);

		jpInsertArea = new JPanel();
		jpInsert.add(jpInsertArea);
		jpInsertArea.setLayout(new BoxLayout(jpInsertArea, BoxLayout.PAGE_AXIS));
		jpInsertArea.setBackground(Color.decode("#c1c1c1"));
		jpInsertArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 50));
		jpInsertArea.setVisible(true);
		
		jpDate = new JPanel();
		jpInsertArea.add(jpDate);
		jpDate.setLayout(new BoxLayout(jpDate, BoxLayout.LINE_AXIS));
		jpDate.setBackground(Color.decode("#c1c1c1"));
		jpDate.setVisible(true);

		jpMedia = new JPanel(new BorderLayout());
		add(jpMedia, BorderLayout.CENTER);
		jpMedia.setBackground(Color.gray);
		jpMedia.setVisible(true);

		jpFilter = new JPanel(new BorderLayout());
		jpMedia.add(jpFilter, BorderLayout.SOUTH);

		// Create a table with a sorter.
		model = new MyTableModel();
		sorter = new TableRowSorter<MyTableModel>(model);
		table = new JTable(model);
		table.setRowSorter(sorter);
		table.setPreferredScrollableViewportSize(new Dimension(700, 470));
		table.setFillsViewportHeight(true);

		// For the purposes of this application, better to have single selection
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		jpMedia.add(scrollPane, BorderLayout.NORTH);

		// category image icons
		bookH = new ImageIcon("res/bookH.png");
		bookU = new ImageIcon("res/bookU.png");
		magH = new ImageIcon("res/magH.png");
		magU = new ImageIcon("res/magU.png");
		videoH = new ImageIcon("res/videoH.png");
		videoU = new ImageIcon("res/videoU.png");
		authH = new ImageIcon("res/authH.png");
		authU = new ImageIcon("res/authU.png");
		titleH = new ImageIcon("res/titleH.png");
		titleU = new ImageIcon("res/titleU.png");
		dirH = new ImageIcon("res/dirH.png");
		dirU = new ImageIcon("res/dirU.png");
		pubH = new ImageIcon("res/pubH.png");
		pubU = new ImageIcon("res/pubU.png");

		// search icon
		searchBH = new ImageIcon("res/searchBH.png");
		searchBU = new ImageIcon("res/searchBU.png");

		jlBook = new JLabel(bookH);
		jpSearchCtg.add(jlBook);
		jlBook.setBorder(null);
		jlBook.setVisible(true);
		jlBook.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				currCat = "book";
				jlMag.setIcon(magU);
				jlVideo.setIcon(videoU);
				jlBook.setIcon(bookH);
				
				//set insert options
				jlauthor.setText("Author: ");

				// set options visibility
				jlauth.setVisible(true);
				jldir.setVisible(false);
				jlpub.setVisible(false);
				currOpt = "title";
				jltitle.setIcon(titleH);
				jlauth.setIcon(authU);
				jlpub.setIcon(pubU);
				jldir.setIcon(dirU);
			}
		});

		jlMag = new JLabel(magU);
		jpSearchCtg.add(jlMag);
		jlMag.setBorder(null);
		jlMag.setVisible(true);
		jlMag.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				currCat = "magazine";
				jlMag.setIcon(magH);
				jlVideo.setIcon(videoU);
				jlBook.setIcon(bookU);

				//set insert options
				jlauthor.setText("Publisher: ");
				
				// set options visibility
				jlauth.setVisible(false);
				jldir.setVisible(false);
				jlpub.setVisible(true);
				currOpt = "title";
				jltitle.setIcon(titleH);
				jlauth.setIcon(authU);
				jlpub.setIcon(pubU);
				jldir.setIcon(dirU);
			}
		});

		jlVideo = new JLabel(videoU);
		jpSearchCtg.add(jlVideo);
		jlVideo.setBorder(null);
		jlVideo.setVisible(true);
		jlVideo.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				currCat = "video";
				jlMag.setIcon(magU);
				jlVideo.setIcon(videoH);
				jlBook.setIcon(bookU);

				//set insert options
				jlauthor.setText("Director: ");
				
				// set options visibility
				jlauth.setVisible(false);
				jldir.setVisible(true);
				jlpub.setVisible(false);
				currOpt = "title";
				jltitle.setIcon(titleH);
				jlauth.setIcon(authU);
				jlpub.setIcon(pubU);
				jldir.setIcon(dirU);
			}
		});

		// media search icon
		mediaS = new ImageIcon("res/search.png");

		// Search Field
		JLabel lsearch = new JLabel(mediaS);
		jpSearchField.add(lsearch);
		searchText = new JTextField("Enter Search Term",
				SwingConstants.TRAILING);
		jpSearchField.add(searchText);
		searchText.setEditable(true);
		searchText.setMaximumSize(new Dimension(
				searchText.getMaximumSize().width,
				searchText.getMinimumSize().height));
		searchText.setToolTipText("Select a category and enter a search term");
		searchText.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				searchText.setText("");
			}

			public void focusLost(FocusEvent e) {
				// do nothing
			}
		});

		jltitle = new JLabel(titleH);
		jpSearchOpt.add(jltitle);
		jltitle.setBorder(null);
		jltitle.setVisible(true);
		jltitle.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				currOpt = "title";
				jltitle.setIcon(titleH);
				jlauth.setIcon(authU);
				jlpub.setIcon(pubU);
				jldir.setIcon(dirU);
			}
		});

		jlauth = new JLabel(authU);
		jpSearchOpt.add(jlauth);
		jlauth.setBorder(null);
		jlauth.setVisible(true);
		jlauth.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				currOpt = "author";
				jltitle.setIcon(titleU);
				jlauth.setIcon(authH);
				jlpub.setIcon(pubU);
				jldir.setIcon(dirU);
			}
		});

		jlpub = new JLabel(pubU);
		jpSearchOpt.add(jlpub);
		jlpub.setBorder(null);
		jlpub.setVisible(false);
		jlpub.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				currOpt = "publisher";
				jltitle.setIcon(titleU);
				jlauth.setIcon(authU);
				jlpub.setIcon(pubH);
				jldir.setIcon(dirU);
			}
		});

		jldir = new JLabel(dirU);
		jpSearchOpt.add(jldir);
		jldir.setBorder(null);
		jldir.setVisible(false);
		jldir.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				currOpt = "director";
				jltitle.setIcon(titleU);
				jlauth.setIcon(authU);
				jlpub.setIcon(pubU);
				jldir.setIcon(dirH);
			}
		});

		jlsearchB = new JLabel(searchBU);
		jpSearchB.add(jlsearchB);
		jlsearchB.setBorder(null);
		jlsearchB.setVisible(true);
		jlsearchB.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				jlsearchB.setIcon(searchBH);
			}

			public void mouseReleased(MouseEvent e) {
				jlsearchB.setIcon(searchBU);
				try {
					con.printBySearch(currCat, searchText.getText(), currOpt);
					model.fireTableStructureChanged();
					model.fireTableDataChanged();
					table.getModel();
					table.revalidate();
					table.repaint();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		});

		jlititle = new JLabel("Title: ");
		jpInsertArea.add(jlititle);
		jlititle.setVisible(true);
		title = new JTextField();
		jpInsertArea.add(title);
		title.setEditable(true);
		title.setMaximumSize(new Dimension(
				title.getMaximumSize().width,
				title.getMinimumSize().height));
		title.setToolTipText("Enter a title for your entry");
		title.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				title.setText("");
			}

			public void focusLost(FocusEvent e) {
				// do nothing
			}
		});

		jlauthor = new JLabel("Author: ");
		jpInsertArea.add(jlauthor);
		jlauthor.setVisible(true);
		author = new JTextField();
		jpInsertArea.add(author);
		author.setEditable(true);
		author.setMaximumSize(new Dimension(
				author.getMaximumSize().width,
				author.getMinimumSize().height));
		author.setToolTipText("Enter an author for your entry");
		author.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				author.setText("");
			}

			public void focusLost(FocusEvent e) {
				// do nothing
			}
		});
		
		jldate = new JLabel("Date: ");
		jpDate.add(jldate);
		jldate.setVisible(true);
		
		jpDate.add(dateDay);
		dateDay.setEditable(true);
		jpDate.add(dateMonth);
		
		dateYr = new JTextField("2013");
		jpDate.add(dateYr);
		dateYr.setEditable(true);
		dateYr.setMaximumSize(new Dimension(
				dateYr.getMaximumSize().width,
				dateYr.getMinimumSize().height));
		dateYr.setToolTipText("Enter a year");
		dateYr.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				dateYr.setText("");
			}

			public void focusLost(FocusEvent e) {
				// do nothing
			}
		});
		
		insertBU = new ImageIcon("res/insertBU.png");
		insertBH = new ImageIcon ("res/insertBH.png");
		
		jlinsert = new JLabel(insertBU);
		jpInsert.add(jlinsert);
		jlinsert.setBorder(null);
		jlinsert.setVisible(true);
		jlinsert.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				jlinsert.setIcon(insertBH);
			}

			public void mouseReleased(MouseEvent e) {
				jlinsert.setIcon(insertBU);
				try {
					date = (dateDay.getSelectedItem().toString()+"-"+dateMonth.getSelectedItem().toString()+"-"+dateYr.getText());
					con.addMedia(title.getText(), author.getText(), date, currCat);
					model.fireTableStructureChanged();
					model.fireTableDataChanged();
					table.getModel();
					table.revalidate();
					table.repaint();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
		});

		// Create a separate form for filterText
		JLabel l1 = new JLabel("  Filter Result :  ");
		jpFilter.add(l1, BorderLayout.WEST);
		filterText = new JTextField("Enter Filter Term",
				SwingConstants.TRAILING);
		// Whenever filterText changes, invoke newFilter.
		filterText.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newFilter();
			}

			public void insertUpdate(DocumentEvent e) {
				newFilter();
			}

			public void removeUpdate(DocumentEvent e) {
				newFilter();
			}
		});
		l1.setLabelFor(filterText);
		jpFilter.add(filterText, BorderLayout.CENTER);
		filterText.setEditable(true);
		filterText.setToolTipText("Enter a filter term for your search result");

		filterText.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				filterText.setText("");
			}

			public void focusLost(FocusEvent e) {
				// do nothing
			}
		});
	}

	/**
	 * Update the row filter regular expression from the expression in the text
	 * box.
	 */
	private void newFilter() {
		RowFilter<MyTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(filterText.getText(), 0);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	static class MyTableModel extends AbstractTableModel {
		private static String[] columnNames;
		private static Object[][] data;

		public static void setColumnNames(String[] columnNamesT) {
			columnNames = columnNamesT;
		}

		public static void setData(Object[][] dataT) {
			data = dataT;
			System.out.println(data.length);
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		/*
		 * JTable uses this method to determine the default renderer/ editor for
		 * each cell. If we didn't implement this method, then the last column
		 * would contain text ("true"/"false"), rather than a check box.
		 */
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		public boolean isCellEditable(int row, int col) {
			// no matter where the cell appears onscreen.
			return false;
		}

		private void printDebugData() {
			int numRows = getRowCount();
			int numCols = getColumnCount();

			for (int i = 0; i < numRows; i++) {
				System.out.print("    row " + i + ":");
				for (int j = 0; j < numCols; j++) {
					System.out.print("  " + data[i][j]);
				}
				System.out.println();
			}
			System.out.println("--------------------------");
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	static void createAndShowGUI() {
		// Create and set up the window.
		frame = new JFrame("Jovanovic Library");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1005, 590);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);

		// Create and set up the content pane.
		Search newContentPane = new Search();
		// newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.setVisible(true);
	}
}
