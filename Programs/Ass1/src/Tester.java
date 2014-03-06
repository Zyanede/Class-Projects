
public class Tester {
	public static void main (String[] args){
		int health = 100;
		
		System.out.println("Welcome to the autofight dungeon demo\nBEGIN!");
		
		Context context;
		
		context = new Context(new regularAttack());
		int resultA = context.executeStrategy(health, 4);
		health = resultA;

		System.out.println("Health : " + resultA);
		
		context = new Context(new heal());
		int resultB = context.executeStrategy(health, 4);
		health = resultB;

		System.out.println("Health : " + resultB);
		
		context = new Context(new criticalAttack());
		int resultC = context.executeStrategy(health, 4);
		health = resultC;

		System.out.println("Health : " + resultC);
		
		System.out.println("GAME OVER : Thank you for playing!");
	}
}
