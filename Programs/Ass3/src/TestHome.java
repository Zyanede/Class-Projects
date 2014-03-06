public class TestHome {
	public static void main(String args[]){
		Home home = new Furniture(new Wallpaper(new Appliances(new Family(new SimpleHome()))));
		System.out.println(home.makeHome());
	}
}
