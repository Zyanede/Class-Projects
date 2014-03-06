package Ashleigh;

public class Bank {
	
	//the double that displays your money
	static double money;
	
	//get method
	public double getMoney(){
		
		return money;
	}
	
	//the spend and increase methods.
	//these two can probably be used as the same, but instead of trying to use negatives having two methods is easier
	public void Spend(double price){
		
		money = money - price;
	}
	
	public void Increase(double change){
		money = money + change;
	}

}
