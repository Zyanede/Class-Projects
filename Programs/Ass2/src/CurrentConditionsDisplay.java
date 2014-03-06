
public class CurrentConditionsDisplay implements Observer, DisplayElement{
	private float muffins;
	private float bagels;
	private float cupcakes;
	private float cakes;
	private float tea;
	private Subject storeData;
	
	public CurrentConditionsDisplay(Subject storeData){
		this.storeData = storeData;
		storeData.registerObserver(this);
	}
	
	public void update(float muffins, float bagels, float cupcakes, float cakes, float tea){
		this.muffins = muffins;
		this.bagels = bagels;
		this.cupcakes = cupcakes;
		this.cakes = cakes;
		this.tea = tea;
		display();
	}
	
	public void display(){
		System.out.println("Current stock: " + muffins + " muffins, " + bagels + " bagels, " + cupcakes + " cupcakes, " + cakes + " cakes, and " + tea + " tea.");
	}
}
