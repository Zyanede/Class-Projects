import java.util.ArrayList;

public class ComputerTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("intro");
		list.add("start");
		list.add("inciting incident");
		list.add("obstacle to overcome");
		list.add("midpoint");
		list.add("obstacle to overcome");
		list.add("climax");
		list.add("resolve");
		list.add("The End");
		
		VideoCardPlug pl = new VideoAdapter();
		pl.printList(list);
	}
}
