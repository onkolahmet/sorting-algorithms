public class insertionSort {
	static long  counter  ;
	public insertionSort() {
	counter = 0; 	
	}

	public int[] insertionsort(int[] array ){
		int[] arr = array.clone();
		int n = arr.length;
        for (int i = 1; i < n ; i++) {
            int temp = arr[i];
            int hole = i;           
            while(counter++ >= 0 && hole>0 && arr[hole-1] > temp ){
                arr[hole] = arr[hole-1];
                hole--;
            }
            arr[hole] = temp;
        }
        return arr;
	}
	
	public long getCounter() {
		  return counter ; 
	   }


}
