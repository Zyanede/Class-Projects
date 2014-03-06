/*  Ashleigh Amrine
 *  9/29/2013 -- Ass 5 & 6
 */
public class TestMain {
	public static void main(String args[]) {
		//fresh singleton object and print
		SingletonObject obj = SingletonFactory.getSingletonObject();
		obj.printMe();

		//singleton already constructed so it will only print
		obj = SingletonFactory.getSingletonObject();
		obj.printMe();

		//destroy singleton object
		SingletonFactory.nullifySingletonObject();

		//construct singleton because its been destroyed
		obj = SingletonFactory.getSingletonObject();
		obj.printMe();
	}
}