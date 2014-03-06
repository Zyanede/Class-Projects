package rob.stuff;

import javax.swing.ImageIcon;

public class Knightly extends SwordDecorator
{
	public Knightly (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +12;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Kightly "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/knightlysword.png");
	}
}