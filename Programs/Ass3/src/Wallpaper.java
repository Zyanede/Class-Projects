public class Wallpaper extends HomeDecorator {
	public Wallpaper(Home specialHome) {
		super(specialHome);
	}

	public String makeHome() {
		return specialHome.makeHome() + addWallpaper();
	}

	private String addWallpaper() {
		return " + wallpaper";
	}
}
