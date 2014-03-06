package rob.stuff;

import javax.swing.ImageIcon;

class Shoddy extends SwordDecorator {
    
	public Shoddy (Sword decoratedSword) {
        super(decoratedSword);
    }
	
	/*Overridden Methods*/
    public double getCost() 
    {
        return super.getCost() -1;
    }
 
    public String getQualities() {
    	return "Shoddy "+super.getQualities();
    }

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/shoddysword.png");
	}
}
 
