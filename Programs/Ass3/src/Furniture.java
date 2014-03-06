public class Furniture extends HomeDecorator {
	public Furniture(Home specialHome) {
		super(specialHome);
	}

	public String makeHome() {
		return specialHome.makeHome() + addFurniture();
	}

	private String addFurniture() {
		return " + furniture";
	}
}
