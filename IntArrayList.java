public class IntArrayList{
	private int[] array;
	private int length;

	/**
	 *	Constructs an empty arrayList
	 */
	public IntArrayList(){
		this(10);
	}

	/**
	 *	Constructs an empty arrayList of length 0, with a given starting length of the underlying array
	 *	@param length the size to create the underlying array
	 */
	public IntArrayList(int length){
		array = new int[length];
		this.length = 0;
	}

	/**
	 *	Constructor that takes an already existing array and turns it into an integer array list
	 *	@param array an existing array to turn into an arrayList
	 */
	public IntArrayList(int[] array){
		this.array = array;
		length = array.length;
	}

	/**
	 *	Returns the current used length of the arrayList
	 *	@return the current used length of the arrayList
	 */
	public int length(){
		return length;
	}

	/**
	 *	Returns the value at a given index
	 *	@param i the index to pull a value from
	 *	@return the integer value at the given index 'i'
	 */
	public int get(int i){
		return array[i];
	}

	/**
	 *	Adds a given integer value to the end of the arrayList, resizing the arrayList where needed
	 *	@param toAdd the given integer value to add to the end of the arrayList
	 */
	public void add(int toAdd){
		if(array.length <= length) reSize();

		array[length++] = toAdd;
	}

	/**
	 *	Removes the value from a specific index of the array
	 *	@param index the index to remove the value from
	 *	@return the value that the index contained and was removed
	 */
	public int removeIndex(int index){
		int ret = array[index];
		for(int i = index; i < length-1; i++){
			array[i] = array[i+1];
		}
		length--;

		if(length*4 > array.length){
			reSize(length * 2);
		}
		return ret;
	}

	/**
	 *	Looks for the first instance of a given number and removes that specific instance
	 *	@param number the given number to remove from the arrayList
	 *	@return True if the number existed in the array and is removed, or false otherwise
	 */
	public boolean remove(int number){
		int counter;
		for(counter = 0; counter < length && array[counter] != number; counter++);
		if(array[counter] == number){
			removeIndex(counter);
			return true;
		}
		return false;
	}

	/** 
	 *	Resizes the underlying array to a specified length if the specified length is greater than the used length
	 *	@param the specified length to resize the underlying array to
	 */
	private void reSize(int newSize){
		if(length > newSize) return;

		int[] temp = new int[newSize];
		for(int i = 0; i < length; i++){
			temp[i] = array[i];
		}

		array = temp;
	}

	/**
	 *	Resizes the underlying array to the default of 2x the current length
	 */
	private void reSize(){
		reSize(array.length * 2);
	}

	/**
	 *	Converts and returns the arrayList into a string
	 *	@return a string version of the arrayList
	 */
	public String toString(){
		String ret = "{";
		for(int i = 0; i < length-1; i++){
			ret = String.format("%s%3d,",ret, array[i]);
		}
		ret = String.format("%s%3d}",ret,array[length-1]);
		return ret;
	}

	/**
	 *	Compares this arrayList to a given array list and determines if they are equal
	 *	@param toComp the arrayList to compare this arrayList to
	 *	@return true if the arrayLists are equal or false if they are not
	 */
	public boolean equals(IntArrayList toComp){
		if(length != toComp.length()) return false;
		for(int i = 0; i < length; i++){
			if(array[i] != toComp.get(i)){
				return false;
			}
		}
		return true;
	}

	/**
	 *	Converts the integer array list into a regular integer array and returns the array
	 *	@return the integer array form of the array list
	 */
	public int[] toArray(){
		int[] temp = new int[length];
		for(int i = 0; i < temp.length; i++){
			temp[i] = array[i];
		}

		return temp;
	}
}