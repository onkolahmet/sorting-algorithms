public class mergeSort {
  static long counter ;
  public mergeSort() {
		counter = 0; 	
		}
  
    void merge(int arr[], int l, int m, int r , long counter) 
    { 
    	
        // Find sizes of two subarrays to be merged 
        
    	int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        {
        	//counter++ ;
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    int[] sort(int array[], int l, int r)
    { 
    	counter++ ;
    	int arr[] = array.clone();
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            arr = sort(arr, l, m); 
            arr = sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r , counter); 
        }
        return arr;
    } 
   
    public long getCounter() {
	  return counter ; 
   }
    
    
    /* A utility function to print array of size n */
}
