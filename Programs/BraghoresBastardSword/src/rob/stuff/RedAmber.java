package rob.stuff;

import javax.swing.ImageIcon;

public class RedAmber extends SwordDecorator
{
	public RedAmber (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +30;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Red Amber "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/redambersword.png");
	}
}
