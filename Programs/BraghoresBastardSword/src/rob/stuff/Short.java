package rob.stuff;

import javax.swing.ImageIcon;

public class Short extends SwordDecorator
{
	public Short (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() + 1.5;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Short "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/shortsword.png");
	}
}
