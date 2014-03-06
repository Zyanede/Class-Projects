import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

//FlyWeight factory
public class SwordFlyWeightFactory {
	private List<SwordFlyWeight> pool;

	public SwordFlyWeightFactory() {
		pool = new ArrayList<SwordFlyWeight>();
	}

	public SwordFlyWeight getSword(Color c) {
		// check if we've already created a Sword with this color
		for (SwordFlyWeight Sword : pool) {
			if (Sword.getColor().equals(c)) {
				System.out.println("Sword already created in color : "+c.toString());
				return Sword;
			}
		}
		// if not, create one and save it to the pool
		SwordFlyWeight Sword = new Sword(c);
		pool.add(Sword);
		System.out.println("Sword created and added to the pool in color: "+c.toString());
		return Sword;
	}

}
