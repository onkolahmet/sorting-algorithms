class quickSelectMOT 
{ 	
	static long counter ;
	
	public quickSelectMOT() {
	counter =0 ;	
	}
	// Standard  partition function 
	  int partition(int arr[], 
						int low, int high) 
	{ 
		int temp; 
		int pivot = medianOfThree(arr, low, high); 
		int i = (high - 1) , p1 = low +1 ; 
		for (int j = low+ 1; j <= high; j++) 
		{ 	
			if (arr[j] < pivot) 
			{ 
				if(counter++ >= 0 && j != p1) {
				temp = arr[p1] ;
				arr[p1] = arr[j] ;
				arr[j] = temp ;
				}
				p1++; 
			} 
		} 
		
		arr[low] = arr[p1-1] ;
		arr[p1-1] = pivot ;
		return (p1-1); 
	} 
	
	// Implementation of QuickSelect 
	int kthSmallest(int a[], int left, 
						int right, int k) 
	{ 
		while (left <= right) 
		{ 
	
			// Partition a[left..right] around a pivot 
			// and find the position of the pivot 
			int pivotIndex = partition(a, left, right); 
	
			// If pivot itself is the k-th smallest element 
			if (pivotIndex == k - 1) 
				return a[pivotIndex]; 
	
			// If there are more than k-1 elements on 
			// left of pivot, then k-th smallest must be 
			// on left side. 
			else if (pivotIndex > k - 1) 
				right = pivotIndex - 1; 
	
			// Else k-th smallest is on right side. 
			else
				left = pivotIndex + 1; 
		} 
		return -1; 
	}
	
	// selecting pivot using medianOfThree algorithm
	int medianOfThree(int arr[], int low, int high) {
		int center = (int) Math.ceil((low+high)/2);
		int three[] = {arr[low], arr[center], arr[high]};
		three = insertionSort(three);
		if(three[1] == arr[low]) {
			return low;
		}else if(three[2] == arr[center]){
			return center;
		}else {
			return high;
		}
		
	}
	
	public int[] insertionSort(int[] array){
		int[] arr = array.clone();
		int n = arr.length;
        for (int i = 1; i < n ; i++) {
            int temp = arr[i];
            int hole = i;
            while(hole>0 && arr[hole-1] > temp){ 
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


