/**
 * @author Stephanie Shinn
 */
public class GuitarLinkedBagDriver {
	public static void main(String[] args) {

		//instantiates new Guitars for testing methods
		Guitar gibson = new Guitar("Gibson", 9, 2008);
		Guitar hoffman = new Guitar("Hoffman", 5, 2006);
		Guitar cordoba = new Guitar("Cordoba", 5, 2020);
		Guitar martin = new Guitar("Martin", 6, 2012);
		Guitar taylor = new Guitar("Taylor", 5, 2019);
		Guitar ovation = new Guitar("Ovation", 6, 1993);

		// #1 A constructor to create an empty linked list.
		GuitarLinkedBag g = new GuitarLinkedBag();

		// #4 void add(Thing element)
		g.add(gibson);
		g.add(hoffman);
		g.add(cordoba);
		
		// #5 void add(int index, Thing element)
		g.add(4, martin);
		g.add(5, ovation);
		g.add(6, taylor);

		// #2 int size()
		System.out.println("\nThe list size is " + g.size() + ".");

		// #3 void display()
		g.display();

		// #6 boolean remove(Thing target)
		System.out.println("\nCordoba removed: " + g.remove(cordoba));
		
		// #7 boolean remove(int index)
		System.out.println("Martin removed: " + g.remove(3));
		
		// displays updated linked list after #6 & #7 are implemented
		System.out.println("\nThe new list size is " + g.size() + ".");
		g.display();

		// #8 int countRange(Thing start, Thing end)
		System.out.println("\nThe range from Gibson to Ovation is: " + g.countRange(gibson, ovation));

		// #9 Thing grab(int index)
		System.out.println("\nGuitar at position 4:\n\n" + g.grab(4));

		// #10 int indexOf(Thing target)
		System.out.println("\nGibson is in position: " + g.indexOf(gibson));

		// #11 void set(int index, Thing element)
		g.set(3, martin);

		// displays updated linked list after #11 is implemented
		System.out.println("\nSet index 3 to Martin:");
		g.display();

		// #12 boolean replace(Thing oldThing, Thing newThing)
		System.out.println("\nCordoba replaces Gibson: " + g.replace(gibson, cordoba));
		System.out.println("Gibson replaces Ovation: " + g.replace(ovation, gibson));

		// displays updated linked list after #12 is implemented
		g.display();

		// #13 int totalValue()
		System.out.println("\nTotal weight of collection: " + g.totalValue() + " pounds.");

		//#14 ThingNode lessThan(Thing element)
		GuitarNode tempOne = g.lessThan(martin);
		
		// displays new linked list after #14 is implemented
		System.out.println("\nList less than or equal to Martin:\n");
		while (tempOne != null) {
			tempOne.display();
			tempOne = tempOne.getLink();
		}

		// #15 ThingNode greaterThan(Thing element)
		GuitarNode tempTwo = g.greaterThan(martin);
		
		// displays new linked list after #15 is implemented
		System.out.println("\nList greater than Martin:\n");
		while (tempTwo != null) {
			tempTwo.display();
			tempTwo = tempTwo.getLink();
		}

		// #16 Thing getMax()
		System.out.println("\nThe maximum guitar is: " + g.getMax());
		
		// #17 Thing getMin()
		System.out.println("The minimum guitar is: " + g.getMin());
		
		// Extra Credit void addLast()
		g.addLast(gibson);
		
		// displays updated linked list after addLast() is implemented
		System.out.println("\nAdd Gibson to end of list:");
		g.display();
		
		// Extra Credit void removeLast()
		g.removeLast();
		
		// displays updated linked list after removeLast() is implemented
		System.out.println("\nRemove Gibson from end of list:");
		g.display();
	}
}
