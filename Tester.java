public class Tester{
	public static void main(String[] args){
		int testRuns = 99;
		int count = 0;
		for(int i = 0; i < testRuns; i++){
			// int[] testArray = randomIntegerArray(999999);
			// System.out.println(isSorted(testArray));
			// System.out.println(intArrayToString(testArray));


			// long startTime = System.currentTimeMillis();

			// BEGIN TEST BED
			
			// int[] resultArray = IntegerAlgorithms.intSelectionSort(testArray);
			// int[] resultArray = dHeap.heap_sort(testArray);
			// for(int j = 0; j < testArray.length; j++) testArray[i]++;
			IntegerGraph testGraph = randomIntegerGraph(6, 12);
			// System.out.println(intArrayToString(testGraph.bellman_ford(0)));
			if(testGraph.hasNegativeCycles()){
				count++;
				System.out.println("NEGATIVE CYCLES");
			}


			// END TEST BED

			// long endTime = System.currentTimeMillis();
			// System.out.println(intArrayToString(resultArray));
			// System.out.println(isSorted(resultArray));
			System.out.println(testGraph);


			// if(isSorted(resultArray)){
			// if(true){
			// 	System.out.println("Time: " + (endTime-startTime)/1000.0 + " seconds");
			// }
			// else
			// 	System.out.println("FALSE: UNSORTED");
			
			// System.out.println();
		}

		System.out.println(count);
	}


	/**
	 *	populates and returns an integer array of specified length with numbers between [-100,100]
	 *	@param length the specified length of the array
	 *	@return an integer array of specified length populated with numbers between [-100,100]
	 */
	static int[] randomIntegerArray(int length){
		int[] ret = new int[length];
		for(int i = 0; i < length; i++){
			ret[i] = (int)(Math.random()*201.0) - 100;
		}
		return ret;
	}

	/**
	 *	Creates and populates an IntegerGraph populated with a specified number of verticies and edges.
	 *	@param verticies the number of verticies that will exist within the graph
	 *	@param numEdges the number of edges to exist within the graph. The function will not work properly if the number is greater than verticies^verticies
	 *	@return a new IntegerGraph object populated with a specified number of verticies and a specified number of random edges
	 */
	static IntegerGraph randomIntegerGraph(int verticies, int numEdges){
		IntegerGraph ret = new IntegerGraph(verticies);
		for(int i = 0; i < numEdges; i++){
			int start = (int)(Math.random() * verticies);
			int end = (int)(Math.random() * verticies);
			int distance = (int)(Math.random()*21-5);
			// int cost = 0;
			ret.addEdge(start, end, distance);
		}
		return ret;
	}


	/**
	 *	takes in an array of integers and returns a string representation of the array
	 *	@param array an array of integers
	 *	@return the string representation of the given array of integers
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
	 *	checks and returns if an array is sorted
	 *	@param array the array to check if sorted or not
	 *	@return @true if sorted, @false if not sorted
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