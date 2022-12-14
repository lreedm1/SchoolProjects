/*
/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   CourseRegTester.java
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
 * This class implements unit test methods to check the correctness of Course,  CourseIterator, 
 * CourseQueue and CourseReg classes in P10.
 * 
 * Be aware that all methods in this class will be run against not only your code, but also our own
 * working and broken implementations to verify that your tests are working appropriately!
 */
public class CourseRegTester {
  
  /**
   * START HERE, and continue with testCompareTo() after this.
   * 
   * This method must test the Course constructor, accessor, and mutator methods, as well as its
   * toString() implementation. The compareTo() method will get its own test.
   * 
   * @see Course
   * @return true if the Course implementation is correct; false otherwise
   */
  public static boolean testCourse() {
    try{
      // test constructor throws IllegalArgumentException for invalid seats available (negative)
      try {
        new Course("CS", 300, 3, -1);
        System.out.println("constructor failed to throw IllegalArgumentException for negative seats");
        return false;
      } catch (IllegalArgumentException e) {
        // do nothing
      }

      // create a valid course with seats available and no professor
      Course c2 = new Course("CS", 300, 3, 3);
      
      // test getNumCredits()
      if (c2.getNumCredits() != 3){
        System.out.println("getNumCredits() failed to return the correct number of credits");
        return false;
      }
      
      // test toString()
      if (c2.toString().equals("CS 300 (3 seats)") == false){
        System.out.println("failed to construct & print a valid course, instead printed: " + c2.toString());
        return false;
      }

      // test setProfessor() by setting a professor with a non-null name and invalid rating (0-5)
      // which should throw an IllegalArgumentException
      try{
        c2.setProfessor("Hobbes", 6);
        System.out.println("setProfessor() failed to throw IllegalArgumentException for a valid name and an invalid rating");
        return false;
      } catch (IllegalArgumentException e){
        // do nothing
      }

      // test setProfessor() does not set the rating if the professor name is null
      
      c2.setProfessor(null, 5);
      if (c2.toString().equals("CS 300 (3 seats)") == false){
        System.out.println("setProfessor() failed when professor name is null, instead printed: " + c2.toString() + "|");
        return false;
      }

      // test setProfessor() sets the professor name and rating when the professor name is not null and the rating is valid
      c2.setProfessor("Hobbes", 5);
      if (c2.toString().equals("CS 300 (3 seats) with Hobbes (5.0)") == false){
        System.out.println("setProfessor() failed to set the professor name and rating when the professor name is not null and the rating is valid"
            + " instead printed: " + c2.toString());
        return false;
      }
      
      // test setSeatsAvailable() throws IllegalArgumentException for invalid seats available (negative)
      try {
        c2.setSeatsAvailable(-1);
        System.out.println("setSeatsAvailable() failed to throw IllegalArgumentException for negative seats");
        return false;
      } catch (IllegalArgumentException e) {
        // do nothing
      }

      // test setSeatsAvailable() sets the seats available when the seats available is valid
      c2.setSeatsAvailable(3);
      if (c2.toString().equals("CS 300 (3 seats) with Hobbes (5.0)") == false){
        System.out.println("setSeatsAvailable() failed to set the seats available when the seats available is valid"
            + " instead printed: " + c2.toString());
        return false;
      }

      // test toString() when seats available is 0
      c2.setSeatsAvailable(0);
      if (c2.toString().equals("CS 300 (closed) with Hobbes (5.0)") == false){
        System.out.println("toString() failed when seats available is 0");
        return false;
      }

      // test equals() when the courses are equal
      Course c3 = new Course("CS", 300, 3, 1);
      c3.setProfessor("Hobbes", 5);

      Course c4 = new Course("CS", 300, 3, 1);
      c4.setProfessor("Hobbes", 5);

      if (c3.equals(c4) == false){
        System.out.println("equals() failed when the courses are equal");
        return false;
      }

      // test equals() when professor names are not equal
      c4.setProfessor("Mouna", 5);
      if (c3.equals(c4) == true){
        System.out.println("equals() failed when professor names are not equal");
        return false;
      }

      // test equals() when professor ratings are not equal
      c4.setProfessor("Hobbes", 4);
      if (c3.equals(c4) == true){
        System.out.println("equals() failed when professor ratings are not equal");
        return false;
      }

      // test equals() when course numbers are not equal
      c4 = new Course("CS", 400, 3, 1);
      c4.setProfessor("Hobbes", 5);
      if (c3.equals(c4) == true){
        System.out.println("equals() failed when course numbers are not equal");
        return false;
      }

      // test compareTo when the courses are equal
      Course c5 = new Course("CS", 300, 3, 1);
      c5.setProfessor("Hobbes", 5);
      Course c6 = new Course("CS", 300, 3, 1);
      c6.setProfessor("Hobbes", 5);
      if (c5.compareTo(c6) != 0){
        System.out.println("compareTo() failed when the courses are equal");
        return false;
      }

      // test compareTo when the first course has deptName CS and the second course has deptName ECE
      Course c7 = new Course("ECE", 300, 3, 1);
      if (c5.compareTo(c7) <= 0){
        System.out.println("compareTo() failed when the first course has deptName CS and the second course has deptName ECE");
        return false;
      }

      // test compareTo when the first course has seats and the second course has no seats
      Course c9 = new Course("CS", 300, 3, 3);
      Course c10 = new Course("CS", 300, 3, 0);
      if (c9.compareTo(c10) <= 0){
        System.out.println("compareTo() failed when the first course has seats and the second course has no seats");
        return false;
      }
      
      // test compareTo when the first course has a non-null professor name and the second course has a null professor name
      Course c11 = new Course("CS", 300, 3, 1);
      c11.setProfessor("Hobbes", 5);
      Course c12 = new Course("CS", 300, 3, 1);
      if (c11.compareTo(c12) <= 0){
        System.out.println("compareTo() failed when the first course has a non-null professor name and the second course has a null professor name");
        return false;
      }

      // test compareTo when the first course has a higher professor rating than the second course
      Course c13 = new Course("CS", 300, 3, 1);
      c13.setProfessor("Hobbes", 5);
      Course c14 = new Course("CS", 300, 3, 1);
      c14.setProfessor("Hobbes", 4);
      if (c13.compareTo(c14) <= 0){
        System.out.println("compareTo() failed when the first course has a higher professor rating than the second course");
        return false;
      }

    } catch (Exception e){
      System.out.println("Unexpected exception" + e.getMessage());
      return false;
    }
    return true;
  }
  
  /**
   * This method must test the Course compareTo() implementation. Be sure to test ALL FOUR levels
   * of the comparison here!
   * 
   * Once you complete this test, finish the Course implementation if you have not done so already,
   * then move to testCourseQueue() and testEnqueueDequeue().
   * 
   * @see Course#compareTo(Course)
   * @return true if the compareTo() implementation is correct; false otherwise
   */
  public static boolean testCompareTo() {
    return false; // TODO: complete this test
  }
  
  /**
   * This method must test the other methods in CourseQueue (isEmpty, size, peek). Verify normal 
   * cases and error cases, as well as a filled and re-emptied queue.
   * 
   * Once you have completed this method, implement the required methods in CourseQueue and verify
   * that they work correctly.
   * 
   * @see CourseQueue
   * @return true if CourseQueue's other methods are implemented correctly; false otherwise
   */
  public static boolean testCourseQueue() {
    return false; // TODO: complete this test
  }
  
  /**
   * This method must test the enqueue and dequeue methods in CourseQueue. Verify normal cases and
   * error cases, as well as filling and emptying the queue.
   * 
   * You may also test the percolate methods directly, though this is not required.
   * 
   * Once you have completed this method, implement the enqueue/dequeue and percolate methods in
   * CourseQueue and verify that they work correctly, then move on to testCourseIterator().
   * 
   * @see CourseQueue#enqueue(Course)
   * @see CourseQueue#dequeue()
   * @return true if the CourseQueue enqueue/dequeue implementations are correct; false otherwise
   */
  public static boolean testEnqueueDequeue() {
    return false; // TODO: complete this test
  }
  
  /**
   * This method must test the CourseIterator class. The CourseIterator iterates through a deep copy
   * of a CourseQueue in decreasing order of priority, returning each Course object in turn.
   * 
   * Once you have completed this method, implement the CourseIterator class and make CourseQueue
   * into an Iterable class. Verify that this works correctly, and then move on to the final test
   * method: testCourseReg().
   * 
   * @see CourseIterator
   * @return true if the CourseIterator implementation is correct; false otherwise
   */
  public static boolean testCourseIterator() {
    return false; // TODO: complete this test
  }
  
  /**
   * This method must test the constructor and three methods of the CourseReg class (setCreditLoad,
   * add, and getRecommendedCourses). Verify normal cases and error cases.
   * 
   * Once you have completed this method, implement CourseReg and verify that it works correctly.
   * Then you're DONE! Save and submit to gradescope, and enjoy being DONE with programming
   * assignments in CS 300 !!!
   * 
   * @see CourseReg
   * @return true if CourseReg has been implemented correctly; false otherwise
   */
  public static boolean testCourseReg() {
    return false; // TODO: complete this test
  }
  
  /**
   * This method calls all test methods defined by us; you may add additional methods to this if
   * you like. All test methods must be public static boolean.
   * 
   * @return true if all tests in this class return true; false otherwise
   */
  public static boolean runAllTests() {
    boolean testVal = true;
    
    // test Course
    System.out.print("testCourse(): ");
    if (!testCourse()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }
    
    // test compareTo
    System.out.print("testCompareTo(): ");
    if (!testCompareTo()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }
    
    // test CourseIterator
    System.out.print("testCourseIterator(): ");
    if (!testCourseIterator()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }
    
    // test CourseQueue enqueue/dequeue
    System.out.print("testEnqueueDequeue(): ");
    if (!testEnqueueDequeue()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }
    
    // test CourseQueue
    System.out.print("testCourseQueue(): ");
    if (!testCourseQueue()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }
    
    // test CourseReg
    System.out.print("testCourseReg(): ");
    if (!testCourseReg()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }
    
    return testVal;
  }
  
  /**
   * Calls runAllTests() so you can verify your program
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    runAllTests();
  }
}
