package rob.stuff;

import javax.swing.ImageIcon;

public class Fire extends SwordDecorator
{
	public Fire (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() +21;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Fiery "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/firesword.png");
	}
}
