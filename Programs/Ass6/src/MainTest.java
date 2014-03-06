public class MainTest {
	public static void main(String[] args) {
		// Create user and let her compute
		Invoker user = new Invoker();

		user.compute('+', 100);
		user.compute('-', 50);
		user.compute('*', 10);
		user.compute('/', 2);

		// Undo 4 commands
		user.undo(4);

		// Redo 3 commands
		user.redo(3);

	}
}
