package Ashleigh;

import java.awt.Point;

public class Node 
{
	private Point position;
	public Boolean occupied = false;
	static Node[] allNodes = null;
	
	public Node(int x, int y)
	{
		position = new Point(x, y);
	}
	
	public static void initializeNodes()
	{
		allNodes = new Node[22];
		allNodes[0] = new Node(550, 120);
		allNodes[1] = new Node(550, 170);
		allNodes[2] = new Node(550, 220);
		allNodes[3] = new Node(550, 270);
		allNodes[4] = new Node(550, 320);
		allNodes[5] = new Node(575, 380);
		allNodes[6] = new Node(600, 120);
		allNodes[7] = new Node(600, 220);
		allNodes[8] = new Node(600, 270);
		allNodes[9] = new Node(600, 320);
		allNodes[10] = new Node(650, 120);
		allNodes[11] = new Node(760, 50);
		allNodes[12] = new Node(700, 120);
		allNodes[13] = new Node(825, 170);
		allNodes[14] = new Node(825, 220);
		allNodes[15] = new Node(825, 270);
		allNodes[16] = new Node(825, 320);
		allNodes[17] = new Node(825, 370);
		allNodes[18] = new Node(770, 220);
		allNodes[19] = new Node(770, 270);
		allNodes[20] = new Node(770, 320);
		allNodes[21] = new Node(825, 120);
	}
	
	public int getX()
	{
		return position.x;
	}
	
	public int getY()
	{
		return position.y;
	}
}
