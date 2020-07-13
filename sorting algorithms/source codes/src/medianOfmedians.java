public class medianOfmedians {
	static long counter ;
	public medianOfmedians() {
		counter = 0; 	
		}
	//Function to invoke LinearSelect
	public int LS(int[] S, int k){
        if (S.length == 1)
        	return S[0];
       
        return linearSelect(0, S.length - 1, S, k);
	}
    
    //do linearSelect in a recursive way 
    public  int linearSelect(int left, int right, int[] array, int k){
    	//if there is only one element now, just record.
    	if (left>=right){
    		return array[left];
    	}
    	//do the partition 
    	int p = pickCleverPivot(left, right, array);
    	int eIndex = partition(left, right, array, p);
    	//after the partition, do following ops
    	if (k <= eIndex){
    		return linearSelect(left, eIndex-1, array, k);
    	} else if(k == eIndex + 1) {
    		return array[eIndex];
    	} else {
    		return linearSelect(eIndex + 1,right, array, k);
    	}

    }
    //do Partition with a pivot
    public int partition(int left, int right, int[] array, int pIndex){
    	//move pivot to last index of the array
    	swap(array, pIndex, right);
    	int p = array[right];
    	int l = left;
    	int r = right-1;
  
    	while( l <= r){
    		while(counter++ >= 0 && l <= r && array[l] <= p){
    			l++;
    		}
    		while(l <= r && array[r] >= p){
    			r--;
    		}
    		if ( l < r){
    			swap(array, l, r);
    		}
    	}

        swap(array, l, right);
    	return l;
    }

    //Pick a random pivot to do the LinearSelect
	//Implementation inspired from pseudocode provided in lectures
	public int pickCleverPivot(int left, int right, int[] array){
		int n = array.length;
		//Base case: If array length is less than 5, get median of it
		if ((right - left) < 5) {
			return getMedianValue(left, right, array);
		}//end if		
		int count = left;		
		//Divide array into subgroups of 5
		//Sort respective subarray to retrieve its median
		for (int i = left; i <= right; i += 5) {		
			int tempRight = i + 4;		
			if (tempRight > right) {
				tempRight = right;
			}//end if		
			int medianSubgroup;
			
			if ((tempRight - i) <= 2) {
				continue;
			} else {
				medianSubgroup = getMedianValue(i, tempRight, array); //Retrieve median of subarray
			}			
			//Swap median to front of array
			swap(array, medianSubgroup, count);	
			count++;
		}//end for
		
		//Recursively call pickCleverPivot for median of medians
		return pickCleverPivot(left, count, array);		
	}//end pickCleverPivot
	
	
	public int getMedianValue(int left, int right, int[] array){	
		//Sort that subarray! (Using insertion sort that is.)
		for (int i = left; i <= right; i++){			
			int j = i;
			while (j > left && array[j-1] > array[j]) {
				swap(array, j, j-1);
				j -= 1;
			}//end while
		}//end for	
		int medianPos = 0;
		//Check if length of subarray is even or not
		//Implementation inspired by code found here: http://stackoverflow.com/a/11955900		
		if ((right - left) % 2 == 0) {
			//Retrieve value left of middle to be treated as median
			medianPos = ((right - left) / 2) - 1;
		} else {
			medianPos = (right - left) / 2;
		}//end if/else statement

		return left + medianPos;

	}//end getMedianValue

	//swap two elements in the array
	public void swap(int[]array, int a, int b){
 		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public long getCounter() {
		  return counter ; 
	   }
	
}