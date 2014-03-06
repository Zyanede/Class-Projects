
public class CoffeeMaker {
	private Coffee coffee;
	private Heater heater;
	private Steeper steeper;
	private Water water;
	
	public CoffeeMaker(){
		this.coffee = new Coffee();
		this.heater = new Heater();
		this.steeper = new Steeper();
		this.water = new Water();
	}
	
	public void makeCoffee(){
		coffee.fillCoffee();
		water.fillWater();
		heater.heatWater();
		steeper.dripCoffee();
		System.out.println("Coffee is ready!");
	}
}
