public class Family extends HomeDecorator {
	public Family(Home specialHome) {
		super(specialHome);
	}

	public String makeHome() {
		return specialHome.makeHome() + addFamily();
	}

	private String addFamily() {
		return " + family";
	}
}
