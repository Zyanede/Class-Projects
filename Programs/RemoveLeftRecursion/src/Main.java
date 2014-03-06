/*
 * Ashleigh Amrine - 12/5/2013
 * 
 * Removed Left Recursion:
 * X => AS | A
 * S => +AS | -AS | +A | -A
 * A => CB | C
 * B => *CB | /CB | *C | /C
 * C => n | (x) | v
 */

public class Main {
	private static char[] cs;
	private static boolean accepted;

	public static void main(String[] args) {
		// testing data
		check("word");
		check("+200+5");
		check("3+5");
		check("4+)5");
		check("N*b");
		check("123/*123*5*123/5*1");
		check("ahsuskjsa8*as*sd5s");
		check("");
		check("_12");
		check("a1b2*s3/158//");
	}

	public static void check(String s) {
		//convert string to char array
		cs = s.toCharArray();
		//reset accepted
		accepted = true;
		//start X method at beginning
		X(0);
		//print result
		System.out.println("'"+s+"' ---- "+accepted);
	}

	public static void X(int i) {
		//variable for S
		int iS = i;
		try {
			//set S variable to a plus, minus, or end of array
			while (((cs[iS] != '+') && (cs[iS] != '-')) && (cs.length - 1 > iS)) {
				iS++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("String not accepted : ERROR in X check at "
					+ iS + "pos");
			accepted = false;
		}

		try {
			//if variable S contains a plus or minus, execute A & S
			if ((cs[iS] == '+') || (cs[iS] == '-')) {
				System.out.println("In X: Executing A & S");
				A(i);
				S(iS + 1);
			//else execute A
			} else {
				System.out.println("In X: Executing A");
				A(i);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("String not accepted : ERROR in X execute at "
					+ iS + "pos");
			accepted = false;
		}
	}

	public static void A(int i) {
		int iB = i;
		try {
			//increment iB to the end, *, or /
			while (((cs[iB] != '*') && (cs[iB] != '/')) && (cs.length - 1 > iB)) {
				iB++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("String not accepted : ERROR in A check at "
					+ iB + "pos");
			accepted = false;
		}

		try {
			//if B variable position is * or /, execute C & B
			if ((cs[iB] == '*') || (cs[iB] == '/')) {
				System.out.println("In A: Executing C & B");
				C(i);
				B(iB + 1);
			//execute c
			} else if (Character.isDigit(cs[i]) || Character.isLetter(cs[i])) {
				System.out.println("In A: Executing C");
				C(i);
			} else {
				System.out.println("String not accepted : ERROR in A execute at "
						+ iB + "pos");
				accepted = false;
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("String not accepted : ERROR in A execute at "
					+ iB + "pos");
			accepted = false;
		}
	}

	public static void S(int i) {
		int iS = i;
		try {
			//set S variable to position of +, -, or last position
			while (((cs[iS] != '+') && (cs[iS] != '-')) && (cs.length - 1 > iS)) {
				iS++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("String not accepted : ERROR in S check at "
					+ iS + "pos");
			accepted = false;
		}

		try {
			//if S position is + or -, execute A & S
			if ((cs[iS] == '+') || (cs[iS] == '-')) {
				System.out.println("In S: Executing A & S");
				A(i);
				S(iS + 1);
			} else {
				System.out.println("In S: Executing A");
				A(i);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("String not accepted : ERROR in A execute at "
					+ iS + "pos");
			accepted = false;
		}
	}

	public static void B(int i) {
		int iB = i;
		try {
			//set position of B if equal to *, /, or the end
			while (((cs[iB] != '*') && (cs[iB] != '/')) && (cs.length - 1 > iB)) {
				iB++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("String not accepted : ERROR in B check at "
					+ iB + "pos");
		}

		try {
			//if B position is * or /, execute C & B
			if ((cs[iB] == '*') || (cs[iB] == '/')) {
				System.out.println("In B: Executing C & B");
				C(i);
				B(iB + 1);
			} else {
				System.out.println("In B: Executing C");
				C(i);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("String not accepted : ERROR in B execute at "
					+ iB + "pos");
			accepted = false;
		}
	}

	public static void C(int i) {
		try {
			//if current position is a letter or digit dont do anything
			if ((Character.isDigit(cs[i]) || Character.isLetter(cs[i]))) {
				System.out.println("In C: Executing letter or number");
			//if current position is a parenthesis
			} else if (cs[i] == '(') {
				System.out.println("In C: Executing X");
				X(i);
			} else {
				//if none are accepted then set to false
				System.out.println("String not accepted : Error in C - "
						+ cs[i]);
				accepted = false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("String not accepted : ERROR in C execute at "
					+ i + "pos");
			accepted = false;
		}
	}
}
