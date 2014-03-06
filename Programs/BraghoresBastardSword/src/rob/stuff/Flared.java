package rob.stuff;

import javax.swing.ImageIcon;

public class Flared extends SwordDecorator
{
	public Flared (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +6;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Flared "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/flaredsword.png");
	}
}