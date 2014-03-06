package rob.stuff;

public class Main {

	public static void main(String[] args) 
	{
		/*So this function exists only to illustrate how the 
		 *factory works. It's a singleton, so you grab the
		 *instance of it like so:
		 */
		SwordFactory factory = SwordFactory.getInstance();
		
		//Then make a sword, and call your factory's make method with the constant of the sword you want to make
		Sword sward = factory.makeSword(RobConstants.Shoddy);
		Sword sword = factory.makeSword(RobConstants.Basic);
		Sword swordé = factory.makeSword(RobConstants.Grand);
		Sword bersturd = factory.makeSword(RobConstants.Menacing);
		
		//And voila, they all have different costs and strings. Bam bam boom.
		System.out.println(sward.getQualities()+", $"+sward.getCost());
		System.out.println(sword.getQualities()+", $"+sword.getCost());
		System.out.println(bersturd.getQualities()+", $"+bersturd.getCost());
		System.out.println(swordé.getQualities()+", $"+swordé.getCost());
	}

}
