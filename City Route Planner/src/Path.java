
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exceptional Vending Machine
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
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Path {
  private ArrayList<Intersection> intersections;

  /**
   * Initializes this Path to start as empty
   */
  public Path() {
    intersections = new ArrayList<Intersection>();
  }

  /**
   * gets the number of intersections in this Path
   * 
   * @return returns the length of the ArrayList intersections
   */
  public int length() {
    return intersections.size();
  }

  /**
   * gets the first intersection in the ArrayList intersections
   * 
   * @return returns the first intersection in the ArrayList intersections
   * @throws throws NoSuchElementException if intersections is empty
   */
  public Intersection getHead() throws NoSuchElementException {
    if (length() > 0) {
      return intersections.get(0);
    }
    throw new NoSuchElementException("Error: Path is empty");
  }

  /**
   * gets the last intersection in the ArrayList intersections
   * 
   * @return returns the last intersection in the ArrayList intersections
   * @throws throws NoSuchElementException if intersections is empty
   */
  public Intersection getTail() throws NoSuchElementException {
    if (length() > 0) {
      return intersections.get(length() - 1);
    }
    throw new NoSuchElementException("Error: Path is empty");
  }

  /**
   * Adds the given Intersection to the end of this Path if it is a valid addition
   * 
   * @param toAdd the interseciton that needs to be added to intersections
   * @throw throw an IllegalArgumentException if the intersection that is being
   *        added is invalid
   */
  public void addTail(Intersection toAdd) throws IllegalArgumentException {
    if (length() == 0) {
      intersections.add(toAdd);
    } else if (getTail().goEast().equals(toAdd) || getTail().goNorth().equals(toAdd)) {
      intersections.add(toAdd);
    } else {
      throw new IllegalArgumentException("Error: The Intersection you are trying to add is invalid");
    }
  }

  /**
   * Adds the given Intersection to the front of this Path if it is a valid
   * addition
   * 
   * @param toAdd the interseciton that needs to be added to intersections
   * @throw throw an IllegalArgumentException if the intersection that is being
   *        added is invalid
   */
  public void addHead(Intersection toAdd) throws IllegalArgumentException {
    if (length() == 0) {
      intersections.add(0, toAdd);
    } else if (intersections.get(0).goWest().equals(toAdd) || intersections.get(0).goSouth().equals(toAdd)) {
      intersections.add(0, toAdd);
    } else {
      throw new IllegalArgumentException("Error: The Intersection you are trying to add is invalid");
    }
  }

  /**
   * returns a string that is formatted using the coordinates followed by this
   * Path
   * 
   * @override overrides the toString() method in the Object class
   */
  public String toString() {
    if (length() == 0) {
      return "Empty";
    }

    String result = "";
    result += intersections.get(0);

    for (int i = 1; i < length(); i++) {
      result += "->" + intersections.get(i);
    }
    return result;

  }
}
