package rob.stuff;

import javax.swing.ImageIcon;

//The abstract Sword class defines the functionality of a Sword implemented by decorator
public abstract class Sword 
{
	public abstract double getCost(); // returns the total cost of the item
	public abstract String getQualities(); // returns the qualities of the sword
	
	public abstract ImageIcon getImage();
}

