package rob.stuff;

import javax.swing.ImageIcon;

public class Poison extends SwordDecorator 
{
	public Poison(Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +24;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Toxic "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/poisonsword.png");
	}
}
