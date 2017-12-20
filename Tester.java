public class Tester{
	public static void main(String[] args){
		int testRuns = 20;
		for(int i = 0; i < testRuns; i++){
			int[] testArray = randomIntegerArray(14);
			System.out.println(isSorted(testArray));
			System.out.println(intArrayToString(testArray));


			long startTime = System.currentTimeMillis();

			// int[] resultArray = IntegerAlgorithms.intSelectionSort(testArray);
			dHeap resultHeap = new dHeap(testArray, 2);

			long endTime = System.currentTimeMillis();

			System.out.println(resultHeap);
			// System.out.println(intArrayToString(resultArray));
			// System.out.println(isSorted(resultArray));

			System.out.println("Time: " + (endTime - startTime) + " milliseconds");
			System.out.println("Time: " + (endTime-startTime)/1000.0 + " seconds");
			System.out.println();
		}
	}

	/**
		populates and returns an integer array of specified length with numbers between [-100,100]
		@param length the specified length of the array
		@return an integer array of specified length populated with numbers between [-100,100]
	*/
	static int[] randomIntegerArray(int length){
		int[] ret = new int[length];
		for(int i = 0; i < length; i++){
			ret[i] = (int)(Math.random()*201.0) - 100;
		}
		return ret;
	}

	/**
		takes in an array of integers and returns a string representation of the array
		@param array an array of integers
		@return the string representation of the given array of integers
	*/
	static String intArrayToString(int[] array){
		String ret = "[";
		for(int i = 0; i < array.length; i++){
			ret = ret + array[i];
			if(i != array.length-1)
				ret = ret + ", ";
		}
		ret = ret + "]";
		return ret;
	}

	/**
		checks and returns if an array is sorted
		@param array the array to check if sorted or not
		@return @true if sorted, @false if not sorted
	*/
	static boolean isSorted(int[] array){
		boolean sorted = true;
		for(int i = 1; i < array.length; i++){
			sorted = array[i-1] <= array[i];
			if(!sorted)
				return false;
		}
		return sorted;
	}
}