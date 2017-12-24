public class IntegerGraph{
	LinkedList[] graph;

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

	}


	public boolean hasCycles(){
		return true;
	}
}