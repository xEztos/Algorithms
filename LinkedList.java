public class LinkedList{
	private ListNode firstNode;

	public LinkedList(ListNode firstNode){
		this.firstNode = firstNode;
	}

	public LinkedList(){
		this(null);
	}

	/**
	 *	adds a node to the end of the list
	 *	@param node the node to add to the end of the list
	 */
	public void addNode(ListNode node){
		if(firstNode == null) firstNode = node;
		else{
			temp = firstNode;
			while(temp.nextNode() != null){
				temp = temp.getNextNode();
			}
			temp.setNext(node);
		}
	}

	/**
	 *	adds a location node to the list with a given ID, distance, and cost
	 *	@param id the location id of the new node
	 *	@param distance the distance of this new node
	 *	@param cost the cost to get to this node
	 */
	public void addNode(int id, int distance, int cost){
		addNode(new ListNode(id, distance, cost));
	}

	/**
	 *	removes a specified node from the list, and returns it. If the node does not exist already,
	 *	the function will return a null object.
	 *	@param node the node to be removed
	 *	@return the node that was removed if the node exists or null if the node does not
	 */
	public ListNode remove(ListNode node){
		if(firstNode == null) return null;

		if(firstNode.equals(node)){
			ListNode ret = firstNode;
			firstNode = firstNode.getNextNode();
			return ret;
		}

		temp = firstNode;
		while(temp.getNextNode() != null){
			if(temp.getNextNode().equals(node)){
				ListNode ret = temp.getNextNode();
				temp.setNext(ret.getNextNode());
			}
		}

		return null;
	}

	/**
	 *	removes a node with a specified location ID from the list and returns it.
	 *	If the node does not exist already, the function will return a null object.
	 *	@param nodeID the node ID number to be removed
	 *	@return the node that was removed if the node exists or null if the node does not
	 */
	public ListNode remove(int nodeID){
		return remove(new ListNode(nodeID));
	}
	
	/**
	 *	returns if a given node already exists in this list
	 *	@param node the node to look for
	 *	@return true if a given node exists in this list
	 */
	public boolean exists(ListNode node){
		if(firstNode == null) return false;
		temp = firstNode;
		while(temp != null){
			if(temp.equals(node)) return true;
			temp = temp.getNextNode();
		}
		return false;
	}

	/**
	 * 	returns if a node with a given ID already exists in the list
	 *	@param nodeID the node ID to look for
	 *	@return true if a node with a given ID already exists
	 */
	public boolean exists(int nodeID){
		return exists(new ListNode(nodeID));
	}

	/**
	 *	gets a specified node contained within this list, or null otherwise
	 *	@return the specified node contained within this list, or null if it doesn't exist
	 */
	public ListNode getNode(ListNode node){
		if(firstNode == null) return null;
		temp = firstNode;
		while(temp!=null){
			if(temp.equals(node)) return temp;
			temp = temp.getNextNode();
		}
		return null;
	}

	/**
	 *	gets the specified node contianed within this list with the same location ID
	 *	or null if the node does not exist
	 *	@param nodeID the location identifier of the node to find and return
	 *	@return a specific node that matches the nodeID or null if said node does not exist
	 */
	public ListNode getNode(int nodeID){
		return getNode(new ListNode(nodeID, 0));
	}

	/**
	 *	returns a string representation of the Linked List:
	 *		"{ <node1> | <node2> | <node3> }";
	 *	@return a string representation of the linkedList
	 */
	public String toString(){
		if(firstNode == null) return "{  }";
		ret = "{ ";
		temp = firstNode;
		while(temp.getNextNode() != null){
			ret += temp.toString() + " | ";
		}
		ret += temp.toString() + " }";
	}
}


class ListNode{
	private int cost;
	private int distance;
	private int id;
	private ListNode nextNode;


	/**
	 *  ListNode constructor that takes in and assigns
	 *  the location ID and the next next node in the linked list.
	 *  @param id the location idenftifier
	 *	@param distance the distance of this location
	 *	@param cost the cost to get to this node
	 *  @param nextNode the next ListNode in the series
	 */
	public ListNode(int id, int distance, int cost, ListNode nextNode){
		this.id = id;
		this.nextNode = nextNode;
		this.distance = distance;
	}

	/**
	 *	ListNode constructor that takes in and assigns a location ID, distance, and cost
	 *	@param id the location identifier
	 *	@param distance the distance of this location
	 *	@param cost the cost to get to this node
	 */
	public ListNode(int id, int distance, int cost){
		this(id, distance, cost, null);
	}

	/**
	 *	Extended constructor that only takes in a location identifier and distance.
	 *  @param id the location identifier number
	 *	@param distance the distance of this location
	 */
	public ListNode(int id, int distance){
		this(id, distance, distance, null);
	}

	/**
	 *	creates a new ListNode with a specified identifier and a near infinite distance and cost
	 *	@param id the location ID of the node
	 */
	public ListNode(int id){
		this(id, Integer.MAX_VALUE, Integer.MAX_VALUE, null);
	}

	/**
	 *	enables the rewrite of value of cost after instantiation
	 *	@param cost the new cost it takes to get to this location
	 */
	public void setCost(int cost){
		this.cost = cost;
	}

	/**
	 *	enables the rewrite of value of distance after instantiation
	 *	@param distance the new distance this node is
	 */
	public void setDistance(int distance){
		this.distance = distance;
	}

	/**
	 *	reassociates the next node in the list to a new value
	 *	@param nextNode the next node to assign in the list
	 */
	public void setNext(ListNode nextNode){
		this.nextNode = nextNode;
	}

	/**
	 *	Returns the cost needed to get to this location
	 *	@return the cost needed to get to this location
	 */
	public int getCost(){
		return this.cost;
	}

	/**
	 *	returns the distance to this location
	 *	@return the distance to this location
	 */
	public int getDistance(){
		return this.distance;
	}

	/**
	 *	returns the location identifier number
	 *  @return the location identifier number
	 */
	public int getID(){
		return this.id;
	}

	/**
	 *	returns the next node in the list
	 *	@return the next node in the list
	 */
	public ListNode getNextNode(){
		return this.nextNode;
	}

	/**
	 * 	returns true if the given node is equal to this node
	 *	@return true if the given node is equal to this node
	 */
	public boolean equals(ListNode node){
		if(node == null) return false;		// why would you even do this to me
		if(this.id != node.getID()) return false;
		// if(this.distance != node.getDistance()) return false;
		// if(this.cost != node.getCost()) return false;
		// if(!this.nextNode.equals(node.nextNode())) return false;
		return true;
	}

	/**
	 *	returns a string representation of this node:
	 *		"Node ID: <int>, Distance: <int>, Cost: <int>"
	 *	@return a string representation of this node
	 */
	public String toString(){
		String ret = "NodeID: " + this.id;
		String ret = ret + ",  Distance: " + this.distance;
		String ret = ret + ",  Cost: " + this.cost;
		// String ret = ret + ",  " + this.nextNode;

		return ret;
	}
}