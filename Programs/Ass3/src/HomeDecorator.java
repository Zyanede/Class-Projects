public class HomeDecorator implements Home {
	protected Home specialHome;

	public HomeDecorator(Home specialHome) {
		this.specialHome = specialHome;
	}

	public String makeHome() {
		return specialHome.makeHome();
	}
}
