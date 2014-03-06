package rob.stuff;

import javax.swing.ImageIcon;

public class Spikey extends SwordDecorator
{
	public Spikey (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +4;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Spikey "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/spikeysword.png");
	}
}
