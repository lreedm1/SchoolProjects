//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exceptional Vending Machine
// Course:   CS 300 Fall 2022
//
// Author:   Reed Lokken
// Email:    rlokken@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Aarav Gupta
// Partner Email: Agupta297@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE        
// Online Sources: Github Copilot | Javadocs https://cs300-www.cs.wisc.edu/wp/wp-content/uploads/2020/12/fall2022/p4/doc/allclasses-index.html
///////////////////////////////////////////////////////////////////////////////
public class Item {
	private String description;
	private int expirationDate;

	/**
	 * Creates a new Item object with a specific expiration date and description 
	 * @param description a human readable description of this item
	 * @param expirationDate a positive iteger starting at day 0, which represents Jan 1, 2023
	 * @throws IllegalArgumentException a descriptive error message if expirationDate is negative (less than zero) or description is null or blank
	 */
	public Item(String description, int expirationDate) throws IllegalArgumentException {
		this.description = description;
		this.expirationDate = expirationDate;
		if (expirationDate < 0 || description.equals(null) || description.strip().equals("")) { //incase string is just continuous spaces
			throw new IllegalArgumentException("Error: Your description or expirationDate input is Invalid");
		}
	}
    
	/**
	 * gets the description of this item
	 * @return returns the description of this item
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * gets the expiration date of this item
	 * @return returns the expiration date of this item
	 */
	public int getExpirationDate() {
		return expirationDate;
	}
	/**
	 * Changes teh description of the item to the parameter in the method
	 * @param description the description of the item in the vending machine
	 * @throws IllegalArgumentException throws an IllegalArguementException if the message description is either null or blank
	 */
	public void setDescription(String description) throws IllegalArgumentException {
    	if(description.equals("")||description.equals(null)) {
    	    throw new IllegalArgumentException("Error: message description is either null or blank");
    	}
    	else {
    		this.description=description;
    	}
    }
	/**
	 * Returns a String representation of this item formatted as "description: expirationDate"
	 * @return returns a String representation of this item
	 */
	@Override
	public String toString() {
		return description + ": " + expirationDate;
	}
	/**
	 * Overridden method equals checks whether this item equals another object passed as input
	 * @return returns true if other is an instance of Item and has the same description as this item, and false otherwise
	 */
	@Override
	public boolean equals(Object other) {
		return (other instanceof Item && item.contentEquals(description)&&!other.toString().contentEquals(Integer.toString(expirationDate)));
	}


}
 