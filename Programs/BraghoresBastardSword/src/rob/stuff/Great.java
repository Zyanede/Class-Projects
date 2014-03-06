package rob.stuff;

import javax.swing.ImageIcon;

public class Great extends SwordDecorator
{
	public Great (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +8;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Great "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		
		return new ImageIcon("res/greatsword.png");
	}
}