package rob.stuff;

import javax.swing.ImageIcon;

public class Basic extends SwordDecorator
{
		public Basic (Sword decoratedSword) {
	        super(decoratedSword);
	    }
		
		/*Overridden Methods*/
	    public double getCost() 
	    {
	        return super.getCost() + 0;
	    }
	 
	    public String getQualities() {
	    	return "Basic "+super.getQualities();
	    }

		@Override
		public ImageIcon getImage() {
			return new ImageIcon("res/basicsword.png");
		}
}
