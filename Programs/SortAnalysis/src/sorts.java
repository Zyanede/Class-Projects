
public class sorts {
	/*This is the bubble sort algorithm.
	It is very simple, it goes through the array comparing
	integers 2 at a time. If the left integer is smaller
	than the right integer, it swaps them. Otherwise, it
	takes no action and then moves on to compare the next
	two integers.*/
	public static int[] bubbleSort(int[] array){
	    for(int i = 0; i < array.length; i++){
	    	for(int j = 1; j < (array.length - i); j++){
	    		//if left integer is great then right integer
	    		if(array[j - 1] > array[j]){
	    			//then swap
	    			swap(array,j,j-1);
	    		}	
	    	}    
	    }
	    //It will return the array sorted from the smallest to 
	    //the largest element.
	    return array;
	}
	
	
	/*This is the insertion sort algorithm.
	It is also very simple. It keeps track of a sorted
	array, starting at the beginning of the unsorted array
	and incrementing by one each time it inserts and value.
	It takes the first value that has yet to be inserted into
	the sorted array and continually compares it to the value 
	left of it until it finds a value smaller than it. Then 
	it inserts it.*/
	public static int[] insertionSort(int[] array){
		for(int i = 1; i < array.length; i++){
			int x = array[i];
			for (int j = i - 1; j >= 0 && x < array[j]; j--){
				array[j + 1] = array[j];
				array[j + 1] = x;
			}
		}
		return array;
	}
	
	
	
	
	/*This is the selection sort.
	It is also very simple. It makes note of the first
	number and then walks through the array comparing it
	to each other value. When it finds a value lower than it,
	it swaps the two values and then continues to compare
 	the new first value to the values remaining in the array.
	It rinses and repeats leaving the lowest unsorted digit in 
	the earliest spot available.*/
	public static int[] selectionSort(int[] array){
		for(int i = 0; i < array.length; i++){
			for(int j = i; j < array.length; j++){
				if(array[j] < array[i]){
					//swap lower integer at j position to the from of
					//the array.
					swap(array,i,j);
				}
			}	
		}
		return array;
	}

	/*This is the quick sort.
	While it was easy to understand, it was by far the most
	difficult to implement. It finds a pivot in the middle
	of the part of the array is is attempting to sort, and then
	icrements a tracker at the beginning of the array and
	decrements a tracker at the end of the array. When it finds
	a number lower on the right side, and number high on the left
	side it swaps them. 
	It then recursively does this to the smaller arrays to the left
	and right of the last pivot.*/
	
	  	public static void quickSort(int[] array) {
		    quickSort(array, 0, array.length - 1);
		 }

		private static void quickSort(int[] array, int first, int last) {
			  if (last > first) {
				  int pivotIndex = partition(array, first, last);
				  quickSort(array, first, pivotIndex - 1);
				  quickSort(array, pivotIndex + 1, last);
			  }
		  }

		  private static int partition(int[] array, int first, int last) {
			  int pivot = array[first]; 
			  int low = first + 1; 
			  int high = last;

			  while (low < high) {
				  while (low <= high && array[low] <= pivot)
					  low++;
				  
				  while (low <= high && array[high] > pivot)
					  high--;
				      if (low < high) {
				    	  int temp = array[high];
				    	  array[high] = array[low];
				    	  array[low] = temp;
				      }
				  
			  }	
			  while (high > first && array[high] >= pivot)
				  high--;
			  
			  if (pivot > array[high]) {
				  array[first] = array[high];
				  array[high] = pivot;
				  return high;  
			  }else{
				  return first;
			  }
		  }
	 
	public static void swap (int[] array, int x, int y){
	      int temp = array[x];
	      array[x] = array[y];
	      array[y] = temp;
	}
	
}