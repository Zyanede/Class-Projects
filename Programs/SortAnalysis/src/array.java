import java.util.Random;

public class array {
	public static int ARRAYSIZE;
	public static int[] CURRENTARRAY, CURRENTARRAY1, CURRENTARRAY2,
			CURRENTARRAY3;

	public static void genArray() {
		Random rand = new Random();
		CURRENTARRAY = new int[ARRAYSIZE];
		for (int i = 0; i < CURRENTARRAY.length; i++) {
			CURRENTARRAY[i] = rand.nextInt(100);
		}
		CURRENTARRAY1 = CURRENTARRAY;
		CURRENTARRAY2 = CURRENTARRAY;
		CURRENTARRAY3 = CURRENTARRAY;
	}

}
