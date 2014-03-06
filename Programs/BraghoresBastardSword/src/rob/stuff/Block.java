package rob.stuff;

import javax.swing.ImageIcon;

public class Block extends SwordDecorator
{
	public Block (Sword decoratedSword) {
        super(decoratedSword);
    }
 
	/*Cost is changed here*/
    public double getCost() 
    { 
        return super.getCost() + 28;
    }
    /*Title is added here*/
    public String getQualities() {
    	return "Large Block "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/blocksword.png");
	}
}
