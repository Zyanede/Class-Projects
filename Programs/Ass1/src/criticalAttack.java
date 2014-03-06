
public class criticalAttack implements Strategy{
	public int execute(int a, int b){
		System.out.println("Critically attacked doing " + b*2 + " damage!");
		return a - b*2;
	}
}
