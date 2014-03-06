package rob.stuff;

import javax.swing.ImageIcon;

//extension of a simple coffee without any extra ingredients
public class SimpleSword extends Sword {
	public double getCost() 
	{
		return 2;
	}

	public String getQualities() 
	{
		return "Sword";
	}

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/simplesword.png");
	}
}
