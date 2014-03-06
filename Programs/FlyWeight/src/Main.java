import java.awt.Color;
import java.awt.Point;


public class Main {
	public static void main(String[] args) {
		SwordFlyWeightFactory factory = new SwordFlyWeightFactory();
		SwordFlyWeight Sword = factory.getSword(Color.RED);
		SwordFlyWeight Sword2 = factory.getSword(Color.RED);
		SwordFlyWeight Sword3 = factory.getSword(Color.GREEN);

		//can use the Swords independently
		Sword.draw(new Point(100, 100));
		Sword2.draw(new Point(200, 100));
		Sword3.draw(new Point(100,200));
	}
}
