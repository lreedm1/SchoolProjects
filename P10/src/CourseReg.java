import java.util.Iterator;

/*
/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   CourseReg.java
// Course:   CS 300 Fall 2022
//
// Author:   Reed Lokken
// Email:    RLokken@wisc.edu
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
 */

/**
 * A application handler for course registration using a priority queue.
 */
public class CourseReg {

  // data fields
  private CourseQueue courses;  // the priority queue of all courses
  private int creditLoad;       // the maximum number of credits you want to take
  
  /**
   * Creates a new course registration object
   * @param capacity the maximum number of courses to store in the priority queue
   * @param creditLoad the maximum number of credits to take next semester
   * @throws IllegalArgumentException if either capacity or creditLoad are not a positive integer
   */
  public CourseReg(int capacity, int creditLoad) throws IllegalArgumentException {
    // throw IllegalArgumentException if either capacity or creditLoad are not a positive integer
    if (capacity > 0 && creditLoad > 0) {
      throw new IllegalArgumentException("Capacity and creditLoad must be positive integers");
    }

    // construct a new CourseQueue with the given capacity and assign creditLoad
    this.courses = new CourseQueue(capacity);
    this.creditLoad = creditLoad;
  }
  
  /**
   * Returns a string representation of the highest-priority courses with a total number of credits
   * less than or equal to the creditLoad of this CourseReg object. Use the Iterable property of the
   * CourseQueue to help you out!
   * 
   * Note that this is NOT a "knapsack" problem - you're trying to maximize priority, not number of
   * credits. Just add courses to your result String until adding the next would take you over this
   * CourseReg object's creditLoad limit.
   * 
   * @return a string representation with one course on each line, where the total number of credits
   *   represented is less than or equal to the current creditLoad value
   */
  public String getRecommendedCourses() {
    CourseIterator iterableClasses = new CourseIterator(courses);
    Course currentCourse;
    String result = "";
    int currentCredits = 0;
    int nextCredits;

    // while more classes exist
    while (iterableClasses.hasNext()) {
      // get the next class
      currentCourse = iterableClasses.next();
      // calculate the number of credits if we add this class
      nextCredits = currentCredits + currentCourse.getNumCredits();

      // if adding this class would put us over the credit limit, stop
      if (nextCredits >= creditLoad) {
        break;
      }

      // else, add the class to the result string
      result += currentCourse.toString() + "\n";
      currentCredits = nextCredits; 
    }
    // remove the last newline character
    result = result.substring(0, result.length() - 1);
    return result;
  }
  
  /**
   * Tries to add the given course to the priority queue; return false if the queue is full
   * 
   * @param toAdd the course to add
   * @return true if the course was successfully added to the queue
   */
  public boolean add(Course toAdd) {
    // try to add the course to the queue
    try {
      courses.enqueue(toAdd);
      return true;
    // if the queue is full, return false
    } catch (IllegalStateException e) {}
    return false;
  }
  
  /**
   * Updates the creditLoad data field to the provided value
   * @param creditLoad the maximum number of credits to take next semester
   * @throws IllegalArgumentException if creditLoad is not a positive integer
   */
  public void setCreditLoad(int creditLoad) throws IllegalArgumentException {
    // throw IllegalArgumentException if creditLoad is not a positive integer
    if (creditLoad <= 0) {
      throw new IllegalArgumentException("CreditLoad must be a positive integer");
    }
    // update the creditLoad data field
    this.creditLoad = creditLoad;
  }
}
