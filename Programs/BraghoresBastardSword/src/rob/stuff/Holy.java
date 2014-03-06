package rob.stuff;

import javax.swing.ImageIcon;

public class Holy extends SwordDecorator
{
	public Holy (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +25;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Holy "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/holysword.png");
	}
}
