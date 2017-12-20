/**
	d-Heap datastructure where d is the number of children (i.e 2-Binary, 3-ternary, etc...)
*/
public class dHeap{
	int d;
	int size;
	int[] heap;

	/**
		constructor method to create a heap object
		@param d the max number of children a node will have
	*/
	public dHeap(int d){
		this.d = d;
		this.size = 0;
		heap = new int[d+1];
	}

	
	/**
		turns a given integer array into a dHeap object
		@param intArray the array to heapify
		@param d the max number of children per root
		@return a dHeap object
	*/
	public dHeap(int[] intArray, int d){
		size = intArray.length;
		heap = intArray;
		this.d = d;
		int begin = (int)(Math.floor(size/((double)(d)))-1);
		for(int i = begin; i >= 0; i--){
			sift_down(i);
		}
	}

	/**
		returns a string representation of the array representation of the heap
		@return a string representation of the array representation of the heap
	*/
	public String toString(){
		String ret = "[";
		for(int i = 0; i < size; i++){
			ret = ret + heap[i];
			if(i != size-1)
				ret = ret + ", ";
		}
		ret = ret + "]";
		return ret;
	}

	/**
		a helper method used to propogate a minimum value downwards through a heap until the heap is a valid maxheap again
		@param subRoot the index of the root of the subheap
	*/
	private void sift_down(int subRoot){
		int maxIndex = subRoot;

		for(int i = 1; i <= d && subRoot+i < size; i++){
			if(heap[maxIndex] < heap[subRoot+i])
				maxIndex = subRoot+i;
		}

		if(maxIndex == subRoot) return;

		int shift = heap[maxIndex];
		heap[maxIndex] = heap[subRoot];
		heap[subRoot] = shift;

		sift_down(maxIndex);
	}

	/**
		checks if a given array is a valid max d-ary heap
		@param intArray the array to check
		@param d the number of children each root has
		@return true if the array is a valid heap
	*/
	public boolean validHeap(int[] intArray, int d){
		return validHeap_subheap(intArray, d, 0);
	}

	/**
		private helper method that helps check if a given array is a valid max d-ary heap
		@param intArray the array to check
		@param d the number of children each root has
		@param root the index of the root of the sub-heap
		@return true if the array is a valid heap
	*/
	private static boolean validHeap_subheap(int[] intArray, int d, int root){
		boolean ret = true;
		for(int i = 1; i < d; i++){
			if(root+i >= intArray.length) return true;
			if(intArray[root] < intArray[root+i]) return false;
			ret = ret && validHeap_subheap(intArray, d, (root*d)+i);
		}
		return ret;
	}
}