/**
 *	d-Heap datastructure where d is the number of children (i.e 2-Binary, 3-ternary, etc...)
 */
public class dHeap{
	private int d;
	private int size;
	private int[] heap;


	/**
	 *	constructor method to create a heap object
	 *	@param d the max number of children a node will have
	*/
	public dHeap(int d){
		this.d = d;
		this.size = 0;
		heap = new int[d+1];
	}

	
	/**
	 *	turns a given integer array into a dHeap object
	 *	@param intArray the array to heapify
	 *	@param d the max number of children per root
	 *	@return a dHeap object
	 */
	public dHeap(int[] intArray, int d){
		size = intArray.length;
		heap = intArray;
		this.d = d;
		// int begin = (int)(Math.floor(size/((double)(d)))-1);
		int begin = size/d - 1;
		// System.out.println("Begin: " + begin);
		for(int i = begin; i >= 0; i--){
			sift_down(i);
		}
	}


	/**
	 *	adds a number into the heap and propogates it upwards
	 */
	public void add(int number){
		if(size == heap.length){
			reSize(size * d);
		}
		heap[size] = number;
		sift_up(size);
		size++;
	}


	/**
	 *  removes and returns the highest value in the heap
	 *	@return the highest value in the heap
	 */
	public int remove(){
		int ret = heap[0];
		heap[0] = heap[size-1];
		size--;
		sift_down(0);
		return ret;
	}


	/**
	 * Creates a new int array and populates it with the existing heap int array
	 * or does nothing if the specified array is smaller than the current heap size
	 * @param the size of the new heap int array
	 */
	private void reSize(int size){
		if(size < this.size) return;
		int[] temp = new int[size];

		for(int i = 0; i < this.size; i++){
			temp[i] = heap[i];
		}
		this.size = size;
		heap = temp;
	}


	/**
	 *	a helper method used to propogate a maximum value upwards through the heap until the heap is valid
	 *	@param child the index of the child to propogate upwards
	 */
	private void sift_up(int child){
		if(child >= size) return;
		int parent_index = (int) (child/3 - 1);
		if(parent_index < 0) return;

		if(heap[parent_index] < heap[child])
		{
			swap(parent_index, child);
		}
	}


	/**
	 *	a helper method used to propogate a minimum value downwards through a heap until the heap is a valid maxheap again
	 *	@param subRoot the index of the root of the subheap
	 */
	private void sift_down(int subRoot){
		int maxIndex = subRoot;

		for(int i = 1; i <= d && subRoot*d+i < size; i++){
			if(heap[maxIndex] < heap[subRoot*d+i])
				maxIndex = subRoot*d+i;
		}

		if(maxIndex == subRoot) return;

		// int shift = heap[maxIndex];
		// heap[maxIndex] = heap[subRoot];
		// heap[subRoot] = shift;
		swap(maxIndex, subRoot);

		sift_down(maxIndex);
	}


	/**
	 *	swaps the values in two specifed indicies provided the indecies are valid
	 *  or does nothing if the indicies are out of the current heap range
	 *	@param index_a one of the two indicies to swap
	 *	@param index_b one of the two indicies to swap
	 */
	private void swap(int index_a, int index_b){
		if(index_a >= size || index_b >= size || index_a < 0 || index_b < 0) return;
		int temp = heap[index_a];
		heap[index_a] = heap[index_b];
		heap[index_b] = temp;
	}


	/**
	 *	returns a string representation of the array representation of the heap
	 *	@return a string representation of the array representation of the heap
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
	 *	checks if a given array is a valid max d-ary heap
	 *	@param intArray the array to check
	 *	@param d the number of children each root has
	 *	@return true if the array is a valid heap
	 */
	public static boolean validHeap(int[] intArray, int d){
		return validHeap_subheap(intArray, d, 0);
	}


	/**
	 *	private helper method that helps check if a given array is a valid max d-ary heap
	 *	@param intArray the array to check
	 *	@param d the number of children each root has
	 *	@param root the index of the root of the sub-heap
	 *	@return true if the array is a valid heap
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

	public static int[] heap_sort(int[] intArray){
		dHeap binaryHeap = new dHeap(intArray, 2);
		int[] ret = new int[intArray.length];
		for(int i = intArray.length-1; i >= 0; i--){
			ret[i] = binaryHeap.remove();
		}
		return ret;
	}
}