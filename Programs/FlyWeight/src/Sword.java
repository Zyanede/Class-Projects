import java.awt.Color;
import java.awt.Point;

//ConcreteFlyweight
public class Sword implements SwordFlyWeight {
	private Color color;

	public Sword(Color c) {
		color = c;
	}

	public Color getColor() {
		return color;
	}

	public void draw(Point location) {
		// draw the character on screen
	}

}
