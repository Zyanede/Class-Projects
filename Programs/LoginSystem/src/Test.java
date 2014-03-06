import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {

	public static DatabaseConnect con;
	
    public static void main(String[] args) {
    	
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy h:mm:ss a");
    	String formattedDate = sdf.format(date);
    	System.out.println(formattedDate);
    	
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        		con = new DatabaseConnect();
        		System.out.println("Connection : " + con.doConnection());
        		
    			try {
					con.loginCheck("mu95423@georgiasouthern.edu","wcsu8");
					con.logOut();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
}
