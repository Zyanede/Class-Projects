
public class regularAttack implements Strategy{
	public int execute(int a, int b){
		System.out.println("Attacked doing " + b + " damage!");
		return a - b;
	}
}
