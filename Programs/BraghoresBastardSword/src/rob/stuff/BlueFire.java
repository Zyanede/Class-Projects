package rob.stuff;

import javax.swing.ImageIcon;

public class BlueFire extends SwordDecorator
{
	public BlueFire (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() + 29;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Blue Fire "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/bluefiresword.png");
	}
}
