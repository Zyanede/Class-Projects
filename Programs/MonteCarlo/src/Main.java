import java.text.DecimalFormat;

public class Main {
	double divider = 0.5;

	public static void main(String[] args) {
		// print column names
		System.out.println("n\t\ttrue\t\tappValue\t%error"); 
		
		// do monte carlos
		monteCarlo(100);
		monteCarlo(1000);
		monteCarlo(100000);
		monteCarlo(200000);
	}

	//monte carlo
	public static void monteCarlo(int n) {
		double sum = getSum(n);
		double appVal = getAppValue(sum, n);
		double actVal = getActValue();
		double error = getError(appVal, actVal);

		// format decimal for print columns
		DecimalFormat df = new DecimalFormat("#.00000");

		// print rows
		System.out.println(n+"\t\t" + df.format(actVal) + "\t\t"
				+ df.format(appVal) + "\t\t"
				+ df.format(error)+"%");
	}
	 
	// get sum of n random numbers
	public static double getSum(int n) {
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum += function(Math.random());
		}
		return sum;
	}
	
	//integration of cosx
	public static double function(double n) {
		return Math.cos(n);
	}

	// approximated value is the average
	public static double getAppValue(double n, int m) {
		return (n / m);
	}
	
	//actual value
	public static double getActValue() {
		return (Math.sin(1) - Math.sin(0));
	}

	// distance from divider
	public static double getError(double n, double m) {
		return Math.abs(((n-m)/m)*100);
	}

	// whether or not it falls within the range of below divider or above
	public static double getTrue(double n, int m) {
//		return (n / m);
		return 0.1;
	}
}
