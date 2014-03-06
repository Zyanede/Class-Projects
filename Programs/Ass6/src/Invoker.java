import java.util.ArrayList;

public class Invoker {
	private Calculator calculator = new Calculator();
	private ArrayList<Command> commands = new ArrayList<Command>();

	private int current = 0;

	public void redo(int levels) {
		System.out.println("\n---- Redo " + levels + " levels ");
		// Perform redo operations
		for (int i = 0; i < levels; i++) {
			if (current < commands.size()) {
				Command command = commands.get(current++);
				command.execute();
			}
		}
	}

	public void undo(int levels) {
		System.out.println("\n---- Undo " + levels + " levels ");
		// Perform undo operations
		for (int i = 0; i < levels; i++) {
			if (current >= 0) {
				Command command = commands.get(--current);
				command.unExecute();
			}
		}
	}

	public void compute(char operator, int operand) {
		// Create command operation and execute it
		Command command = new CalculatorCommand(calculator, operator, operand);
		command.execute();

		// Add command to undo list
		commands.add(command);
		current++;
	}
}
