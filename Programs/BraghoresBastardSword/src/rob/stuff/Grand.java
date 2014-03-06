package rob.stuff;

import javax.swing.ImageIcon;

public class Grand extends SwordDecorator
{
	public Grand (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +20;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Grand "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/grandsword.png");
	}
}
