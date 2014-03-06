import java.util.ArrayList;

public class VideoAdapter implements VideoCardPlug{
	public void printList(ArrayList<String> list){
		String listString = "";
		
		for (String s : list){
			listString += s + "\t";
		}
		
		TelevisionSocket printImage=new TelevisionSocket();
		printImage.print(listString);
	}
}
