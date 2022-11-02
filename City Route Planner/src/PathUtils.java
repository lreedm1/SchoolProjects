
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

/**
 * This class models the recursive methods used to retrieve the count and
 * combination of paths that are available from one start point to an end point
 */
public class PathUtils {
  /**
   * This is the default constructor for the PathUtils class
   */
  public PathUtils() {
  }

  /**
   * counts the number of paths from the start intersection to the end
   * intersection
   * 
   * @param start the starting coordinate for the intersection
   * @param end   the ending coordinate for the intersection
   * @return the number of paths from the start intersection to the end
   *         intersection
   */
  public static int countPaths(Intersection start, Intersection end) {
    if (start.equals(end)) { // base case is when our start and end coordinates are the same
      return 1; // return 1 because there is only one path
    }
    if (start.getX() > end.getX() || start.getY() > end.getY()) {
      return 0; // if the start coordinate is greater than the end coordinate, return 0
    }

    int count = 0; // initialize count to 0
    count += countPaths(start.goNorth(), end); // add the number of paths from the start coordinate to the north of the
                                               // start coordinate to the end coordinate
    count += countPaths(start.goEast(), end); // add the number of paths from the start coordinate to the east of the
                                              // start coordinate to the end coordinate
    return count; // return the count
  }

  /**
   * find all paths from the start point to the end point
   * moving only north or east
   * 
   * @param start the starting coordinate for the intersection
   * @param end   the ending coordinate for the intersection
   * @return an ArrayList of all the paths from the start intersection to the end
   */
  public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
    ArrayList<Path> tempPaths = new ArrayList<Path>();

    if (start.equals(end)) { // base case is when our start and end point coordinates are the same
      Path newPath = new Path(); // create a new path
      newPath.addTail(start); // adds the start point to the path
      tempPaths.add(newPath); // adds the path to the ArrayList of paths
      return tempPaths; // returns the ArrayList of paths
    }

    if (end.getY() < start.getY() || end.getX() < start.getX()) { // ensures that we are within bounds of the point that
                                                                  // we are finding a path towards
      return tempPaths;
    }

    tempPaths.addAll(findAllPaths(start, end.goSouth())); // implements the recursive call findAllPaths to get the next
                                                          // intersection when moving south
    tempPaths.addAll(findAllPaths(start, end.goWest())); // implements the recursive call findAllPaths to get the next
                                                         // intersection when moving west

    addTails(end, tempPaths); // adds the end intersection to the end of each path
    return tempPaths;
  }

  /**
   * adds the end intersection to the end of each path in the ArrayList
   * 
   * @param point the intersection to be added to the end of each path
   * @param paths the ArrayList of paths to be added to the end of each path
   */
  private static void addTails(Intersection point, ArrayList<Path> paths) {
    for (Path path : paths) { // iterates through the ArrayList of paths
      if (path.length() > 0) { // ensures that the path is not empty
        path.addTail(point); // adds the end intersection to the end of the path
      }
    }
  }
}
