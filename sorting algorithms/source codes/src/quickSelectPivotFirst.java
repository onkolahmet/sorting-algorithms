class quickSelectPivotFirst 
{ 	
	static long counter ;
	public quickSelectPivotFirst() {
		counter = 0; 	
		}
	// Standard partition function 
	  int partition(int arr[], 
						int low, int high) 
	{ 
		int temp; 
		int pivot = arr[low]; // selecting first element of the array as pivot 
		int i = (high - 1) , p1 = low +1 ; 
		for (int j = low+ 1; j <= high; j++) 
		{ 
			counter++;
			if (arr[j] < pivot) 
			{ 
				if(j != p1) {
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

	public long getCounter() {
		  return counter ; 
	   }


} 


