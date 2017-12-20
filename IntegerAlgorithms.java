class IntegerAlgorithms{
	/**
		bubble sort implementation for an array of integers
		@param integerArray the array of integers to be sorted
		@return an array of sorted integers
	*/
	public static int[] intBubbleSort(int[] integerArray){
		int starting_point = 1;
		if(integerArray.length < 2)
			return integerArray;
		for(int i = integerArray.length; i > 0; i--){
			boolean releaseEarly = true;	// if the array is sorted, we can release early
			for(int j = 1; j < i; j++){
				if(integerArray[j-1] > integerArray[j]){
					int swap = integerArray[j-1];
					integerArray[j-1] = integerArray[j];
					integerArray[j] = swap;
					releaseEarly = false;
				}
			}
			if(releaseEarly){
				break;
			}
		}
		return integerArray;
	}
}