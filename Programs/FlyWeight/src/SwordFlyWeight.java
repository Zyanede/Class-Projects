import java.awt.Color;
import java.awt.Point;

//Flyweight
public interface SwordFlyWeight
{
	public Color getColor();
	public void draw(Point location);
}