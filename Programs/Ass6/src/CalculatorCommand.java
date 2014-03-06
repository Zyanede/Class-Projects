public class CalculatorCommand implements Command {
	private char operator;
	private int operand;
	private Calculator calculator;

	public CalculatorCommand(Calculator calculator, char operator, int operand) {
		this.calculator = calculator;
		this.operator = operator;
		this.operand = operand;
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public int getOperand() {
		return operand;
	}

	public void setOperand(int operand) {
		this.operand = operand;
	}

	public void execute() {
		calculator.operation(operator, operand);
	}

	public void unExecute() {
		calculator.operation(undo(operator), operand);
	}

	// Private helper function
	private char undo(char operator) {
		char undo;
		switch (operator) {
		case '+':
			undo = '-';
			break;
		case '-':
			undo = '+';
			break;
		case '*':
			undo = '/';
			break;
		case '/':
			undo = '*';
			break;
		default:
			undo = ' ';
			break;
		}
		return undo;
	}
}
