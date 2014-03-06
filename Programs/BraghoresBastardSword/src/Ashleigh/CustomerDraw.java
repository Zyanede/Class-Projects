package Ashleigh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.Timer;

public class CustomerDraw 
{

	static public LinkedList<CustomerDraw> customers = new LinkedList<CustomerDraw>();
	private static final Iterator<CustomerDraw> custIterator = customers.iterator();
	Random rand = new Random();
	Node location = null;
	
	private CustomerDraw() 
	{
		
	}
	static public void initializeCustomers()
	{
		
		for(int i = 0; i<10; i++)
		{
			customers.add(new CustomerDraw());
		}
		Timer t = new Timer(5000, new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				for(Iterator<CustomerDraw> i = customers.iterator(); i.hasNext(); )
				{
					CustomerDraw temp = i.next();
					temp.findNewNode();
				}
			}
		});
		t.setRepeats(true);
		t.start();
		
	}
	
	private void findNewNode()
	{
		for(int i = 0; i<Node.allNodes.length; i++)
		{
			int num = rand.nextInt(Node.allNodes.length);
			if(Node.allNodes[num].occupied == false)
			{
				if(location !=null)
					location.occupied = false;
				location = Node.allNodes[num];
				location.occupied = true;
				System.out.println("Found new node");
				
				break;
			}
		}
	}
	
}
