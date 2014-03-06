package rob.stuff;

import javax.swing.ImageIcon;

public class Ice extends SwordDecorator
{
	public Ice (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +22;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Icy "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/icesword.png");
	}
}
