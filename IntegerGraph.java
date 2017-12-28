public class IntegerGraph{
	private LinkedList[] graph;

	/**
	 *	creates an empty graph with a specified number of nodes
	 *	@param numNodes the number of nodes this graph will have
	 */
	public IntegerGraph(int numNodes){
		graph = new LinkedList[numNodes];

		for(int i = 0; i < graph.length; i++){
			graph[i] = new LinkedList();
		}
	}

	/**
	 *	attempts to add an edge into the graph if the edge where an edge does not exist already.
	 *	If the edge exists, the function will return false.
	 *	@param nodeA the nodeID for the beginning node of the edge
	 *	@param nodeB the nodeID for the ending node of the edge
	 *	@param distance the distance to get from nodeA to nodeB
	 *	@param cost the cost to get from nodeA to nodeB
	 *	@return true if the edge was successfuly added or false if an edge already exists
	 */
	public boolean addEdge(int nodeA, int nodeB, int distance, int cost){
		return graph[nodeA].addNode(nodeB, distance, cost);
	}

	/**
	 *  Returns the number of vertexes in the graph
	 *  @return the number of vertexes in the graph
	 */
	public int getNumVertexes(){
		return graph.length;
	}

	/**
	 *	returns the number of one-way edges in the graph
	 *	@return the number of one-way edges in the graph
	 */
	public int getNumEdges(){
		int count = 0;
		for(int i = 0; i < graph.length; i++){
			count += graph[i].length();
		}
		return count;
	}

	/**
	 *	Uses the ____ algorithm to determine if the graph has infinite negative cycles
	 *	@return true if a negative cycle exists and false if a negative cycle does not exisit
	 */
	public boolean hasCycles(){
		return true;
	}

	/**
	 *	Runs a Bellman-Ford algorithm on the graph starting from a given node, and returns
	 *	an array of integers containing the cost to get from the start to the corresponding node
	 *	@param startNode the integer ID for the node to start on
	 *	@return an integer array containing the minimum cost it would take to get to each node from a specific start
	 */
	public int[] bellman_ford(int startNode){
		int len = graph.length;
		int[] ret = new int[len];

		// initializes the returning array with "infinity" for all nodes but the starting nodeaa
		for(int i = 0; i < ret.len; i++)
			ret[i] = Integer.MAX_VALUE;
		ret[startNode] = 0;

		// the meat of the Bellman-Ford Algorithm

		LinkedList[] tempList = graph[j].getChildren();
		for(int i = 0; i < len-1; i++){
			//iterates through each starting node in the graph
			for(int j = 0; j < graph.length; j++){
				ListNode temp = graph[j].getFirstNode();
				while(temp != null){
					if()
				}
			}
		}
	}
}