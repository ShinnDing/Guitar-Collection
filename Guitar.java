/**
 * @author Stephanie Shinn
 *
 * This class represents a Guitar's
 * specified brand, weight, and year.
 */

public class Guitar {

	private String brand;
	private int weight;
	private int year;
	
	public Guitar(String b, int w, int y) {
		
		setBrand(b);
		setWeight(w);
		setYear(y);
	}

	//Getters and Setters
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return formatted string of brand, weight, and year,
	 * separated by tabs to format columns.
	 */
	public String toString() {

		return ("\t" + brand + "\t\t  " + weight + "\t\t" + year);
	}
	
	/**
	 * @param Guitar other indicates the new guitar being compared to.
	 * 
	 * @return true of other Guitar object brand is equal to existing Guitar object
	 * 		   in list.
	 */
	public boolean equals(Guitar other) {
		
		if (this.brand.equalsIgnoreCase(other.brand)) {
			return true;
		}
		return false;
	}

	/**
	 * @param Guitar other indicates the new guitar being compared to.
	 * 
	 * @return -1 if other Guitar object brand alphabetically (lexicographically)
	 *             precedes the existing Guitar object in the array
	 *         0 if other Guitar object brand is the alphabetical (lexicographical)
	 *             equivalent to the existing Guitar object in the array
	 *         1 if other Guitar object brand alphabetically (lexicographically)
	 *             follows the existing Guitar object in the array
	 */
	public int compareTo(Guitar other) {

		return this.brand.compareToIgnoreCase(other.brand);
	}

}
