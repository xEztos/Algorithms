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
		String ret = "";
		ret = "NodeID: " + this.id;
		ret = ret + ",  Distance: " + this.distance;
		ret = ret + ",  Cost: " + this.cost;
		// String ret = ret + ",  " + this.nextNode;

		return ret;
	}

	/**
	 *	Returns a copy of this ListNode and a copy of the proceeding nodes
	 *	@return a copy of this ListNode and a copy of the proceeding nodes
	 */
	public ListNode clone(){
		if(nextNode == null) return new ListNode(id, distance, cost, null);
		return new ListNode(id, distance, cost, nextNode.clone());
	}
}