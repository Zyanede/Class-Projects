
public class Main {
	public static void main(String [] args) {
		sumIt(10,3,5);
		sumIt(1000,3,5);
	}
	public static void sumIt(int max, int m1, int m2){
		int sum = 0;
		for(int i=0; i < max;i++){
			if((i%m1 == 0)||(i%m2 == 0))
				sum=sum+i;
		}
		System.out.println(sum);
	}
}
