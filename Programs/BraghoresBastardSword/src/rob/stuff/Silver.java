package rob.stuff;

import javax.swing.ImageIcon;

public class Silver extends SwordDecorator
{
	public Silver (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +10;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Silver "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/silversword.png");
	}
}