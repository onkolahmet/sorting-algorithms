
public class maxHeap {
	static long counter ;
	  
	 	public int[] Heap; 
	    public int size; 
	    public int maxsize; 
	  
	    // Constructor to initialize an 
	    // empty max heap with given maximum 
	    // capacity. 
	    public maxHeap(int maxsize) 
	    { 
	        this.maxsize = maxsize; 
	        this.size = 0; 
	        Heap = new int[this.maxsize + 1]; 
	        Heap[0] = Integer.MAX_VALUE; 
            counter = 0 ;	    
	    } 
	    
	    // Returns position of parent 
	    public int parent(int pos) 
	    { 
	        return pos / 2; 
	    } 
	  
	    // Below two functions return left and 
	    // right children. 
	    public int leftChild(int pos) 
	    { 
	        return (2 * pos); 
	    } 
	    public int rightChild(int pos) 
	    { 
	        return (2 * pos) + 1; 
	    } 
	  
	    // Returns true of given node is leaf 
	    public boolean isLeaf(int pos) 
	    { 
	        if (pos >= (size / 2) && pos <= size) { 
	            return true; 
	        } 
	        return false; 
	    } 
	  
	    public void swap(int fpos, int spos) 
	    { 
	        int tmp; 
	        tmp = Heap[fpos]; 
	        Heap[fpos] = Heap[spos]; 
	        Heap[spos] = tmp; 
	    } 
	  
	    // A recursive function to max heapify the given 
	    // subtree. This function assumes that the left and 
	    // right subtrees are already heapified, we only need 
	    // to fix the root. 
	    public void maxHeapify(int pos) 
	    { 
	        if ( isLeaf(pos) && counter++ >= 0 ) 
	            return; 
	  
	        if (Heap[pos] < Heap[leftChild(pos)] ||  
	            Heap[pos] < Heap[rightChild(pos)]) { 
	  
	            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
	               
	            	swap(pos, leftChild(pos)); 
	                maxHeapify(leftChild(pos)); 
	            } 
	            else { 
	                swap(pos, rightChild(pos)); 
	                maxHeapify(rightChild(pos)); 
	            } 
	        } 
	    } 
	  
	    // Inserts a new element to max heap 
	    public void insert(int element) 
	    { 
	        Heap[++size] = element; 
	        counter++ ;
	        // Traverse up and fix violated property 
	        int current = size; 
	        while (Heap[current] > Heap[parent(current)]) {
	            swap(current, parent(current)); 
	            current = parent(current); 
	        } 
	    } 
	  
	    // Remove an element from max heap 
	    public int extractMax() 
	    { 
	        
	    	int popped = Heap[1]; 
	        Heap[1] = Heap[size--]; 
	        maxHeapify(1); 
	        return popped; 
	    } 
	    public long getCounter() {
	  	  return counter ; 
	     }
}
