import java.util.ArrayList;

public class StoreData implements Subject{
	private ArrayList observers;
	private float muffins;
	private float bagels;
	private float cupcakes;
	private float cakes;
	private float tea;
	
	public StoreData(){
		observers = new ArrayList();
	}
	
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		int i = observers.indexOf(o);
		if(i >= 0){
			observers.remove(i);
		}
	}
	
	public void notifyObservers(){
		for (int i = 0; i < observers.size(); i++){
			Observer observer = (Observer)observers.get(i);
			observer.update(muffins, bagels, cupcakes, cakes, tea);
		}
	}
	
	public void measurementsChanged(){
		notifyObservers();
	}
	
	public void setMeasurements(float muffins, float bagels, float cupcakes, float cakes, float tea){
		this.muffins = muffins;
		this.bagels = bagels;
		this.cupcakes = cupcakes;
		this.cakes = cakes;
		this.tea = tea;
		measurementsChanged();
	}
}
