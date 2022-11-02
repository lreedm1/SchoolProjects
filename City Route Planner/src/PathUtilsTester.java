
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
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class tests whether our methods in Intersection.java, Path.java, and
 * PathUtils.java work the way intended.
 */
public class PathUtilsTester {
  /**
   * This is the default constructoer for the PathUtilsTester class
   */
  public PathUtilsTester() {
  }

  /**
   * Tests the case of countPaths() when there are no valid Paths. For example,
   * when the start position is Intersection(1, 1) and the ending position is
   * Intersection(0, 1), there should be no valid Paths, so countPaths() should
   * return 0.
   * 
   * @param start the starting coordinate for the intersection
   * @param end   the ending coordinate for the intersection
   * @param count the number of paths from the start intersection to the end
   * @return returns true if the countPaths() method returns 0 when there are no
   *         paths, adnd false otherwise
   */
  public static boolean testCountPathsNoPath() {
    try {
      Intersection start = new Intersection(1, 1);
      Intersection end = new Intersection(0, 1);
      int count = PathUtils.countPaths(start, end);
      if (count != 0) {
        System.out.println("FAILED - testCountPathsNoPath() expected 0, but got " + count);
        return false;
      }
    } catch (Exception e) {
      System.out.println("FAILED - testCountPathsNoPath() threw the unexpected exception '" + e + "'");
      return false;
    }

    return true;
  }

  /**
   * Tests the case of countPaths() when there is a single valid Path. For
   * example, when the start position is Intersection(1, 1) and the ending
   * position is Intersection(1, 2), there should be a single Path, so
   * countPaths() should return 1.
   * 
   * @param start the starting coordinate for the intersection
   * @param end   the ending coordinate for the intersection
   * @param count the number of paths from the start intersection to the end
   * @return returns true if the countPaths() method returns 1 when there is a
   *         single path, and false otherwise
   */
  public static boolean testCountPathsOnePath() {
    try {
      Intersection start = new Intersection(1, 1);
      Intersection end = new Intersection(1, 2);
      int count = PathUtils.countPaths(start, end);
      if (count != 1) {
        System.out.println("FAILED - testCountPathsOnePath() failed: expected 1, but got " + count);
        return false;
      }
    } catch (Exception e) {
      System.out.println("FAILED - testCountPathsOnePath() failed: unexpected exception '" + e + "'");
      return false;
    }
    return true;
  }

  /**
   * Tests the case of countPaths() when there are multiple possible paths. For
   * example, when the start position is Intersection(0, 0) and the ending
   * position is Intersection(1, 2), there should be three possible Paths, so
   * countPaths() should return 3.
   * 
   * @param start the starting coordinate for the intersection
   * @param end   the ending coordinate for the intersection
   * @param count the number of paths from the start intersection to the end
   * @return returns true if the countPaths() method returns 3 when there are
   *         three paths, and false otherwise
   */
  public static boolean testCountPathsRecursive() {
    try {
      Intersection start = new Intersection(0, 0);
      Intersection end = new Intersection(1, 2);
      int count = PathUtils.countPaths(start, end);
      if (count != 3) {
        System.out.println("FAILED - testCountPathsRecursive() failed: expected 3, but got " + count);
        return false;
      }
    } catch (Exception e) {
      System.out.println("FAILED - testCountPathsRecursive() failed: unexpected exception '" + e + "'");
      return false;
    }
    return true;
  }

  /**
   * Tests the case of findAllPaths() when there are no valid Paths. For example,
   * when the start position is Intersection(1, 1) and the ending position is
   * Intersection(0, 1), there should be no valid Paths, so findAllPaths() should
   * return an empty ArrayList.
   * 
   * @param start the starting coordinate for the intersection
   * @param end   the ending coordinate for the intersection
   * @param paths the ArrayList of Paths from the start intersection to the end
   * @return returns true if the findAllPaths() method returns an empty ArrayList
   *         when there are no paths, and false otherwise
   */
  public static boolean testFindAllPathsNoPath() {
    try {
      Intersection start = new Intersection(1, 1);
      Intersection end = new Intersection(0, 1);
      ArrayList<Path> paths = PathUtils.findAllPaths(start, end);
      if (paths.size() != 0) {
        System.out.println("FAILED - testFindAllPathsNoPath() failed: expected 0, but got " + paths.size());
        return false;
      }
    } catch (Exception e) {
      System.out.println("FAILED - testFindAllPathsNoPath() failed: unexpected exception '" + e + "'");
      return false;
    }
    return true;
  }

  /**
   * Tests the case of findAllPaths() when there is a single valid Path. For
   * example, when the start position is Intersection(1, 1) and the ending
   * position is Intersection(1, 2), there should be a single Path. For each of
   * your cases, ensure that there is only a single path, and that the Path
   * exactly matches what you expect to see.
   * 
   * @param start the starting coordinate for the intersection
   * @param end   the ending coordinate for the intersection
   * @param paths the ArrayList of Paths from the start intersection to the end
   * @return returns true if the findAllPaths() method returns a single path when
   *         there is a single path, and false otherwise
   */
  public static boolean testFindAllPathsOnePath() {
    try {
      Intersection start = new Intersection(1, 1);
      Intersection end = new Intersection(1, 2);
      ArrayList<Path> paths = PathUtils.findAllPaths(start, end);
      if (paths.size() != 1) {
        System.out.println("FAILED - testFindAllPathsOnePath() failed: expected 1, but got " + paths.size());
        return false;
      }

    } catch (Exception e) {
      System.out.println("FAILED - testFindAllPathsOnePath() failed: unexpected exception '" + e + "'");
      return false;
    }
    return true;
  }

  /**
   * Tests the case of findAllPaths() when there are multiple possible paths. For
   * example, when the start position is Intersection(0, 0) and the ending
   * position is Intersection(1, 2), there should be three possible Paths. For
   * each of your cases, ensure that there is both the correct number of Paths,
   * and that the returned Paths exactly match what you expect to see.
   * Remember: The order the Paths appear in the output of findAllPaths() will not
   * necessarily match your own implementation.
   * 
   * @param start the starting coordinate for the intersection
   * @param end   the ending coordinate for the intersection
   * @param paths the ArrayList of Paths from the start intersection to the end
   * @return returns true if the findAllPaths() method returns the correct number
   *         of paths when there are multiple paths, and false otherwise
   */
  public static boolean testFindAllPathsRecursive() {
    try {
      Intersection start = new Intersection(0, 0);
      Intersection end = new Intersection(1, 2);
      ArrayList<Path> paths = PathUtils.findAllPaths(start, end);
      if (paths.size() != 3) {
        System.out.println("FAILED - testFindAllPathsRecursive() failed: expected 3, but got " + paths.size());
        return false;
      }
    } catch (Exception e) {
      System.out.println("FAILED - testFindAllPathsRecursive() failed: unexpected exception" + e);
      return false;
    }
    return true;
  }

  /**
   * Private helper method that executes all the tests and prints to the console
   * which tests passed and which failed.
   */
  private static void runAllTests() {
    boolean testsPassed = true;
    boolean testResult = true;

    System.out.println("-------------------------");
    System.out.println("Testing countPaths()...");

    testResult = testCountPathsNoPath();
    if (testResult) {
      System.out.println("PASSED - testCountPathsNoPath()");
    } else {
      testsPassed = false;
    }

    testResult = testCountPathsOnePath();
    if (testResult) {
      System.out.println("PASSED - testCountPathsOnePath()");
    } else {
      testsPassed = false;
    }

    testResult = testCountPathsRecursive();
    if (testResult) {
      System.out.println("PASSED - testCountPathsRecursive()");
    } else {
      testsPassed = false;
    }

    testResult = testFindAllPathsNoPath();
    if (testResult) {
      System.out.println("PASSED - testFindAllPathsNoPath()");
    } else {
      testsPassed = false;
    }

    testResult = testFindAllPathsOnePath();
    if (testResult) {
      System.out.println("PASSED - testFindAllPathsOnePath()");
    } else {
      testsPassed = false;
    }

    testResult = testFindAllPathsRecursive();
    if (testResult) {
      System.out.println("PASSED - testFindAllPathsRecursive()");
    } else {
      testsPassed = false;
    }

    if (testsPassed) {
      System.out.println("----------- ALL TESTS PASSED -----------");
    } else {
      System.out.println("----------- SOME TESTS FAILED ----------");
    }
  }

  public static void main(String[] args) {
    // runAllTests();
    try (Scanner keyboard = new Scanner(System.in)) {
      int startX, startY, endX, endY;
      String input = "Y";
      while (input.equalsIgnoreCase("Y")) {
        System.out.print("Enter starting X coordinate: ");
        startX = keyboard.nextInt();
        System.out.print("Enter starting Y coordinate: ");
        startY = keyboard.nextInt();
        System.out.print("Enter ending X coordinate: ");
        endX = keyboard.nextInt();
        System.out.print("Enter ending Y coordinate: ");
        endY = keyboard.nextInt();
        Intersection start = new Intersection(startX, startY);
        Intersection end = new Intersection(endX, endY);
        System.out.println("Number of paths from start to end: "
            + PathUtils.countPaths(start, end));
        System.out.println("List of possible paths:");
        for (Path p : PathUtils.findAllPaths(start, end)) {
          System.out.println(p);
        }
        do {
          System.out.print("Try another route? (Y/N): ");
          input = keyboard.next();
        } while (!input.equalsIgnoreCase("Y")
            && !input.equalsIgnoreCase("N"));
      }
    }

  }
}

