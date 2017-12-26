public class LinkedList{
	private ListNode firstNode;
	private int length;

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
	public boolean addNode(ListNode node){
		if(firstNode == null) {
			firstNode = node;
			length++;
			return true;
		}
		else{
			ListNode temp = firstNode;
			while(temp.getNextNode() != null){
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
	public boolean addNode(int id, int distance, int cost){
		return addNode(new ListNode(id, distance, cost));
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
			length--;
			return ret;
		}

		ListNode temp = firstNode;
		while(temp.getNextNode() != null){
			if(temp.getNextNode().equals(node)){
				ListNode ret = temp.getNextNode();
				temp.setNext(ret.getNextNode());
				length--;
				return ret;
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
		ListNode temp = firstNode;
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
	 *	returns the length of the list
	 *	@return the length of the list
	 */
	public int length(){
		int length = 0;
		ListNode temp = firstNode;
		while(temp!=null){
			length++;
			temp = temp.getNextNode();
		}

		return length;
	}

	/**
	 *	gets a specified node contained within this list, or null otherwise
	 *	@return the specified node contained within this list, or null if it doesn't exist
	 */
	public ListNode getNode(ListNode node){
		if(firstNode == null) return null;
		ListNode temp = firstNode;
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
		String ret = "{ ";
		ListNode temp = firstNode;
		while(temp.getNextNode() != null){
			ret += temp.toString() + " | ";
		}
		ret += temp.toString() + " }";

		return ret;
	}
}