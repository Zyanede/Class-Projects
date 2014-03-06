
public class SweetStation {
	public static void main(String[] args){
		StoreData storeData = new StoreData();
		
		CurrentConditionsDisplay currentDisplay = 
				new CurrentConditionsDisplay(storeData);
		
		System.out.println("Day 1: Fully stocked!");
		storeData.setMeasurements(20, 20, 20, 10, 40);
		System.out.println("Day 2: Slightly understocked!");
		storeData.setMeasurements(18, 16, 14, 8, 32);
		System.out.println("Day 3: SALE! Sold 50% of stock!");
		storeData.setMeasurements(10, 10, 10, 5, 20);
	}
}
