
public class heal implements Strategy{
	public int execute(int a, int b){
		System.out.println("Healed doing " + b + " restoration!");
		return a + b;
	}
}
