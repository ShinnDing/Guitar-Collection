
public class GuitarNode {

	private Guitar data;
	private GuitarNode link;

	public GuitarNode(Guitar guitar, GuitarNode link) {
		data = guitar;
		this.link = link;
	}

	// Getters and Setters
	public Guitar getData() {
		return data;
	}

	public void setData(Guitar element) {
		data = element;
	}

	public GuitarNode getLink() {
		return link;
	}

	public void setLink(GuitarNode link) {
		this.link = link;
	}

	/**
	 * addNodeAfter(Guitar element) is an adaption of the addNodeAfter(int item)
	 *     method borrowed from IntNode.java at
	 *     https://www.cs.colorado.edu/~main/edu/colorado/nodes/IntNode.java
	 * 
	 * This method adds a new guitar after the current node designated as "cursor"
	 *     in GuitarLinkedBag.java.
	 * 
	 * @param element is a brand of guitar to add to new GuitarNode.
	 * @param link is a new Guitar Node of Guitar element and link.
	 */
	public void addNodeAfter(Guitar element) {
		link = new GuitarNode(element, link);
	}

	/**
	 * removeNodeAfter() method is borrowed from IntNode.java at
	 *     https://www.cs.colorado.edu/~main/edu/colorado/nodes/IntNode.java
	 * 
	 * This method removes a new guitar after the current node designated as
	 *     "cursor" in GuitarLinkedBag.java.
	 */
	public void removeNodeAfter() {

		if (link != null) {
			link = link.link;
		}
	}

	/**
	 * listPosition(GuitarNode head, int position) is an adaption of the
	 *     listPosition(IntNode head, int position) method borrowed from IntNode.java at
	 *     https://www.cs.colorado.edu/~main/edu/colorado/nodes/IntNode.java
	 * 
	 * @param head is the first node in the list.
	 * @param position is the "index" we want cursor to stop at.
	 * @param cursor represents the head node of the linked list. It is used
	 *          to iterate through the nodes, starting at head to "position".
	 * @return cursor provides the node at "index" position.
	 */
	public static GuitarNode listPosition(GuitarNode head, int position) {
		GuitarNode cursor;

		if (position <= 0) {
			throw new IllegalArgumentException("position is not positive");
		} else {
			cursor = head;
			for (int i = 1; (i < position) && (cursor != null); i++) {
				cursor = cursor.getLink();
			}
		}
		return cursor;
	}

	/**
	 * listLength(GuitarNode head) is an adaption of the
	 *     listLength(IntNode head) method borrowed from IntNode.java at
	 *     https://www.cs.colorado.edu/~main/edu/colorado/nodes/IntNode.java
	 * 
	 * @param head is the first node in the list. 
	 * @param cursor represents the head node of the linked list. It is used
	 *        to iterate through the nodes, starting at head to length of list.
	 * @param counter stores the number of times cursor is moved
	 *        through the list.
	 * @return return counter provides the number of nodes in the list.
	 */
	public static int listLength(GuitarNode head) {
		GuitarNode cursor;
		int counter = 0;

		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			counter++;
		}

		return counter;
	}

	/**
	 * listSearch(GuitarNode head, Guitar target) is an adaption of the
	 *     listSearch(IntNode head, int target) method borrowed from IntNode.java at
	 *     https://www.cs.colorado.edu/~main/edu/colorado/nodes/IntNode.java
	 *  
	 * @param head is the first node in the list. 
	 * @param target is the guitar to search.
	 * @param cursor represents the head node of the linked list.  It 
	 *        is used to iterate through the nodes, starting at head position
	 *        to length of list. 
	 * @return cursor if guitar is found, or null if not found.
	 */
	public static GuitarNode listSearch(GuitarNode head, Guitar target) {
		GuitarNode cursor;

		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			if (target.equals(cursor.data)) {
				return cursor;
			}
		}
		return null;
	}

	/**
	 * This method displays a Guitar on a single line.
	 */
	public void display() {

		System.out.println(this.data);
	}
}
