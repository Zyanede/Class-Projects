package rob.stuff;

import javax.swing.ImageIcon;

public class Menacing extends SwordDecorator
{
	public Menacing (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +15;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Bastard "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/menacingsword.png");
	}
}