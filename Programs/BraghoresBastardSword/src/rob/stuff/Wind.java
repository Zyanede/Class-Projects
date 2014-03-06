package rob.stuff;

import javax.swing.ImageIcon;

public class Wind extends SwordDecorator
{
	public Wind (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +23;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Windy "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/windsword.png");
	}
}
