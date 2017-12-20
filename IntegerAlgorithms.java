class IntegerAlgorithms{
	/**
		bubble sort implementation for an array of integers
		@param integerArray the array of integers to be sorted
		@return an array of sorted integers
	*/
	public static int[] intBubbleSort(int[] integerArray){
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

	/**
		selection sort implementation for an integer array
		@param integerArray the integer array to be sorted
		@return a sorted array
	*/
	public static int[] intSelectionSort(int[] integerArray){
		if(integerArray.length < 2) return integerArray;
		for(int i = integerArray.length-1; i > 0; i--){
			int maxIndex = 0;
			for(int j = 1; j <= i; j++){
				if(integerArray[j] > integerArray[maxIndex])
					maxIndex = j;
			}
			if(maxIndex == i) continue;

			int swap = integerArray[maxIndex];
			integerArray[maxIndex] = integerArray[i];
			integerArray[i] = swap;
			// System.out.println(Tester.intArrayToString(integerArray));
		}
		return integerArray;
	}
}