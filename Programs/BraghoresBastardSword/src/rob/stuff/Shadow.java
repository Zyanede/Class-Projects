package rob.stuff;

import javax.swing.ImageIcon;

public class Shadow extends SwordDecorator {
	public Shadow(Sword decoratedSword) {
		super(decoratedSword);
	}

	/* Cost is changed here */
	public double getCost() {
		return super.getCost() + 23;
	}

	/* Title is added here */
	public String getQualities() {
		return "Shadow " + super.getQualities();
	}

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("res/shadowsword.png");
	}
}