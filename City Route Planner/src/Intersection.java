//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    City Route Planner
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
/**
 * This class models an Intersection using X and Y coordinates and contains
 * methods to get and change the location of the intersection
 */
public class Intersection {

  private final int x; // the x coordinate of the intersection
  private final int y; // the y coordinate of the intersection

  /**
   * Initializes this Intersection to the given x and y coordinates
   * 
   * @param x x coordinate for the Intersection
   * @param y y coordinate for the Interseciton
   */
  public Intersection(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * gets the x coordinate for the Intersection
   * 
   * @return returns the x coordinate for the Intersection
   */
  public int getX() {
    return this.x;
  }

  /**
   * gets the y coordinate for the Intersection
   * 
   * @return returns the y coordinate for the Intersection
   */
  public int getY() {
    return this.y;
  }

  /**
   * returns a coordinate-pair representation of this Intersection in the form
   * "(x,y)"
   * 
   * @override overrides the default toString() method in the Object class
   */
  public String toString() {
    return "(" + this.x + "," + this.y + ")";
  }

  /**
   * returns true if the given Object is identical to this Intersection, and false
   * otherwise
   * 
   * @override overrides the default eqauls() method in the Object class
   */
  public boolean equals(Object o) {
    if (o instanceof Intersection) {
      Intersection otherItem = (Intersection) o;
      if (otherItem.getX() == this.x && otherItem.getY() == this.y) {
        return true;
      }
    }
    return false;
  }

  /**
   * Creates a new Intersection instance which is one step directly above this
   * Intersection
   * 
   * @return returns a new Intersection instance which is one step directly above
   *         this Intersection
   */
  public Intersection goNorth() {
    Intersection north = new Intersection(this.x, this.y + 1);
    return north;
  }

  /**
   * Creates a new Intersection instance which is one step directly below this
   * Intersection
   * 
   * @return returns a new Intersection instance which is one step directly below
   *         this Intersection
   */
  public Intersection goSouth() {
    Intersection south = new Intersection(this.x, this.y - 1);
    return south;
  }

  /**
   * Creates a new Intersection instance which is one step directly to the right
   * of this Intersection
   * 
   * @return returns a new Intersection instance which is one step directly to the
   *         right of this Intersection
   */
  public Intersection goEast() {
    Intersection east = new Intersection(this.x + 1, this.y);
    return east;
  }

  /**
   * Creates a new Intersection instance which is one step directly to the left of
   * this Intersection
   * 
   * @return returns a new Intersection instance which is one step directly to the
   *         left of this Intersection
   */
  public Intersection goWest() {
    Intersection west = new Intersection(this.x - 1, this.y);
    return west;
  }
}
