//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Chugimon.java
// Course:   CS 300 Fall 2022
//
// Author:   Aarav Gupta
// Email:    agupta297@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Reed Lokken
// Partner Email: rlokken@wisc.edu
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
// Online Sources: Github Copilot 
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;
/**
 * This class represents a Chugimon, which is a Pokemon-like creature that
 * appears in the Chugimon video game series. Each Chugimon has a name, two
 * IDs, a primary type, a secondary type, a height, and a weight.
 *
 */
public class Chugimon extends Object implements Comparable<Chugimon>{
  public static final int MIN_ID = 1;
  public static final int MAX_ID = 151;
  private final String NAME;
  private final int FIRST_ID;
  private final int SECOND_ID;
  private final ChugiType PRIMARY_TYPE;
  private final ChugiType SECONDARY_TYPE;
  private final double HEIGHT;
  private final double WEIGHT;
  /**
   * Creates a new Chugimon with the given IDs
   * @param firstID the first ID of this Chugimon
   * @param secondID the second ID of this Chugimon
   * @throws IllegalArgumentException if either ID is not between 1 and 151, inclusive
   */
	public Chugimon(int firstID, int secondID) throws IllegalArgumentException {
		if(firstID<1||firstID>151||secondID<1||secondID>151) {
      throw new IllegalArgumentException("Invalid ID");
    }

    FIRST_ID = firstID;
    SECOND_ID = secondID;
    NAME=ChugidexUtility.getChugimonName(firstID, secondID);
    PRIMARY_TYPE=ChugidexUtility.getChugimonTypes(firstID, secondID)[0];
    SECONDARY_TYPE=ChugidexUtility.getChugimonTypes(firstID, secondID)[1];
    HEIGHT=ChugidexUtility.getChugimonHeight(firstID, secondID);
    WEIGHT=ChugidexUtility.getChugimonWeight(firstID, secondID);

	}
  /**
   * Gets the name of this Chugimon
   * @return the name of this Chugimon
   */
	public String getName() {
		return NAME;
	}
  /**
   * Gets the first ID of this Chugimon
   * @return the first ID of this Chugimon
   */
	public int getFirstID() {
		return FIRST_ID;
	}
  /**
   * Gets the second ID of this Chugimon
   * @return the second ID of this Chugimon
   */
	public int getSecondID() {
		return SECOND_ID;
	}
  /**
   * Gets the primary type of this Chugimon
   * @return the primary type of this Chugimon
   */
	public ChugiType getPrimaryType() {
		return PRIMARY_TYPE;
	}
  /**
   * Gets the secondary type of this Chugimon
   * @return the secondary type of this Chugimon
   */
	public ChugiType getSecondaryType() {
		return SECONDARY_TYPE;
	}
  /**
   * Gets the height of this Chugimon
   * @return the height of this Chugimon
   */
	public double getHeight() {
		return HEIGHT;
	}
  /**
   * Gets the weight of this Chugimon
   * @return the weight of this Chugimon
   */
	public double getWeight() {
		return WEIGHT;
	}
  /** 
   * Determines the ordering of Chugimon. Chugimon are ordered by: 1) name (alphabetical) 2) the first ID (if name is equal). The one with the smaller first ID is less than the other. 3) the second ID (if name and first ID are equal). The one with the smaller second ID is less than the other. A Chugimon with identical #1-3 are considered equal.
   * @param otherChugi the other Chugimon to compare this Chugimon to
   * @return a negative int if this Chuigmon is less than other, a positive int if this Chugi is greater than other, and 0 if they are equal.
   */
  @Override
	public int compareTo(Chugimon otherChugi) {
    if(NAME.equals(otherChugi.getName())){
      if(FIRST_ID==otherChugi.getFirstID()){
        if(SECOND_ID==otherChugi.getSecondID()){
          return 0;
        }
        else if(SECOND_ID<otherChugi.getSecondID()){
          return -1;
        }
        else{
          return 1;
        }
      }
      else if(FIRST_ID<otherChugi.getFirstID()){
        return -1;
      }
      else{
        return 1;
      }
    }
    else if(NAME.compareTo(otherChugi.getName())<0){
      return -1;
    }
    else{
      return 1;
    }
	}
  /**
   * A Chugimon's String representation is its name followed by "#FIRST_ID.SECOND_ID" -- Example: "Zapchu#145.25"
   * @return a string representation of this Chugimon
   */
  @Override
	public String toString() {
		return NAME+"#"+FIRST_ID+"."+SECOND_ID;
	}
  /**
   * Equals method for Chugimon. This Chugimon equals another object if other is a Chugimon with the exact same name, and their both first and second IDs match.
   * @param other Object to determine equality against this Chugimon
   * @return true if this Chugimon and other Object are equal, false otherwise
   */
  @Override
	public boolean equals(Object other) {
		if (other instanceof Chugimon) {
			Chugimon otherItem = (Chugimon) other;
			if (otherItem.getName().equals(this.NAME)&&otherItem.getFirstID()==this.FIRST_ID&&otherItem.getSecondID()==this.SECOND_ID) {
				return true;
			}
		}
		return false;
	}
}
