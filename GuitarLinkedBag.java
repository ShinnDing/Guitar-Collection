import java.util.Iterator;

/**
* @author Stephanie Shinn
* 
* INVARIANT for the GuitarLinkedBag:
*
*     1. The elements in GuitarLinkedBag are stored in a linked list.
*     2. The head reference of the linked list is in the instance variable head.
*     3. The total number of elements in the linked list is in the instance
*        variable manyItems.
*         
* This class instantiates the Guitar linked list of size manyItems. Guitar
* objects are then inserted into the linked list in alphabetical order.
* 
* This class also:
* 
*     - determines the size of the Guitar collection in the linked list
*     - displays collection of Guitars formatted into columns for brand,
*       weight, and year
*     - adds a Guitar to the linked list in alphabetical order
*     - adds a Guitar to a specific position in the linked list
*     - removes a Guitar from the linked list
*     - counts the range from one specified Guitar to another specified
*       Guitar (inclusive)
*     - grabs a Guitar from the linked list utilizing a specified position
*     - finds the position of a Guitar in the linked list
*     - replaces a Guitar at a specified position with a specified Guitar
*     - replaces a Guitar with a specified Guitar
*     - adds value of all Guitar weights in linked list
*     - provides a new linked list all Guitars equal to and less than the 
*       specified Guitar based on brand name
*     - provides a new linked list of all Guitars greater than specified
*       Guitar based on brand name
*     - provides the maximum Guitar in the linked list based on brand name
*     - provides the minimum Guitar in the linked list based on brand name
*     - adds a Guitar to the end of the linked list
*     - removes the last Guitar in the linked list
*/
public class GuitarLinkedBag {

	GuitarNode head;
	int manyItems;

	public GuitarLinkedBag() {

		head = null;
		manyItems = 0;
	}

	// #2
	/**
	 * size() is an adaption of the size() method borrowed from IntLinkedBag.java at
	 * https://www.cs.colorado.edu/~main/edu/colorado/collections/IntLinkedBag.java
	 * 
	 * This method determines the size of the Guitar collection linked list.
	 * 
	 * @return manyItems is equivalent to the size of the Guitar collection in
	 *         the linked list.
	 */
	public int size() {

		return manyItems;
	}

	// #3
	/**
	 * display() displays collection of Guitars formatted into columns of brand,
	 * weight, and year
	 * 
	 * @param cursor represents the head node of the linked list. It is used to
	 *               iterate through the linked list to display each Guitar.
	 */
	public void display() {

		GuitarNode cursor = head;

		System.out.println("\n\tBrand\t\tWeight\t\tYear\n\t------------------------------------");
		while (cursor != null) {
			System.out.println(cursor.getData());
			cursor = cursor.getLink();
		}
	}

	// #4
	/**
	 * add(Guitar element) is an adaption of the add(int element) method borrowed
	 * from IntLinkedBag.java at
	 * https://www.cs.colorado.edu/~main/edu/colorado/collections/IntLinkedBag.java
	 * 
	 * This method adds a Guitar to the linked list in alphabetical order. It
	 * adds one to the number stored in manyItems for each Guitar added to the
	 * linked list.
	 * 
	 * @param element represents the Guitar to add to the linked list. The Guitar
	 *                is compared to each Guitar already in the linked list to
	 *                locate the correct position for ascending alphabetical
	 *                order. It is then added to the linked list in the position
	 *                after the preceding Guitar.
	 * 
	 * @param head    is a new Guitar Node that places the Guitar at position
	 *                head.
	 * 
	 * @param cursor  represents the head node of the linked list. It is used to
	 *                iterate through the linked list to find each Guitar to be
	 *                compared.
	 * 
	 */
	public void add(Guitar element) {

		GuitarNode cursor = head;

		if (cursor == null) {
			head = new GuitarNode(element, null);
		} else if (cursor.getData().compareTo(element) > 0) {
			head = new GuitarNode(element, head);
		} else {
			while (cursor.getLink() != null && cursor.getLink().getData().compareTo(element) < 0) {
				cursor = cursor.getLink();
			}
			cursor.addNodeAfter(element);
		}
		manyItems++;
	}

	// #5
	/**
	 * add(int index, Guitar element) is an adaption of the add(int element) method
	 * borrowed from IntLinkedBag.java at
	 * https://www.cs.colorado.edu/~main/edu/colorado/collections/IntLinkedBag.java
	 *
	 * This method adds a Guitar to the linked list in specified position. It adds
	 * one to the number stored in manyItems for each Guitar added to the linked
	 * list.
	 *
	 * @param index   is a designated position in the linked list where the
	 *                specified Guitar element will be inserted.
	 * @param element represents the Guitar to add to the linked list at the
	 *                location designated by "index".
	 * @param cursor  represents the head node of the linked list. It is used to
	 *                iterate through the linked list to find the "index"
	 *                position.
	 */
	public void add(int index, Guitar element) {

		GuitarNode cursor = head;

		if (cursor == null) {
			head = new GuitarNode(element, null);
		} else {
			for (int i = 1; cursor.getLink() != null && index > i; i++) {
				cursor = cursor.getLink();
			}
			cursor.addNodeAfter(element);
			manyItems++;
		}
	}

	// #6
	/**
	 * remove(Guitar element) is an adaption of the remove(int target) method
	 * borrowed from IntLinkedBag.java at
	 * https://www.cs.colorado.edu/~main/edu/colorado/collections/IntLinkedBag.java
	 *
	 * This method removes a specified Guitar from the linked list. It reduces
	 * manyItems by one for each Guitar removed from the linked list.
	 *
	 * @param element    represents the Guitar to remove from the linked list.
	 * @param targetNode is a node that will represent the location of the
	 *                   specified Guitar to remove.
	 * @param cursor     represents the head node of the linked list. It is used
	 *                   to iterate through the linked list to find the Guitar to
	 *                   remove.
	 * @return true      if Guitar is removed from the linked list, or
	 * @return false     if it Guitar is not removed.
	 */
	public boolean remove(Guitar element) {

		GuitarNode targetNode; // The node that contains the target

		targetNode = GuitarNode.listSearch(head, element);
		if (targetNode == null) {
			return false;
		} else {
			targetNode.setData(head.getData());
			head = head.getLink();
			manyItems--;
			return true;
		}
	}

	// #7
	/**
	 * remove(int index) is an adaption of the remove(int target) method borrowed
	 * from IntLinkedBag.java at
	 * https://www.cs.colorado.edu/~main/edu/colorado/collections/IntLinkedBag.java
	 *
	 * This method removes a Guitar from a specified position in the linked list. It
	 * reduces manyItems by one for each Guitar removed from the linked list.
	 *
	 * @param index  is a designated position of a Guitar to be removed from the
	 *               linked list.
	 * @param cursor represents the head node of the linked list. It is used to
	 *               iterate through the linked list to find the index for the
	 *               Guitar to remove.
	 * @return true  if Guitar is removed from the linked list, or
	 * @return false if Guitar is not removed.
	 */
	public boolean remove(int index) {

		GuitarNode cursor = head;

		for (int i = 1; i < index - 1; i++) {
			if (cursor == null) {
				return false;
			}
			cursor = cursor.getLink();
		}
		if (cursor.getLink() == null) {
			return false;
		}
		cursor.removeNodeAfter();
		manyItems--;
		return true;
	}

	// #8
	/**
	 * countRange(Guitar start, Guitar end) counts the number of Guitars within
	 * the range of the designated Guitars (inclusive). Brands are compared to
	 * determine what Guitars are counted in an alphabetical range.
	 *
	 * @param start      is the first Guitar to include in the alphabetical range.
	 * @param end        is the last Guitar to include in the alphabetical range.
	 * @param countRange stores the number of Guitars within range and increases
	 *                   by one for each Guitar included in the range.
	 * @param cursor     represents the head node of the linked list. It is used
	 *                   to iterate through the linked list to find the index for
	 *                   the Guitar to remove.
	 * @return true  if Guitar is removed from the linked list, or
	 * @return false if Guitar is not removed.
	 */
	public int countRange(Guitar start, Guitar end) {

		int countRange = 0;

		GuitarNode cursor = head;
		while (cursor != null) {
			if (cursor.getData().compareTo(start) == 0) {
				countRange++;
			} else if ((cursor.getData().compareTo(end) >= 0)) {
				countRange++;
			}
			cursor = cursor.getLink();
		}
		return countRange;
	}

	// #9
	/**
	 * grab(int index) is an adaption of the grab() method borrowed from
	 * IntLinkedBag.java at
	 * https://www.cs.colorado.edu/~main/edu/colorado/collections/IntLinkedBag.java
	 *
	 * This method finds the Guitar in the linked list position specified by
	 * "index". If the linked list is empty, it throws an IllegalStateException.
	 *
	 * @param index  is a designated position of a Guitar in the linked list.
	 * @param cursor represents the head node of the linked list. It is used to
	 *               iterate through the linked list to find the Guitar in the
	 *               position specified by "index".
	 * @return cursor.getData(), which is the Guitar located at the position
	 *         specified by "index", or null if the "index" is greater than the
	 *         number of items in the linked list,
	 */
	public Guitar grab(int index) {

		GuitarNode cursor;

		if (manyItems == 0) {
			throw new IllegalStateException("Bag size is zero");
		}
		if (index > manyItems) {
			return null;
		}
		cursor = GuitarNode.listPosition(head, index);
		return cursor.getData();
	}

	// #10
	/**
	 * indexOf(Guitar target) method finds the position of a specified Guitar in
	 * the linked list.
	 *
	 * @param target is a designated Guitar to search for in the linked list.
	 * @param cursor represents the head node of the linked list. It is used to
	 *        iterate through the linked list to find the Guitar position.
	 * @param length is the linked list length.
	 * @return index represents the position of the Guitar if found in the linked
	 *         list, or -1 if the Guitar does not appear in the linked list.
	 */
	public int indexOf(Guitar target) {

		GuitarNode cursor = head;
		int index = 0;
		int length = GuitarNode.listLength(cursor);

		for (int i = 0; i <= length; i++) {
			index++;
			if (cursor.getData().equals(target)) {
				return index;
			} else if (index < length) {
				cursor = cursor.getLink();
			}
		}
		return -1;
	}

	// #11
	/**
	 * set(int index, Guitar element) replaces Guitar in a linked list position
	 * specified by "index" with Guitar element.
	 *
	 * @param index   is the designated position in the linked list where Guitar
	 *                element will replace the existing Guitar.
	 * @param element is the Guitar that will replace the Guitar at position of
	 *                "index" in the linked list.
	 * @param cursor  represents the head node of the linked list. It is used to
	 *                iterate through the linked list to find the "index"
	 *                position.
	 */
	public void set(int index, Guitar element) {

		GuitarNode cursor = head;
		int count = GuitarNode.listLength(cursor);

		for (int i = 0; i <= count; i++) {
			if (i == index - 1) {
				cursor.setData(element);
			} else if (i != count) {
				cursor = cursor.getLink();
			}
		}
	}

	// 12
	/**
	 * replace(Guitar oldThing, Guitar newThing) replaces an existing Guitar in
	 * the linked list with a new Guitar.
	 *
	 * @param oldThing is the existing Guitar in the linked list to be replaced
	 *                 with a new Guitar.
	 * @param newThing is the new Guitar that will replace the old Guitar already
	 *                 in the linked list.
	 * @param cursor   represents the head node of the linked list. It is used to
	 *                 iterate through the linked list to find the Guitar to be
	 *                 replaced in the linked list.
	 * @param length   is the linked list length.
	 * @return true   if old Guitar is found and replaced by new Guitar, or
	 * @ return false if old Guitar is not found.
	 */
	public boolean replace(Guitar oldThing, Guitar newThing) {

		GuitarNode cursor = head;
		int length = GuitarNode.listLength(cursor);

		for (int i = 1; i <= length; i++) {
			if (cursor.getData().equals(oldThing)) {
				cursor.setData(newThing);
				return true;
			}
			cursor = cursor.getLink();
		}
		return false;
	}

	// #13
	/**
	 * totalValue() adds the weight of each Guitar in the linked list.
	 *
	 * @param cursor      represents the head node of the linked list. It is used
	 *                    to iterate through the linked list to find each Guitar
	 *                    whose weight will be added to totalWeight.
	 * @param totalWeight is used to add and store the weight of all Guitars in
	 *                    the linked list.
	 * @param length      represents the linked list length.
	 * @return totalWeight represents the total weight of all Guitars in the
	 *                     linked list.
	 */
	public int totalValue() {

		GuitarNode cursor = head;
		int totalWeight = 0;
		int length = GuitarNode.listLength(cursor);

		for (int i = 1; i <= length; i++) {

			totalWeight += cursor.getData().getWeight();
			cursor = cursor.getLink();
		}
		return totalWeight;
	}

	// #14
	/**
	 * lessThan(Guitar element) method takes one Guitar as input and returns as
	 * output a linked list that includes all Guitars alphabetically less than or
	 * equal to the input Guitar element.
	 *
	 * @param element is a designated Guitar to search for in the linked list.
	 * @param cursor  represents the head node of the linked list. It is used to
	 *                iterate through the linked list to find the Guitar position.
	 * @param output  is a new Guitar Linked Bag used to copy Guitars from the
	 *                original linked list.
	 * @param index   represents the return from method indexOf(element). It is
	 *                used as a "stopping point" for iterating through the list
	 *                up to the Guitar element.
	 * @return output.head represents the new linked list consisting of all
	 *                     Guitars equal to and less than the input Guitar
	 *                     element from the original linked list.
	 */
	public GuitarNode lessThan(Guitar element) {

		GuitarNode cursor = head;
		GuitarLinkedBag output = new GuitarLinkedBag();
		int index = indexOf(element);

		for (int i = 1; i <= index; i++) {

			if (cursor.getData().compareTo(element) <= 0) {
				output.add(cursor.getData());
				cursor = cursor.getLink();
			} else {
				break;
			}
		}
		return output.head;
	}

	// #15
	/**
	 * greaterThan(Guitar element) method takes one Guitar as input and returns
	 * as output a linked list that includes all Guitars alphabetically greater
	 * than the input Guitar element.
	 *
	 * @param element is a designated Guitar to search for in the linked list.
	 * @param cursor  represents the head node of the linked list. It is used to
	 *                iterate through the linked list to find the Guitar position.
	 * @param output  is a new Guitar Linked Bag used to copy Guitars from the
	 *                original linked list.
	 * @param length  represents the linked list length.
	 * @return output.head represents the new linked list consisting of all
	 *                     Guitars greater than the input Guitar element from
	 *                     the original linked list.
	 */
	public GuitarNode greaterThan(Guitar element) {

		GuitarNode cursor = head;
		GuitarLinkedBag output = new GuitarLinkedBag();
		int length = GuitarNode.listLength(cursor);

		for (int i = 1; i <= length; i++) {

			if (cursor.getData().compareTo(element) > 0) {
				output.add(cursor.getData());
			}
			cursor = cursor.getLink();
		}
		return output.head;
	}

	// #16
	/**
	 * getMax() returns the maximum Guitar in the linked list based on
	 * alphabetical order by brand.
	 *
	 * @param cursor represents the head node of the linked list.  It is used to
	 *               iterate through the list to compare each Guitar when
	 *               searching for the the maximum Guitar.
	 * @param length represents the linked list length.
	 * @return cursor.getData() returns the maximum Guitar in the linked list
	 *                          based on alphabetical order by brand.
	 */
	public Guitar getMax() {

		GuitarNode cursor = head;
		int length = GuitarNode.listLength(cursor);

		for (int i = 1; i < length; i++) {

			if (cursor.getData().compareTo(cursor.getLink().getData()) < 0) {
				cursor = cursor.getLink();
			}
		}
		return cursor.getData();
	}

	// #17
	/**
	 * getMin() returns the minimum Guitar in the linked list based on alphabetical
	 * order of brand.
	 *
	 * @param cursor    represents the head node of the linked list. It is used
	 *                  to iterate through the list to compare each Guitar when
	 *                  searching for the the minimum Guitar.
	 * @param length    represents the linked list length.
	 * @param minGuitar is the minimum Guitar in the list.
	 * @return minGuitar returns the minimum Guitar in the linked list based on
	 *                   alphabetical order of brand.
	 */
	public Guitar getMin() {

		GuitarNode cursor = head;
		int length = GuitarNode.listLength(cursor);
		Guitar minGuitar = cursor.getData();

		for (int i = 1; i < length; i++) {

			if (cursor.getData().compareTo(cursor.getLink().getData()) > 0) {
				minGuitar = cursor.getData();
			}
		}
		return minGuitar;
	}

	// Extra Credit
	/**
	 * addLast(Guitar element) takes one Guitar as input and adds it to the end of
	 * the linked list.
	 *
	 * @param element is a designated Guitar to add to the end of the linked list.
	 * @param cursor  represents the head node of the linked list. It is used to
	 *                iterate through the linked list to find the Guitar position.
	 * @param length  represents the linked list length.
	 */
	void addLast(Guitar element) {

		GuitarNode cursor = head;
		int length = GuitarNode.listLength(cursor);

		for (int i = 1; cursor.getLink() != null && i <= length; i++) {
			cursor = cursor.getLink();
		}
		cursor.addNodeAfter(element);
		manyItems++;
	}

	// Extra Credit
	/**
	 * removeLast() removes the last Guitar from the linked list.
	 *
	 * @param cursor represents the head node of the linked list. It is used to
	 *               iterate through the linked list to find the last Guitar
	 *               position.
	 * @param length represents the linked list length.
	 */
	void removeLast() {

		GuitarNode cursor = head;
		int length = GuitarNode.listLength(cursor);

		for (int i = 1; cursor.getLink() != null && i < length - 1; i++) {
			cursor = cursor.getLink();
		}
		cursor.removeNodeAfter();
		manyItems--;
	}
}
