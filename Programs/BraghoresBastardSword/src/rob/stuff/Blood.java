package rob.stuff;

import javax.swing.ImageIcon;

public class Blood extends SwordDecorator
{
	public Blood (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() + 27;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Bloodied "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/bloodsword.png");
	}
}