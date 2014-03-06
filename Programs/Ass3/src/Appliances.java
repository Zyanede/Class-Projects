public class Appliances extends HomeDecorator {
	public Appliances(Home specialHome) {
		super(specialHome);
	}

	public String makeHome() {
		return specialHome.makeHome() + addAppliances();
	}

	private String addAppliances() {
		return " + appliances";
	}
}
